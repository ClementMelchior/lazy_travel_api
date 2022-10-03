package com.idovia.api.lazy_travel_api.city.model;

public class StationModel {

    private String idCity;
    private String name;
    private String idGuru;

    
    public StationModel() { 

    }

    public StationModel(String idCity, String name, String idGuru) {
        this.idCity = idCity;
        this.name = name;
        this.idGuru = idGuru;
    }


    // Getter and Setter 
    public String getIdCity() {
        return idCity;
    }
    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdGuru() {
        return idGuru;
    }
    public void setIdGuru(String idGuru) {
        this.idGuru = idGuru;
    }
    
}
