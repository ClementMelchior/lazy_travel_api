package com.idovia.api.lazy_travel_api.city.model;

public class CityModel {

    private String id;
    private String name;
    private String codeKelbillet;
    

    public CityModel() {
        
    }

    public CityModel(String id, String name, String codeKelbillet) {
        this.id = id;
        this.name = name;
        this.codeKelbillet = codeKelbillet;
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
    
}
