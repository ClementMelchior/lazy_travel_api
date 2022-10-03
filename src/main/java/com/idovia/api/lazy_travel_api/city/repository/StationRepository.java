package com.idovia.api.lazy_travel_api.city.repository;

import java.util.ArrayList;
import java.util.List;

import com.idovia.api.lazy_travel_api.city.model.StationModel;

public class StationRepository {

    private ArrayList<StationModel> stations = new ArrayList <StationModel> ();
    
    
    public StationRepository () {
        this.stations.add(new StationModel());
    }



    public List<StationModel> findAll() {
        return this.stations;
    }

    public StationModel findByIdCity(String id) {
        for (StationModel s : stations) {
            if (s.getIdCity()==id) {
                return s;
            }
        }
        return null;
    }
    
}
