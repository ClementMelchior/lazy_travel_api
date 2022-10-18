package com.idovia.api.lazy_travel_api.external_api.journey;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.external_api.journey.model.JourneyModel;
import com.idovia.api.lazy_travel_api.external_api.journey.service.JourneyService;

public class JourneyMain {
    public static void main(String[] args) throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException {
        JourneyInterface journeyInterface = new JourneyService();

        List <JourneyModel> journeys = journeyInterface.findJourney(new CityModel("1", "Paris", "3DFRPAR", "7CFRparis___%40u09tv", "48.856614", "2.3522219"), new CityModel("12", "Lille", "3DFRLIL", "7CFRlille___%40u140n", "50.62925", "3.057256"), "2022-10-29", "06:00", 120);

        for (JourneyModel journey : journeys) {
            System.out.println(journey);
            System.out.println("--------------------------- OTHER ---------------------------");

        }

        // tester le journey
    }
}
