package com.idovia.api.lazy_travel_api.journey.train_journey.kelbillet.model;

public class KelbilletResponseModel {

    private String status;
    private String error;
    private TicketKelbilletModel response[];


    public KelbilletResponseModel() {
    }

    public KelbilletResponseModel(String status, String error, TicketKelbilletModel[] response) {
        this.status = status;
        this.error = error;
        this.response = response;
    }

    
    // Getter and Setter 
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public TicketKelbilletModel[] getResponse() {
        return response;
    }
    public void setResponse(TicketKelbilletModel[] response) {
        this.response = response;
    }
    
}
