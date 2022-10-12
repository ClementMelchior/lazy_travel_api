package com.idovia.api.lazy_travel_api.archive.tictitrip;

import java.text.ParseException;
import java.util.List;

import com.idovia.api.lazy_travel_api.city.model.CityModel;
import com.idovia.api.lazy_travel_api.archive.model.TrainJourneyModel;

public interface TrainJourneyInterface {

    // return list of six train journey
    public List <TrainJourneyModel> findTrainJourneys (CityModel cityDeparture, CityModel cityArrival, String date) throws InterruptedException;

    // return the train journey with lower price
    public TrainJourneyModel findTrainJourneyBestMatch (CityModel cityDeparture, CityModel cityArrival, String date) throws InterruptedException;

    // return the train journey lower price for a given max time travel
    public TrainJourneyModel findTrainJourneyBestMatch (CityModel cityDeparture, CityModel cityArrival, String date, long maxTimeTravel) throws InterruptedException, ParseException;


}

