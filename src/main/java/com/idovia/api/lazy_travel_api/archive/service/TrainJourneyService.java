package com.idovia.api.lazy_travel_api.archive.service;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.journey.train_journey.TrainJourneyInterface;

public class TrainJourneyService implements TrainJourneyInterface {

    @Override
    public TrainJourneyInterface findTrainJourney(CityModel dityDeparture, CityModel cityArrival, String Date,
            String hour, int maxTimeTravel) {
                

                return null;
    }
    
}
