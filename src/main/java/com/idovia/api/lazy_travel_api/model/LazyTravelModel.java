package com.idovia.api.lazy_travel_api.model;

import com.idovia.api.lazy_travel_api.hotel_planner.model.HotelPlannerModel;
import com.idovia.api.lazy_travel_api.journey.model.JourneyModelInterface;

public class LazyTravelModel {

    private JourneyModelInterface goingJourney;
    private JourneyModelInterface commingJourney;
    private HotelPlannerModel hotel;





    
    public LazyTravelModel(JourneyModelInterface goingJourney, JourneyModelInterface commingJourney,
            HotelPlannerModel hotel) {
        this.goingJourney = goingJourney;
        this.commingJourney = commingJourney;
        this.hotel = hotel;
    }


    // Getter and Setter 
    
    public JourneyModelInterface getGoingJourney() {
        return goingJourney;
    }
    public void setGoingJourney(JourneyModelInterface goingJourney) {
        this.goingJourney = goingJourney;
    }
    public JourneyModelInterface getCommingJourney() {
        return commingJourney;
    }
    public void setCommingJourney(JourneyModelInterface commingJourney) {
        this.commingJourney = commingJourney;
    }
    public HotelPlannerModel getHotel() {
        return hotel;
    }
    public void setHotel(HotelPlannerModel hotel) {
        this.hotel = hotel;
    }
    
}
