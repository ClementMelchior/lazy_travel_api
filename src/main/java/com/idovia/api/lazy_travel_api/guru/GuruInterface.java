package com.idovia.api.lazy_travel_api.guru;

import java.util.List;
import com.idovia.api.lazy_travel_api.city.model.StationModel;
import com.idovia.api.lazy_travel_api.guru.model.GuruResponse;

public interface GuruInterface {

    // Guru reponse 

    public List<GuruResponse> findAllNearbyCity (StationModel station);
    public List<GuruResponse> findAllNearbyCity (List <StationModel> stations);

    public List<GuruResponse> findAllNearbyCityByTimeTravel (StationModel station, int minTimeTravel, int maxTimeTravel);
    public List<GuruResponse> findAllNearbyCityByTimeTravel (List <StationModel> stations, int minTimeTravel, int maxTimeTravel);
    
}
