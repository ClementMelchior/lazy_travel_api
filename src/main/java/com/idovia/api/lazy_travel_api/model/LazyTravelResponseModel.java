package com.idovia.api.lazy_travel_api.model;

import com.idovia.api.lazy_travel_api.external_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.external_api.journey.model.JourneyModel;

public class LazyTravelResponseModel {

    private JourneyModel goingJourney;
    private JourneyModel commingJourney;
    private HotelPlannerModel hotel;
    private Double price;


    
    public LazyTravelResponseModel(JourneyModel goingJourney, JourneyModel commingJourney,
            HotelPlannerModel hotel) {
        this.goingJourney = goingJourney;
        this.commingJourney = commingJourney;
        this.hotel = hotel;
    }

    public void setPrice () {
        this.price = this.goingJourney.getPrice()+this.commingJourney.getPrice()+this.hotel.getCostNumeric();
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
    public Double getPrice () {
        return this.price;
    }
    
}
