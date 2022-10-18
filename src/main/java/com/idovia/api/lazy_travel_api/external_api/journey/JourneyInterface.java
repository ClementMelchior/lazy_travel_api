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

public interface JourneyInterface {

    public List <JourneyModel> findJourney (CityModel cityDeparture, CityModel cityArrival, String date, String hour, int maxTimeTravel) throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException;
    
}
