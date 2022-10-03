package com.idovia.api.lazy_travel_api.train_journey.tictitrip;


import com.idovia.api.lazy_travel_api.city.model.CityModel;
import com.idovia.api.lazy_travel_api.train_journey.tictitrip.service.TrainJourneyService;

public class TrainJourneyMain {
    public static void main(String[] args) throws InterruptedException {
        
        TrainJourneyInterface tj = new TrainJourneyService();
        tj.findTrainJourneys(new CityModel(), new CityModel(), "date");
        

 
    }
}
