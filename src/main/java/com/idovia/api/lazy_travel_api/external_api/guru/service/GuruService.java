package com.idovia.api.lazy_travel_api.external_api.guru.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idovia.api.lazy_travel_api.external_api.guru.GuruInterface;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.guru.model.GuruResponse;
import com.idovia.api.lazy_travel_api.external_api.guru.model.StationModel;
import com.idovia.api.lazy_travel_api.external_api.guru.repository.CityRepository;
import com.idovia.api.lazy_travel_api.external_api.guru.repository.StationRepository;

@Service
public class GuruService implements GuruInterface {

    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private CityRepository cityRepository;
    
    // Return all nearby city form given city

    public List<CityModel> findAllNearbyCity(CityModel city) throws StreamReadException, DatabindException, MalformedURLException, IOException {
        List <StationModel> stationsRequested = stationRepository.findAllByIdCity(city.getId());
        List <GuruResponse> gurus = new ArrayList<GuruResponse>();


        for (StationModel s : stationsRequested) {
            gurus.addAll(findAllNearbyCity(s));
        }
        List <StationModel> stationsMatchingGurus = guruResponseToStationModel(gurus);

        if (stationsMatchingGurus.size()!=0) {
            List <CityModel> citiesMatchingStations = stationsResponseToCityModel(stationsMatchingGurus);
            if (citiesMatchingStations.size()!=0) {
                return citiesMatchingStations;
            }
        }
        return null;
    }

    public List<CityModel> findAllNearbyCityByTimeTravel (CityModel city, int minTimeTravel, int maxTimeTravel) throws StreamReadException, DatabindException, MalformedURLException, IOException {
        List <StationModel> stationsRequested = stationRepository.findAllByIdCity(city.getId());
        List <GuruResponse> gurus = new ArrayList<GuruResponse>();
        List <GuruResponse> gurusReduced = new ArrayList<GuruResponse>();


        for (StationModel s : stationsRequested) {
            gurus.addAll(findAllNearbyCity(s));
        }

        if (gurus.size()>0) {
            gurusReduced = gurus.stream().filter(g -> g.getDuration() <= maxTimeTravel && g.getDuration() >= minTimeTravel).collect(Collectors.toList());
        }

        List <StationModel> stationsMatchingGurus = guruResponseToStationModel(gurusReduced);

        if (stationsMatchingGurus.size()!=0) {
            List <CityModel> citiesMatchingStations = stationsResponseToCityModel(stationsMatchingGurus);
            if (citiesMatchingStations.size()!=0) {
                return citiesMatchingStations;
            }
        }
        return null;
    }

    private List<StationModel> guruResponseToStationModel(List<GuruResponse> gurus) {
        List <StationModel> stations = stationRepository.findAll();
        return stations.stream().filter(s -> gurus.stream().anyMatch(g -> g.getId().equals(s.getIdGuru()))).collect(Collectors.toList());
    }

    private List<CityModel> stationsResponseToCityModel(List<StationModel> stations) {
        List <CityModel> cities = cityRepository.findAll();
        return cities.stream().filter(c -> stations.stream().anyMatch(s -> s.getIdCity().equals(c.getId()))).collect(Collectors.toList());
    }

    public List<GuruResponse> findAllNearbyCity(StationModel station) throws StreamReadException, DatabindException, MalformedURLException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(new URL(this.getCustomUrl(station)), GuruResponse[].class));
    }

    
    private String getCustomUrl (StationModel station) {
        return "https://api.direkt.bahn.guru/" + station.getIdGuru() + "?localTrainsOnly=false&v=4";
    }
}
