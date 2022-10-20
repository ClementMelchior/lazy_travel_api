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

        List <JourneyModel> journeys = journeyInterface.findJourney(new CityModel("11", "Montpellier", "",  "3DFRMPL", "7CFRmontpell%40spfb1", "43.610769", "3.876716"), new CityModel("2", "Lyon", "",  "3DFRLYS", "7CFRlyon____%40u05kq", "45.764043", "4.835659"), "2022-11-20", "17:00", 150);

        for (JourneyModel journey : journeys) {
            System.out.println(journey);
            System.out.println("--------------------------- OTHER ---------------------------");

        }

        // tester le journey
    }
}
