package com.idovia.api.lazy_travel_api.archive.tictitrip;


import com.idovia.api.lazy_travel_api.archive.tictitrip.service.TrainJourneyService;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;

public class TrainJourneyMain {
    public static void main(String[] args) throws InterruptedException {
        
        TrainJourneyInterface tj = new TrainJourneyService();
        tj.findTrainJourneys(new CityModel(), new CityModel(), "date");
        

 
    }
}
