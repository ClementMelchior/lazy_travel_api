package com.idovia.api.lazy_travel_api.guru.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idovia.api.lazy_travel_api.city.model.StationModel;
import com.idovia.api.lazy_travel_api.city.repository.StationRepository;
import com.idovia.api.lazy_travel_api.guru.GuruInterface;
import com.idovia.api.lazy_travel_api.guru.model.GuruResponse;

public class GuruService implements GuruInterface {

    @Autowired
    private StationRepository stationRepository;
    private final String URLbegin = "https://api.direkt.bahn.guru/";
    private final String URLend = "?localTrainsOnly=false&v=4";

    
    // Return all nearby city form given city



    public List<GuruResponse> findAllNearbyCity(StationModel station) {
        station.setIdGuru("8700019");

        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList(mapper.readValue(new URL(this.URLbegin +station.getIdGuru() + this.URLend), GuruResponse[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList <GuruResponse> ();
    }

    // Return all nearby city from given city with time travel duration less than time travel given
    public List<GuruResponse> findAllNearbyCityByTimeTravel (StationModel station, int minTimeTravel, int maxTimeTravel) {
        List <GuruResponse> trainJourneyGurus = findAllNearbyCity(station);
        if (trainJourneyGurus.size()>0) {
            return trainJourneyGurus.stream().filter(tj -> tj.getDuration() <= maxTimeTravel && tj.getDuration() >= minTimeTravel).collect(Collectors.toList());
        }
        return null;
    }


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
}
