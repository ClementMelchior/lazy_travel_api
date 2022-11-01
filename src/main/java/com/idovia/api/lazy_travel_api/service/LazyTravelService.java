package com.idovia.api.lazy_travel_api.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.LazyTravelInterface;
import com.idovia.api.lazy_travel_api.external_api.guru.GuruInterface;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.guru.repository.CityRepository;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.HotelPlanerInterface;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.external_api.journey.model.JourneyModel;
import com.idovia.api.lazy_travel_api.external_api.journey.JourneyInterface;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.model.LazyTravelRequestModel;
import com.idovia.api.lazy_travel_api.model.LazyTravelResponseModel;

@Service
public class LazyTravelService implements LazyTravelInterface{

    @Autowired
    private GuruInterface guruInterface;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private HotelPlanerInterface hotelPlanerInterface;
    @Autowired
    private JourneyInterface JourneyInterface;

    public LazyTravelService () {

    }


    public List <LazyTravelResponseModel> findTravel (LazyTravelRequestModel request) throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException {
        List <LazyTravelResponseModel> responses = new ArrayList<LazyTravelResponseModel>();

        CityModel cityDeparture = cityRepository.findByName(request.getDepartureCity());

        System.out.println(cityDeparture);

        List <CityModel> destinations = this.guruInterface.findAllNearbyCityByTimeTravel(cityDeparture, 50, 100);

        List <JourneyModel> goingJourney;
        List <JourneyModel> commingJourney;
        List <HotelPlannerModel> hotels;

        int pourcent = 100/destinations.size();
        int pourcentProgress = 0;


        for (CityModel city : destinations) {   
            pourcentProgress=pourcentProgress+pourcent;   
            System.out.println(pourcentProgress+"%");      
            goingJourney = JourneyInterface.findJourney(cityDeparture, city, request.getDepartureDate(), request.getDepartureHour(), 150);
            commingJourney = JourneyInterface.findJourney(city, cityDeparture, request.getArrivalDate(), request.getArrivalHour(), 150);
            hotels = hotelPlanerInterface.findAllHotelBestMatch(city, request.getDepartureDate(), request.getArrivalDate());
            if (goingJourney.size()!=0 && commingJourney.size()!=0 && hotels.size()!=0) {
                LazyTravelResponseModel ltr = new LazyTravelResponseModel(cityDeparture, city, goingJourney, commingJourney, hotels);
                responses.add(ltr);
                ltr.setPrice(request.getNbrPerson());            
            }
            else {
                if (goingJourney.size()==0) {System.out.println("No train to go to "+city.getName());}
                if (commingJourney.size()==0) {System.out.println("No train to come back from "+city.getName());}
                if (hotels.size()==0) {System.out.println("No hotel at "+city.getName());}
            }
        }

        return responses;
    }
    
}
