package com.idovia.api.lazy_travel_api.model;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.external_api.journey.model.JourneyModel;

public class LazyTravelResponseCompletableFutureModel {

    private String dateBegin;
    private String dateEnd;
    private CityModel cityDeparture;
    private CityModel cityArrival;
    private CompletableFuture <List <JourneyModel>> goingJourney;
    private CompletableFuture<List <JourneyModel>> commingJourney;
    private CompletableFuture<List <HotelPlannerModel>>hotel;
    private Double price;


    
    public LazyTravelResponseCompletableFutureModel(String dateBegin, String dateEnd, CityModel cityDeparture, CityModel cityArrival, CompletableFuture <List <JourneyModel>> goingJourney, CompletableFuture <List <JourneyModel>> commingJourney,
    CompletableFuture <List <HotelPlannerModel>> hotel) {
        this.dateBegin=dateBegin;
        this.dateEnd=dateEnd;
        this.cityDeparture=cityDeparture;
        this.cityArrival=cityArrival;
        this.goingJourney = goingJourney;
        this.commingJourney = commingJourney;
        this.hotel = hotel;
    }

    // Getter and Setter 

    public String getDateEnd() {
        return dateEnd;
    }
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
    public String getDateBegin() {
        return dateBegin;
    }
    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }
    public CompletableFuture <List <JourneyModel>> getGoingJourney() {
        return goingJourney;
    }
    public void setGoingJourney(CompletableFuture <List <JourneyModel>> goingJourney) {
        this.goingJourney = goingJourney;
    }
    public CompletableFuture <List <JourneyModel>> getCommingJourney() {
        return commingJourney;
    }
    public void setCommingJourney(CompletableFuture <List <JourneyModel>> commingJourney) {
        this.commingJourney = commingJourney;
    }
    public CompletableFuture <List <HotelPlannerModel>> getHotel() {
        return hotel;
    }
    public void setHotel(CompletableFuture <List <HotelPlannerModel>> hotel) {
        this.hotel = hotel;
    }
    public Double getPrice () {
        return this.price;
    }
    public CityModel getCityDeparture() {
        return cityDeparture;
    }
    public void setCityDeparture(CityModel cityDeparture) {
        this.cityDeparture = cityDeparture;
    }
    public CityModel getCityArrival() {
        return cityArrival;
    }
    public void setCityArrival(CityModel cityArrival) {
        this.cityArrival = cityArrival;
    }
    
}
