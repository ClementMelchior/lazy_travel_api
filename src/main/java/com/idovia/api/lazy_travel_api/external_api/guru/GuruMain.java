package com.idovia.api.lazy_travel_api.external_api.guru;

import java.util.List;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.guru.service.GuruService;

public class GuruMain {
    public static void main(String args []){
         GuruInterface guruService = new GuruService();
         List<CityModel> tj = guruService.findAllNearbyCityByTimeTravel(new CityModel("37", "Lyon", "3DFRPAR", "", ""), 50, 200);

         tj.stream().forEach(t -> System.out.println(t));
    }
}
