package com.idovia.api.lazy_travel_api.external_api.journey.train_journey;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;

public interface TrainJourneyInterface {

    public TrainJourneyInterface findTrainJourney (CityModel dityDeparture, CityModel cityArrival, String Date, String hour, int maxTimeTravel);
    
}
