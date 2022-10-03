package com.idovia.api.lazy_travel_api.city;

import java.util.List;

import com.idovia.api.lazy_travel_api.city.model.CityModel;
import com.idovia.api.lazy_travel_api.city.model.StationModel;
import com.idovia.api.lazy_travel_api.guru.model.GuruResponse;

public interface CityInterface {


    public List <StationModel> transformGuruResponseToStation (List <GuruResponse> gurus);
    public List<CityModel> transformStationToCity (List <StationModel> stations);


    
}