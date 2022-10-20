package com.idovia.api.lazy_travel_api.external_api.journey.kelbillet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.model.TicketKelbilletModel;

public interface KelBilletInterface {
    
    public List<TicketKelbilletModel> findAllTicketKelbillet(CityModel cityDeparture, CityModel cityArrival, String date, String hour, int maxTimeTravel) throws ParseException, ExecutionRequestException, StreamReadException, DatabindException, MalformedURLException, IOException;

    public List<TicketKelbilletModel> findAllTicketKelbilletBestMatch(CityModel cityDeparture, CityModel cityArrival, String date, String hour, int maxTimeTravel) throws ParseException, ExecutionRequestException, StreamReadException, DatabindException, MalformedURLException, IOException;


}
