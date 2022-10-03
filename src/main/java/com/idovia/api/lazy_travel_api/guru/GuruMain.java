package com.idovia.api.lazy_travel_api.guru;

import java.util.List;

import com.idovia.api.lazy_travel_api.city.model.StationModel;
import com.idovia.api.lazy_travel_api.guru.model.GuruResponse;
import com.idovia.api.lazy_travel_api.guru.service.GuruService;

public class GuruMain {
    public static void main(String args []){
         GuruInterface guruService = new GuruService();
         List <GuruResponse> tj = guruService.findAllNearbyCityByTimeTravel(new StationModel(), 50, 150);

         tj.stream().forEach(t -> System.out.println(t));
    }
}
