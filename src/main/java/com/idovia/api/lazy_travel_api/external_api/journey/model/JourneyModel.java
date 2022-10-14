package com.idovia.api.lazy_travel_api.external_api.journey.model;

public class JourneyModel {

    private String travelType;
    private String departureAdress;
    private String departureDate;  // date and hours of departure
    private int timeTravel;
    private Double price;
    private String arrivalAdress;
    private String arrivalDate;






    // Getter and Setter 

    public String getTravelType() {
        return travelType;
    }
    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }
    public String getDepartureAdress() {
        return departureAdress;
    }
    public void setDepartureAdress(String departureAdress) {
        this.departureAdress = departureAdress;
    }
    public String getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
    public int getTimeTravel() {
        return timeTravel;
    }
    public void setTimeTravel(int timeTravel) {
        this.timeTravel = timeTravel;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getArrivalAdress() {
        return arrivalAdress;
    }
    public void setArrivalAdress(String arrivalAdress) {
        this.arrivalAdress = arrivalAdress;
    }
    public String getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }    
}
