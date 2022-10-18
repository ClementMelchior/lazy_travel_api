package com.idovia.api.lazy_travel_api.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.LazyTravelInterface;
import com.idovia.api.lazy_travel_api.external_api.guru.GuruInterface;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.guru.service.GuruService;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.HotelPlanerInterface;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.service.HotelPlannerService;
import com.idovia.api.lazy_travel_api.external_api.journey.model.JourneyModel;
import com.idovia.api.lazy_travel_api.external_api.journey.service.JourneyService;
import com.idovia.api.lazy_travel_api.external_api.journey.JourneyInterface;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.model.LazyTravelRequestModel;
import com.idovia.api.lazy_travel_api.model.LazyTravelResponseModel;

public class LazyTravelService implements LazyTravelInterface{

    private GuruInterface guruInterface = new GuruService();
    private HotelPlanerInterface hotelPlanerInterface = new HotelPlannerService();
    private JourneyInterface JourneyInterface = new JourneyService();


    public List <LazyTravelResponseModel> findTravel (LazyTravelRequestModel request) throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException {
        List <LazyTravelResponseModel> responses = new ArrayList<LazyTravelResponseModel>();
        List <CityModel> destinations = guruInterface.findAllNearbyCityByTimeTravel(request.getDepartureCity(), 50, 100);

        List <JourneyModel> goingJourney;
        List <JourneyModel> commingJourney;
        List <HotelPlannerModel> hotels;

        int pourcent = 100/destinations.size();
        int pourcentProgress = 0;


        for (CityModel city : destinations) {   
            pourcentProgress=pourcentProgress+pourcent;   
            System.out.println(pourcentProgress+"%");      
            goingJourney = JourneyInterface.findJourney(request.getDepartureCity(), city, request.getDepartureDate(), request.getDepartureHour(), 120);
            commingJourney = JourneyInterface.findJourney(city, request.getDepartureCity(), request.getArrivalDate(), request.getArrivalHour(), 120);
            hotels = hotelPlanerInterface.findAllHotelBestMatch(city, request.getDepartureDate(), request.getArrivalDate());
            if (goingJourney.size()!=0 && commingJourney.size()!=0 && hotels.size()!=0) {
                LazyTravelResponseModel ltr = new LazyTravelResponseModel(request.getDepartureCity(), city, goingJourney, commingJourney, hotels);
                responses.add(ltr);
                ltr.setPrice(request.getNbrPerson());            
            }
        }

        return responses;
    }
    
}
