package com.idovia.api.lazy_travel_api.hotel_planner;

import java.text.ParseException;
import java.util.List;

import com.idovia.api.lazy_travel_api.city.model.CityModel;
import com.idovia.api.lazy_travel_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.hotel_planner.service.HotelPlannerService;

public class HotelPlannerMain {

    public static void main(String args []) throws ParseException{
        HotelPlannerService hotelPlannerService = new HotelPlannerService();
        List <HotelPlannerModel> hp = hotelPlannerService.findAllHotelBestMatch(new CityModel(), "2022-10-29", "2022-10-30");

        hp.stream().forEach(t -> System.out.println(t));
   }
    
}
