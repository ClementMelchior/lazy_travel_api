package com.idovia.api.lazy_travel_api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.model.LazyTravelRequestModel;
import com.idovia.api.lazy_travel_api.model.LazyTravelResponseModel;
import com.idovia.api.lazy_travel_api.service.LazyTravelService;

// DEmain : ajouter latitude et longitude partout, et essayer de lancer la machine!!! pawwwww


public class LazyTravelMain {

    public static void main(String[] args) throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException {
        LazyTravelInterface lazyTravelInterface = new LazyTravelService();
        CityModel departureCity = new CityModel("2", "Lyon", "", "3DFRLYS", "7CFRlyon____%40u05kq", "45.764043", "4.835659");
        String departureDate="2022-11-19";
        String departureHour="06:00";
        String arrivalDate="2022-11-20";
        String arrivalHour="17:00";
        int nbrPerson=2;

        List <LazyTravelResponseModel> responses = lazyTravelInterface.findTravel(new LazyTravelRequestModel(departureCity, departureDate, departureHour,
            arrivalDate, arrivalHour, nbrPerson));

        System.out.println("--------------------------- TRAVEL ---------------------------");

        for (LazyTravelResponseModel lr : responses) {
            System.out.println(lr);
            System.out.println("PRICE FOR " + nbrPerson + " : "+lr.getPrice());

            System.out.println("--------------------------- " + lr.getCityDeparture().getName() + " - " + lr.getCityArrival().getName() + " ---------------------------");

        }
        
	}
    
}
