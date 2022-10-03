package com.idovia.api.lazy_travel_api.guru.model;

public class GuruResponse {
    private String id;
    private String name;
    private Location location;
    private int duration;
    private String dbUrlGerman;
    private String dbUrlEnglish;
    private String calendarUrl;


    public GuruResponse() {
    }


    public GuruResponse(String id, String name, Location location, int duration, String dbUrlGerman,
            String dbUrlEnglish, String calendarUrl) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.duration = duration;
        this.dbUrlGerman = dbUrlGerman;
        this.dbUrlEnglish = dbUrlEnglish;
        this.calendarUrl = calendarUrl;
    }

    public String toString () {
        return this.id + " | " + this.name + " | " + this.duration + " | " + this.getLocation().getId();
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
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getDbUrlGerman() {
        return dbUrlGerman;
    }
    public void setDbUrlGerman(String dbUrlGerman) {
        this.dbUrlGerman = dbUrlGerman;
    }
    public String getDbUrlEnglish() {
        return dbUrlEnglish;
    }
    public void setDbUrlEnglish(String dbUrlEnglish) {
        this.dbUrlEnglish = dbUrlEnglish;
    }
    public String getCalendarUrl() {
        return calendarUrl;
    }
    public void setCalendarUrl(String calendarUrl) {
        this.calendarUrl = calendarUrl;
    }

    
}
