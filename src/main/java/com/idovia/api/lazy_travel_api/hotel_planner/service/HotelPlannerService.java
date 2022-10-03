package com.idovia.api.lazy_travel_api.hotel_planner.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idovia.api.lazy_travel_api.city.model.CityModel;
import com.idovia.api.lazy_travel_api.hotel_planner.HotelPlanerInterface;
import com.idovia.api.lazy_travel_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.hotel_planner.model.HotelPlannerResponseModel;

public class HotelPlannerService implements HotelPlanerInterface {
    
    private String URL = "https://fr.hotelplanner.com/common/cfcs/services/search.cfc?method=citySearch&vendor=tgx&aky=9DDEBF6FC917CD9DE0CDBD12FAD94E0B&City=VILLE%2C%20France&InDate=10%2F22%2F2022&OutDate=10%2F23%2F2022&NumRooms=1&destinationLatitude=50.62925&destinationLongitude=3.057256&IncludeDiscountBiz=1&amenityIds=&Landmark=0&SortBy=LatLonDistance&latLonName=none&latitude=none&longitude=none&_=1663654117684";

    
    // Return all nearby hotel from given city

    public List<HotelPlannerModel> findAllHotel (CityModel city, String dateBegin, String dateEnd) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList((mapper.readValue(new URL(this.URL), HotelPlannerResponseModel.class)).getData());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList <HotelPlannerModel> ();
    }


    // retur best hotel for distance less than 3.5, review than 3.8 et less cost
    public HotelPlannerModel findBestHotel (CityModel city, String dateBegin, String dateEnd) {

        List <HotelPlannerModel> hotels = findAllHotel(city, dateBegin, dateEnd);

        List<HotelPlannerModel> sortedHotel = hotels.stream().filter(h -> h.getDistanceFromCity()<3.5 && h.getReview()>3.8)
			.sorted(Comparator.comparingDouble(HotelPlannerModel::getCostNumeric))
			.collect(Collectors.toList());

        sortedHotel = hotels.stream().filter(h -> h.getCostNumeric()<(hotels.get(0).getCostNumeric()*1.20))
            .sorted(Comparator.comparingDouble(HotelPlannerModel::getReview))
			.collect(Collectors.toList());

        if (sortedHotel.size()!=0) {
            return sortedHotel.get(0);
        }
        return null;

    }
}
