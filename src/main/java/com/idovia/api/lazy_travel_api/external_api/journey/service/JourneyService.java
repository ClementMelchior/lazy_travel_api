package com.idovia.api.lazy_travel_api.external_api.journey.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.journey.JourneyInterface;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.KelBilletInterface;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.model.TicketKelbilletModel;
import com.idovia.api.lazy_travel_api.external_api.journey.model.JourneyModel;

@Service
public class JourneyService implements JourneyInterface {

    @Autowired
    private KelBilletInterface kelBilletInterface;


    public List <JourneyModel> findJourney (CityModel cityDeparture, CityModel cityArrival, String date, String hour, int maxTimeTravel) throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException {
        List<TicketKelbilletModel> kelbillets = new ArrayList<>();
        kelbillets = kelBilletInterface.findAllTicketKelbilletBestMatch(cityDeparture, cityArrival, date, hour, maxTimeTravel);
        
        return kelbillets.stream().map(k -> new JourneyModel("train", k.getDeparture_name(), k.getDeparture_date(), k.getDuration(), Double.parseDouble(k.getPrice()), k.getArrival_name(), k.getArrival_date())).collect(Collectors.toList());
    }

    
}
