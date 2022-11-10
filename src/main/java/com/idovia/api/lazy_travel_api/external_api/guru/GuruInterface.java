package com.idovia.api.lazy_travel_api.external_api.guru;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;

public interface GuruInterface {

    // Guru reponse 

    public List<CityModel> findAllNearbyCity (CityModel city) throws StreamReadException, DatabindException, MalformedURLException, IOException;

    public List<CityModel> findAllNearbyCityByTimeTravel (CityModel city, int minTimeTravel, int maxTimeTravel) throws StreamReadException, DatabindException, MalformedURLException, IOException;
    
}
