package com.idovia.api.lazy_travel_api.external_api.journey;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.journey.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.external_api.journey.model.JourneyModel;
import com.idovia.api.lazy_travel_api.external_api.journey.model.TicketKelbilletModel;

public interface JourneyInterface {
    
    public List<TicketKelbilletModel> findAllJourney(CityModel cityDeparture, CityModel cityArrival, String date, String hour, int maxTimeTravel) throws ParseException, ExecutionRequestException, StreamReadException, DatabindException, MalformedURLException, IOException;

    public CompletableFuture<List<JourneyModel>> findAllJourneyBestMatch(CityModel cityDeparture, CityModel cityArrival, String date, String hour, int maxTimeTravel) throws ParseException, ExecutionRequestException, StreamReadException, DatabindException, MalformedURLException, IOException;


}
