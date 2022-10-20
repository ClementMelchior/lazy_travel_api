package com.idovia.api.lazy_travel_api.external_api.hotel_planner;

import java.text.ParseException;
import java.util.List;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.service.HotelPlannerService;

public class HotelPlannerMain {

    public static void main(String args []) throws ParseException{
        HotelPlannerService hotelPlannerService = new HotelPlannerService();
        List <HotelPlannerModel> hp = hotelPlannerService.findAllHotelBestMatch(new CityModel("23", "Nimes", "",  "3DFRFNI", "7CFRnimes___%40spg17", "43.836699", "43.836699"), "2022-11-19", "2022-11-20");

        hp.stream().forEach(t -> System.out.println(t));
   }
    
}
