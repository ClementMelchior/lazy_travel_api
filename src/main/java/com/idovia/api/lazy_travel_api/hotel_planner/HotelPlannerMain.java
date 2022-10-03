package com.idovia.api.lazy_travel_api.hotel_planner;

import java.util.List;

import com.idovia.api.lazy_travel_api.city.model.CityModel;
import com.idovia.api.lazy_travel_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.hotel_planner.service.HotelPlannerService;

public class HotelPlannerMain {

    public static void main(String args []){
        HotelPlannerService hotelPlannerService = new HotelPlannerService();
        List <HotelPlannerModel> hp = hotelPlannerService.findAllHotel(new CityModel(), "50", "150");

        hp.stream().forEach(t -> System.out.println(t));
       
   }
    
}
