package com.idovia.api.lazy_travel_api.city.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idovia.api.lazy_travel_api.city.CityInterface;
import com.idovia.api.lazy_travel_api.city.model.CityModel;
import com.idovia.api.lazy_travel_api.city.model.StationModel;
import com.idovia.api.lazy_travel_api.city.repository.CityRepository;
import com.idovia.api.lazy_travel_api.city.repository.StationRepository;
import com.idovia.api.lazy_travel_api.guru.model.GuruResponse;

@Service
public class CityService implements CityInterface {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StationRepository stationRepository;



    public List <StationModel> transformGuruResponseToStation (List <GuruResponse> gurus) {
        List <StationModel> stations = stationRepository.findAll();
        return stations.stream().filter(station -> gurus.stream().anyMatch(guru -> guru.getId()==station.getIdGuru())).collect(Collectors.toList());
    }

    public List<CityModel> transformStationToCity (List <StationModel> stations) {
        List <CityModel> cities = cityRepository.findAll();
        return cities.stream().filter(city -> stations.stream().anyMatch(station -> station.getIdCity()==city.getId())).collect(Collectors.toList());
    }







    
}
