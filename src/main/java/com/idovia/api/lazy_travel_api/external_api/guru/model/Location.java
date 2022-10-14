package com.idovia.api.lazy_travel_api.external_api.guru.model;

public class Location {
    private String type;
    private String id;
    private double latitude;
    private double longitude;


    public Location() {
    }

    public Location(String type, String id, double latitude, double longitude) {
        this.type=type;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }



    // Getter and Setter 
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    
}
