package com.idovia.api.lazy_travel_api.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
import com.idovia.api.lazy_travel_api.external_api.journey.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.model.LazyTravelRequestModel;
import com.idovia.api.lazy_travel_api.model.LazyTravelResponseCompletableFutureModel;
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
    private JourneyInterface journeyInterface;

    public LazyTravelService () {

    }


    public List <LazyTravelResponseModel> findTravel (LazyTravelRequestModel request) throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException, InterruptedException, ExecutionException {
        List <LazyTravelResponseModel> responses = new ArrayList<LazyTravelResponseModel>();
        System.out.println(request.getDepartureCity());

        CityModel cityDeparture = cityRepository.findByName(request.getDepartureCity());
        List <CityModel> destinations = this.guruInterface.findAllNearbyCityByTimeTravel(cityDeparture, 50, 100);

        int pourcent = 100/destinations.size();
        int pourcentProgress = 0;

        CompletableFuture <List <LazyTravelResponseCompletableFutureModel>> responsesCompletableFuture = findTravelAsync(request, destinations, cityDeparture);

        for (LazyTravelResponseCompletableFutureModel response : responsesCompletableFuture.get()) {  
            
            pourcentProgress=pourcentProgress+pourcent;   
            System.out.println(pourcentProgress+"%");
            
            if (response.getGoingJourney().get().size()!=0 && response.getCommingJourney().get().size()!=0 && response.getHotel().get().size()!=0) {
                LazyTravelResponseModel ltr = new LazyTravelResponseModel(response);
                responses.add(ltr);
                ltr.setPrice(request.getNbrPerson());            
            }
            else {
                if (response.getGoingJourney().get().size()!=0) {System.out.println("No train to go to "+response.getCityDeparture().getName());}
                if (response.getCommingJourney().get().size()!=0) {System.out.println("No train to come back from "+response.getCityDeparture().getName());}
                if (response.getHotel().get().size()!=0) {System.out.println("No hotel at "+response.getCityDeparture().getName());}
            }
        }

        return responses;
    }

    @Async
    public CompletableFuture<List <LazyTravelResponseCompletableFutureModel>> findTravelAsync (LazyTravelRequestModel request, List <CityModel> destinations, CityModel cityDeparture) throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException, InterruptedException, ExecutionException {
        List <LazyTravelResponseCompletableFutureModel> responses = new ArrayList<>();

        CompletableFuture<List <JourneyModel>> goingJourney;
        CompletableFuture<List <JourneyModel>> commingJourney;
        CompletableFuture<List <HotelPlannerModel>> hotels;
        
        for (CityModel city : destinations) {   

            hotels = hotelPlanerInterface.findAllHotelBestMatch(city, request.getDepartureDate(), request.getArrivalDate());
            goingJourney = journeyInterface.findAllJourneyBestMatch(cityDeparture, city, request.getDepartureDate(), request.getDepartureHour(), 150);
            commingJourney = journeyInterface.findAllJourneyBestMatch(city, cityDeparture, request.getArrivalDate(), request.getArrivalHour(), 150);

            responses.add(new LazyTravelResponseCompletableFutureModel(cityDeparture, city, goingJourney, commingJourney, hotels));
        }
        return CompletableFuture.completedFuture(responses);

    }
    
}
