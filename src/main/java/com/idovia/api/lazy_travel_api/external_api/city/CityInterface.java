package com.idovia.api.lazy_travel_api.external_api.city;

import java.util.List;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.guru.model.GuruResponse;
import com.idovia.api.lazy_travel_api.external_api.guru.model.StationModel;

public interface CityInterface {


    public List <StationModel> transformGuruResponseToStation (List <GuruResponse> gurus);
    public List<CityModel> transformStationToCity (List <StationModel> stations);


    
}