package com.idovia.api.lazy_travel_api.external_api.guru.model;

public class StationModel {

    private String idCity;
    private String idGuru;

    
    public StationModel() { 

    }

    public StationModel(String idCity, String idGuru) {
        this.idCity = idCity;
        this.idGuru = idGuru;
    }


    public String toString () {
        return this.idCity + " | " + this.idGuru;
    }


    // Getter and Setter 
    public String getIdCity() {
        return idCity;
    }
    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }
    public String getIdGuru() {
        return idGuru;
    }
    public void setIdGuru(String idGuru) {
        this.idGuru = idGuru;
    }
    
}
