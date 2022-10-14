package com.idovia.api.lazy_travel_api.external_api.guru.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idovia.api.lazy_travel_api.external_api.guru.GuruInterface;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.guru.model.GuruResponse;
import com.idovia.api.lazy_travel_api.external_api.guru.model.StationModel;
import com.idovia.api.lazy_travel_api.external_api.guru.repository.CityRepository;
import com.idovia.api.lazy_travel_api.external_api.guru.repository.StationRepository;

public class GuruService implements GuruInterface {

    //@Autowired
    //private StationRepository stationRepository;
    private final String URLbegin = "https://api.direkt.bahn.guru/";
    private final String URLend = "?localTrainsOnly=false&v=4";
    private CityStationService cityStationService;
    private StationRepository stationRepository;
    private CityRepository cityRepository;


    public GuruService () {
        this.cityStationService = new CityStationService();
        this.stationRepository = new StationRepository();
        this.cityRepository = new CityRepository();
    }
    
    // Return all nearby city form given city

    public List<CityModel> findAllNearbyCity(CityModel city) {
        List <StationModel> stationsRequested = stationRepository.findAllByIdCity(city.getId());
        List <StationModel> stations = stationRepository.findAll();
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

    public List<CityModel> findAllNearbyCityByTimeTravel (CityModel city, int minTimeTravel, int maxTimeTravel) {
        List <StationModel> stationsRequested = stationRepository.findAllByIdCity(city.getId());
        List <StationModel> stations = stationRepository.findAll();
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

    public List<GuruResponse> findAllNearbyCity(StationModel station) {
        //station.setIdGuru("8700019");

        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList(mapper.readValue(new URL(this.URLbegin +station.getIdGuru() + this.URLend), GuruResponse[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList <GuruResponse> ();
    }


/* 
    @Override
    public List<GuruResponse> findAllNearbyCity(List<StationModel> stations) {
        List <GuruResponse> gurusResult = new ArrayList<GuruResponse>();
        for (StationModel s : stations) {
            gurusResult.addAll(findAllNearbyCity(s));
        }
        return gurusResult;
    }


    @Override
    public List<GuruResponse> findAllNearbyCityByTimeTravel(List<StationModel> stations, int minTimeTravel,
            int maxTimeTravel) {
                List <GuruResponse> gurusResult = new ArrayList<GuruResponse>();
                for (StationModel s : stations) {
                    gurusResult.addAll(findAllNearbyCityByTimeTravel(s, minTimeTravel, maxTimeTravel));
                }
                return gurusResult;
    }

    */

}
