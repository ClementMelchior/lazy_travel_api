package com.idovia.api.lazy_travel_api.external_api.guru.model;

public class CityModel {

    private String id;
    private String name;
    private String codeKelbillet;
    private String latitude;
    private String longitude;
    

    public CityModel() {
        
    }

    public CityModel(String id, String name, String codeKelbillet, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.codeKelbillet = codeKelbillet;
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public String toString () {
        return this.id + " | " + this.name;

    }


    // Getter and Setter

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCodeKelbillet() {
        return codeKelbillet;
    }
    public void setCodeKelbillet(String codeKelbillet) {
        this.codeKelbillet = codeKelbillet;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
}
