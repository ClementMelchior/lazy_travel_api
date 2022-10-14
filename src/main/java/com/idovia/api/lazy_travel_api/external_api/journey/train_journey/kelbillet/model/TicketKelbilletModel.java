package com.idovia.api.lazy_travel_api.external_api.journey.train_journey.kelbillet.model;

public class TicketKelbilletModel implements Comparable<TicketKelbilletModel> {
    private int type_id;
    private String price;
    private String currency;
    private int duration;
    private String departure_date;
    private String arrival_date;
    private String carrier_id;
    private String carrier_name;
    private String departure_name;
    private String arrival_name;
    private int wifi;
    private int socket;
    private boolean combine;
    private String partner_id;
    private String partner_name;
    private String deepLink;
    private int is_irrelevant;
    private String additional_informations;


    public TicketKelbilletModel() {
        
    }

    public TicketKelbilletModel(int type, String price, String currency, int duration, String departure_date, String arrival_date,
            String carrier_id, String carrier_name, String departure_name, String arrival_name, int wifi, int socket,
            boolean combine, String partner_id, String partner_name, String deepLink, int is_irrelevant,
            String additional_informations) {
        this.type_id = type;
        this.price = price;
        this.currency = currency;
        this.duration = duration;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
        this.carrier_id = carrier_id;
        this.carrier_name = carrier_name;
        this.departure_name = departure_name;
        this.arrival_name = arrival_name;
        this.wifi = wifi;
        this.socket = socket;
        this.combine = combine;
        this.partner_id = partner_id;
        this.partner_name = partner_name;
        this.deepLink = deepLink;
        this.is_irrelevant = is_irrelevant;
        this.additional_informations = additional_informations;
    }

    @Override
    public int compareTo(TicketKelbilletModel t) {
        return Integer.compare(Integer.parseInt(getPrice()), Integer.parseInt(t.getPrice()));
    }


    public String toString () {
        return this.departure_name + " | " + this.departure_date + " | " + this.arrival_name + " | " + this.arrival_date + " | " + this.price + " | "; 
    }
    
    // Getter and Setter


    public int getType_id() {
        return type_id;
    }
    public void setType_id(int type) {
        this.type_id = type;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getDeparture_date() {
        return departure_date;
    }
    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }
    public String getArrival_date() {
        return arrival_date;
    }
    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }
    public String getCarrier_id() {
        return carrier_id;
    }
    public void setCarrier_id(String carrier_id) {
        this.carrier_id = carrier_id;
    }
    public String getCarrier_name() {
        return carrier_name;
    }
    public void setCarrier_name(String carrier_name) {
        this.carrier_name = carrier_name;
    }
    public String getDeparture_name() {
        return departure_name;
    }
    public void setDeparture_name(String departure_name) {
        this.departure_name = departure_name;
    }
    public String getArrival_name() {
        return arrival_name;
    }
    public void setArrival_name(String arrival_name) {
        this.arrival_name = arrival_name;
    }
    public int getWifi() {
        return wifi;
    }
    public void setWifi(int wifi) {
        this.wifi = wifi;
    }
    public int getSocket() {
        return socket;
    }
    public void setSocket(int socket) {
        this.socket = socket;
    }
    public boolean isCombine() {
        return combine;
    }
    public void setCombine(boolean combine) {
        this.combine = combine;
    }
    public String getPartner_id() {
        return partner_id;
    }
    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }
    public String getPartner_name() {
        return partner_name;
    }
    public void setPartner_name(String partner_name) {
        this.partner_name = partner_name;
    }
    public String getDeepLink() {
        return deepLink;
    }
    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }
    public int getIs_irrelevant() {
        return is_irrelevant;
    }
    public void setIs_irrelevant(int is_irrelevant) {
        this.is_irrelevant = is_irrelevant;
    }
    public String getAdditional_informations() {
        return additional_informations;
    }
    public void setAdditional_informations(String additional_informations) {
        this.additional_informations = additional_informations;
    }
    
}
