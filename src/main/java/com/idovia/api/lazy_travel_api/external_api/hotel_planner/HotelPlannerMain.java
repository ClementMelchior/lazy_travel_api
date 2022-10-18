package com.idovia.api.lazy_travel_api.external_api.hotel_planner;

import java.text.ParseException;
import java.util.List;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.service.HotelPlannerService;

public class HotelPlannerMain {

    public static void main(String args []) throws ParseException{
        HotelPlannerService hotelPlannerService = new HotelPlannerService();
        List <HotelPlannerModel> hp = hotelPlannerService.findAllHotel(new CityModel("12", "Lille", "3DFRLIL", "7CFRlille___%40u140n", "50.62925", "3.057256"), "2022-10-29", "2022-10-30");

        hp.stream().forEach(t -> System.out.println(t));
   }
    
}
