package com.idovia.api.lazy_travel_api.external_api.journey.kelbillet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.model.TicketKelbilletSncfModel;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.service.KelbilletService;

public class KelbilletMain {
    public static void main(String args []) throws ParseException, StreamReadException, DatabindException, MalformedURLException, ExecutionRequestException, IOException{
         KelBilletInterface kelBilletInterface = new KelbilletService();
         List <TicketKelbilletSncfModel> tj = kelBilletInterface.findAllTicketKelbilletBestMatch(new CityModel("1", "Paris", "3DFRPAR", "7CFRparis___%40u09tv", "48.856614", "2.3522219"), new CityModel("12", "Lille", "3DFRLIL", "7CFRlille___%40u140n", "50.62925", "3.057256"), "2022-10-29", "06:00", 120);
         //List <TicketKelbilletModel> tj = kelBilletInterface.findAllTicketKelbillet(new CityModel("1", "Paris", "3DFRPAR"), new CityModel("2", "Lyon", "3DFRLYS"), "2022-10-29", "06:00", 120);

         tj.stream().forEach(t -> System.out.println(t));
        
    }
}
