package com.idovia.api.lazy_travel_api.hotel_planner;

import java.util.List;

import com.idovia.api.lazy_travel_api.city.model.CityModel;
import com.idovia.api.lazy_travel_api.hotel_planner.model.HotelPlannerModel;

public interface HotelPlanerInterface {

    public List<HotelPlannerModel> findAllHotel (CityModel city, String dateBegin, String dateEnd);
    
}
