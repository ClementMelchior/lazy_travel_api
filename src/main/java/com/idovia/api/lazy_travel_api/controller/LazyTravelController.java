package com.idovia.api.lazy_travel_api.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.LazyTravelInterface;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.model.LazyTravelRequestModel;
import com.idovia.api.lazy_travel_api.model.LazyTravelResponseModel;

@RestController
public class LazyTravelController {

    @Autowired
    private LazyTravelInterface lazyTravelInterface;

    @GetMapping("/lazy-travel-api/findTravel")
    public List <LazyTravelResponseModel> findTravel() throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException {

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
        return responses;
    }
    
}
