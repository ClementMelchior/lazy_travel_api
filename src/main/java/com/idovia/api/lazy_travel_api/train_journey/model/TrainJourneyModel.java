package com.idovia.api.lazy_travel_api.train_journey.model;

public class TrainJourneyModel {

    private String departure;
    private String arrival;
    private String timeDeparture;
    private String timeArrival;
    private Double price;



    
    
    public TrainJourneyModel() {

    }

    public TrainJourneyModel(String departure, String arrival, String timeDeparture, String timeArrival, String price) {
        this.departure = departure;
        this.arrival = arrival;
        this.timeDeparture = timeDeparture;
        this.timeArrival = timeArrival;
        this.price = Double.parseDouble(price.split(" ")[0]);
    }

    public TrainJourneyModel(String departure, String arrival, String timeDeparture, String timeArrival, Double price) {
        this.departure = departure;
        this.arrival = arrival;
        this.timeDeparture = timeDeparture;
        this.timeArrival = timeArrival;
        this.price = price;
    }

    
    public String getDeparture() {
        return departure;
    }
    public void setDeparture(String departure) {
        this.departure = departure;
    }
    public String getArrival() {
        return arrival;
    }
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
    public String getTimeDeparture() {
        return timeDeparture;
    }
    public void setTimeDeparture(String timeDeparture) {
        this.timeDeparture = timeDeparture;
    }
    public String getTimeArrival() {
        return timeArrival;
    }
    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }




    
}
