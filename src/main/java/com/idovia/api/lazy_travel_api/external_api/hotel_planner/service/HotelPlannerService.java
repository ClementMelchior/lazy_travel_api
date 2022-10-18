package com.idovia.api.lazy_travel_api.external_api.hotel_planner.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.net.URL;
import java.text.ParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.HotelPlanerInterface;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.model.HotelPlannerResponseModel;

public class HotelPlannerService implements HotelPlanerInterface {
    
    //private String URL = "https://fr.hotelplanner.com/common/cfcs/services/search.cfc?method=citySearch&vendor=gr&aky=23E94B31FF8798EEAD800F33346F23EE&City=Lille%2C%20France&InDate=10%2F22%2F2022&OutDate=10%2F23%2F2022&NumRooms=1&destinationLatitude=50.62925&destinationLongitude=3.057256&IncludeDiscountBiz=1&amenityIds=&Landmark=0&SortBy=LatLonDistance&latLonName=none&latitude=none&longitude=none&_=1665339302793";
    //                    https://fr.hotelplanner.com/common/cfcs/services/search.cfc?method=citySearch&vendor=gr&aky=23E94B31FF8798EEAD800F33346F23EE&City=Bordeaux%2C%20France&InDate=10%2F22%2F2022&OutDate=10%2F23%2F2022&NumRooms=1&destinationLatitude=44.837789&destinationLongitude=-0.57918&IncludeDiscountBiz=1&amenityIds=&Landmark=0&_=1665339673884
    //                    https://fr.hotelplanner.com/common/cfcs/services/search.cfc?method=citySearch&vendor=gr&aky=23E94B31FF8798EEAD800F33346F23EE&City=Lille%2C%20France&InDate=10%2F22%2F2022&OutDate=10%2F23%2F2022&NumRooms=1&destinationLatitude=50.62925&destinationLongitude=3.057256&IncludeDiscountBiz=1&amenityIds=&Landmark=0&SortBy=LatLonDistance&latLonName=none&latitude=none&longitude=none&_=1665339302793
   

    // Return all nearby hotel from given city

    public List<HotelPlannerModel> findAllHotel (CityModel city, String dateBegin, String dateEnd) throws ParseException {

        String URL = (this.getCustomUrl(city, dateBegin, dateEnd));

        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList((mapper.readValue(new URL(URL), HotelPlannerResponseModel.class)).getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList <HotelPlannerModel> ();
    }

    public List<HotelPlannerModel> findAllHotelBestMatch(CityModel city, String dateBegin, String dateEnd) throws ParseException {

        List <HotelPlannerModel> hotels = findAllHotel(city, dateBegin, dateEnd);

        List<HotelPlannerModel> sortedHotel = hotels.stream().filter(h -> (h.getDistanceFromCity()!=null && h.getReview()!=null && h.getDistanceFromCity()<3.5 && h.getReview()>=3.8))
            .sorted( (h1, h2) -> {
                return Double.compare(h1.getCostNumeric(), h2.getCostNumeric());
            })
            .collect(Collectors.toList());

        if (sortedHotel.size()!=0) {
            Double maxPrice = sortedHotel.get(0).getCostNumeric()*1.50;
            List<HotelPlannerModel> sortedHotel2 = sortedHotel.stream().filter(h -> h.getCostNumeric()<maxPrice).collect(Collectors.toList());
            return sortedHotel2;
        }
        return new ArrayList<HotelPlannerModel> ();
    }


    private String getCustomUrl (CityModel cityModel, String dateBegin, String dateEnd) throws ParseException {
        String[] dateBeginSplit = dateBegin.split("-");  
        String[] dateEndSplit = dateEnd.split("-");  

        return ("https://fr.hotelplanner.com/common/cfcs/services/search.cfc?method=citySearch&vendor=gr&aky=23E94B31FF8798EEAD800F33346F23EE&City=Lille%2C%20France&InDate=" + dateBeginSplit[1] + "%2F" + dateBeginSplit[2] + "%2F" + dateBeginSplit[0] + "&OutDate=" + dateEndSplit[1] + "%2F" + dateEndSplit[2] + "%2F" + dateEndSplit[0] + "&NumRooms=1&destinationLatitude="+cityModel.getLatitude()+"&destinationLongitude="+cityModel.getLongitude()+"&IncludeDiscountBiz=1&amenityIds=&Landmark=0&SortBy=LatLonDistance&latLonName=none&latitude=none&longitude=none&_=1665339302793");
        //return "https://fr.hotelplanner.com/common/cfcs/services/search.cfc?method=citySearch&vendor=gr&aky=9DDEBF6FC917CD9DE0CDBD12FAD94E0B&City=VILLE%2C%20France&InDate=10%2F22%2F2022&OutDate=10%2F23%2F2022&NumRooms=1&destinationLatitude=50.62925&destinationLongitude=3.057256&IncludeDiscountBiz=1&amenityIds=&Landmark=0&SortBy=LatLonDistance&latLonName=none&latitude=none&longitude=none&_=1663654117684";
    } 
}
