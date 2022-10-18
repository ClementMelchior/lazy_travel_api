package com.idovia.api.lazy_travel_api.model;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;

public class LazyTravelRequestModel {

    private CityModel departureCity;
    private String departureDate;
    private String departureHour;
    private String arrivalDate;
    private String arrivalHour;
    private int nbrPerson;


    public LazyTravelRequestModel(CityModel departureCity, String departureDate, String departureHour, String arrivalDate, String arrivalHour, int nbrPerson) {
        this.departureCity = departureCity;
        this.departureDate = departureDate;
        this.departureHour = departureHour;
        this.arrivalDate = arrivalDate;
        this.arrivalHour = arrivalHour;
        this.nbrPerson = nbrPerson;
    }

    // Getter and Setter

    public CityModel getDepartureCity() {
        return departureCity;
    }
    public void setDepartureCity(CityModel departureCity) {
        this.departureCity = departureCity;
    }
    public String getArrivalHour() {
        return arrivalHour;
    }
    public void setArrivalHour(String arrivalHour) {
        this.arrivalHour = arrivalHour;
    }
    public String getDepartureHour() {
        return departureHour;
    }
    public void setDepartureHour(String departureHour) {
        this.departureHour = departureHour;
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
    public int getNbrPerson() {
        return nbrPerson;
    }
    public void setNbrPerson(int nbrPerson) {
        this.nbrPerson = nbrPerson;
    }
    
}
