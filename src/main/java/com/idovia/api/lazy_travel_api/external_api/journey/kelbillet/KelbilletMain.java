package com.idovia.api.lazy_travel_api.external_api.journey.kelbillet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.model.TicketKelbilletModel;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.service.KelbilletService;

public class KelbilletMain {
    public static void main(String args []) throws ParseException, StreamReadException, DatabindException, MalformedURLException, ExecutionRequestException, IOException{
         KelBilletInterface kelBilletInterface = new KelbilletService();
         List <TicketKelbilletModel> tj = kelBilletInterface.findAllTicketKelbillet(new CityModel("10", "Marseille", "", "3DFRMRS", "7CFRmarseill%40spey6", "43.296482", "5.36978"), new CityModel("2", "Lyon", "", "3DFRLYS", "7CFRlyon____%40u05kq", "45.764043", "4.835659"), "2022-11-20", "15:00", 200);
         //List <TicketKelbilletModel> tj = kelBilletInterface.findAllTicketKelbillet(new CityModel("1", "Paris", "3DFRPAR"), new CityModel("2", "Lyon", "3DFRLYS"), "2022-10-29", "06:00", 120);
         
         tj.stream().forEach(t -> System.out.println(t));
        
    }
}
