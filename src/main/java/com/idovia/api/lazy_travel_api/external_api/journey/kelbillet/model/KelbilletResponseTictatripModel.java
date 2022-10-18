package com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.model;

public class KelbilletResponseTictatripModel {

    private String status;
    private String error;
    private TicketKelbilletSncfModel response[];


    public KelbilletResponseTictatripModel() {
    }

    public KelbilletResponseTictatripModel(String status, String error, TicketKelbilletSncfModel[] response) {
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
    public TicketKelbilletSncfModel[] getResponse() {
        return response;
    }
    public void setResponse(TicketKelbilletSncfModel[] response) {
        this.response = response;
    }
    
}
