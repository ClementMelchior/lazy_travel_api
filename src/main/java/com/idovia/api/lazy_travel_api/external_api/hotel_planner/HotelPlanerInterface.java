package com.idovia.api.lazy_travel_api.external_api.hotel_planner;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.model.HotelPlannerModel;

public interface HotelPlanerInterface {

    public List<HotelPlannerModel> findAllHotel (CityModel city, String dateBegin, String dateEnd) throws ParseException;

    public CompletableFuture<List<HotelPlannerModel>> findAllHotelBestMatch (CityModel city, String dateBegin, String dateEnd) throws ParseException;

    
}
