package com.idovia.api.lazy_travel_api.external_api.guru.service;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.guru.model.StationModel;
import com.idovia.api.lazy_travel_api.external_api.guru.repository.CityRepository;
import com.idovia.api.lazy_travel_api.external_api.guru.repository.StationRepository;

public class CityStationService {

    private StationRepository stationRepository;
    private CityRepository cityRepository;

    public CityModel findAllCityByStation (StationModel station) {
        return cityRepository.findById(station.getIdCity());
    }
}
