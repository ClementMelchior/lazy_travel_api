package com.idovia.api.lazy_travel_api.model;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;

public class LazyTravelRequestModel {

    private CityModel departureCity;
    private String departureDate;
    private String arrivalDate;






    
    public CityModel getDepartureCity() {
        return departureCity;
    }
    public void setDepartureCity(CityModel departureCity) {
        this.departureCity = departureCity;
    }
    public String getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
    public String getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
}
