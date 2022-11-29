package com.idovia.api.lazy_travel_api.model;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.external_api.journey.model.JourneyModel;

public class LazyTravelResponseModel {

    private String dateBegin;
    private String dateEnd;
    private CityModel cityDeparture;
    private CityModel cityArrival;
    private List <JourneyModel> goingJourney;
    private List <JourneyModel> commingJourney;
    private List <HotelPlannerModel> hotel;
    private Double price;


    
    public LazyTravelResponseModel(String dateBegin, String dateEnd, CityModel cityDeparture, CityModel cityArrival, List <JourneyModel> goingJourney, List <JourneyModel> commingJourney,
    List <HotelPlannerModel> hotel) {
        this.dateBegin=dateBegin;
        this.dateBegin=dateEnd;
        this.cityDeparture=cityDeparture;
        this.cityArrival=cityArrival;
        this.goingJourney = goingJourney;
        this.commingJourney = commingJourney;
        this.hotel = hotel;
    }

    public LazyTravelResponseModel(LazyTravelResponseCompletableFutureModel response) throws InterruptedException, ExecutionException {
        this.dateBegin=response.getDateBegin();
        this.dateEnd=response.getDateEnd();
        this.cityDeparture=response.getCityDeparture();
        this.cityArrival=response.getCityArrival();
        this.goingJourney = response.getGoingJourney().get();
        this.commingJourney = response.getCommingJourney().get();
        this.hotel = response.getHotel().get();
    }

    public String toString () {
        return this.goingJourney.get(0) + "\n" + this.commingJourney.get(0) + "\n" + this.hotel.get(0);
    }

    public void setPrice (int nbrPerson) {
        this.price = this.goingJourney.get(0).getPrice()*nbrPerson/100 + this.commingJourney.get(0).getPrice()*nbrPerson/100 + this.hotel.get(0).getCostNumeric();
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
    public List <JourneyModel> getGoingJourney() {
        return goingJourney;
    }
    public void setGoingJourney(List <JourneyModel> goingJourney) {
        this.goingJourney = goingJourney;
    }
    public List <JourneyModel> getCommingJourney() {
        return commingJourney;
    }
    public void setCommingJourney(List <JourneyModel> commingJourney) {
        this.commingJourney = commingJourney;
    }
    public List <HotelPlannerModel> getHotel() {
        return hotel;
    }
    public void setHotel(List <HotelPlannerModel> hotel) {
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
