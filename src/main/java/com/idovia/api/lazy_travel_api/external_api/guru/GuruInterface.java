package com.idovia.api.lazy_travel_api.external_api.guru;

import java.util.List;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;

public interface GuruInterface {

    // Guru reponse 

    public List<CityModel> findAllNearbyCity (CityModel city);

    public List<CityModel> findAllNearbyCityByTimeTravel (CityModel city, int minTimeTravel, int maxTimeTravel);
    
}
