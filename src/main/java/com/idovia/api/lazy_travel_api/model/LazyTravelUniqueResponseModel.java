package com.idovia.api.lazy_travel_api.model;

import com.idovia.api.lazy_travel_api.external_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.external_api.journey.model.JourneyModel;

public class LazyTravelUniqueResponseModel {

    private String cityDeparture;
    private String cityArrival;
    private JourneyModel goingJourney;
    private JourneyModel commingJourney;
    private HotelPlannerModel hotel;
    private String price;

    public LazyTravelUniqueResponseModel(LazyTravelResponseModel responseModel) {
        this.cityDeparture=responseModel.getCityDeparture().getName();
        this.cityArrival=responseModel.getCityArrival().getName();
        this.goingJourney = responseModel.getGoingJourney().get(0);
        this.commingJourney = responseModel.getCommingJourney().get(0);
        this.hotel = responseModel.getHotel().get(0);
        this.price=Long.toString(Math.round(responseModel.getPrice()));
    }


    public String toString () {
        return this.cityArrival + " : " + this.price;
    }

    public void setPrice (String price) {
        this.price = price;
    } 

    // Getter and Setter 

    public JourneyModel getGoingJourney() {
        return goingJourney;
    }
    public void setGoingJourney(JourneyModel goingJourney) {
        this.goingJourney = goingJourney;
    }
    public JourneyModel getCommingJourney() {
        return commingJourney;
    }
    public void setCommingJourney(JourneyModel commingJourney) {
        this.commingJourney = commingJourney;
    }
    public HotelPlannerModel getHotel() {
        return hotel;
    }
    public void setHotel(HotelPlannerModel hotel) {
        this.hotel = hotel;
    }
    public String getPrice () {
        return this.price;
    }
    public String getCityDeparture() {
        return cityDeparture;
    }
    public void setCityDeparture(String cityDeparture) {
        this.cityDeparture = cityDeparture;
    }
    public String getCityArrival() {
        return cityArrival;
    }
    public void setCityArrival(String cityArrival) {
        this.cityArrival = cityArrival;
    }
    
}
