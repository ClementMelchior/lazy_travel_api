package com.idovia.api.lazy_travel_api.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.LazyTravelInterface;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.model.LazyTravelRequestModel;
import com.idovia.api.lazy_travel_api.model.LazyTravelResponseModel;
import com.idovia.api.lazy_travel_api.model.LazyTravelUniqueResponseModel;

@Controller
public class LazyTravelController {

    @Autowired
    private LazyTravelInterface lazyTravelInterface;

    @RequestMapping("/lazy-travel-api")
    public String displayHome() {
        return "index";
    }

    @RequestMapping("/lazy-travel-api/error")
    public String displayError() {
        return "error";
    }


    @RequestMapping("/lazy-travel-api/findTravel")
    public String displayTravelFind(Model model, @RequestParam String departureCity, @RequestParam String departureDate, @RequestParam String departureHour, @RequestParam String arrivalDate, @RequestParam String arrivalHour, @RequestParam String nbrPerson) throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException {
        LazyTravelRequestModel request = new LazyTravelRequestModel(departureCity, departureDate, departureHour, arrivalDate, arrivalHour, Integer.parseInt(nbrPerson));
        model.addAttribute("request", request);
        return "result";
    }


    @RequestMapping(path="/lazy-travel-api/findTravel/api", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List <LazyTravelUniqueResponseModel> findTravel(@RequestBody LazyTravelRequestModel request) throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException {

        List <LazyTravelUniqueResponseModel> responsesUnique = new ArrayList<>();

        List <LazyTravelResponseModel> responses = lazyTravelInterface.findTravel(request);

        for (LazyTravelResponseModel response : responses) {
            System.out.println(new LazyTravelUniqueResponseModel(response));
            responsesUnique.add(new LazyTravelUniqueResponseModel(response));
        }

        return responsesUnique;
    }

/* 
    @RequestMapping(path="/lazy-travel-api/findTravel/api", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List <LazyTravelUniqueResponseModel> findTravel() throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException {

        String cityDeparture = "Lyon";
        String departureDate="2022-11-19";
        String departureHour="06:00"; 
        String arrivalDate="2022-11-20";
        String arrivalHour="17:00";
        int nbrPerson=2;

        List <LazyTravelUniqueResponseModel> responsesUnique = new ArrayList<>();

        List <LazyTravelResponseModel> responses = lazyTravelInterface.findTravel(new LazyTravelRequestModel(cityDeparture, departureDate, departureHour,
        arrivalDate, arrivalHour, nbrPerson));

        for (LazyTravelResponseModel response : responses) {
            System.out.println(new LazyTravelUniqueResponseModel(response));
            responsesUnique.add(new LazyTravelUniqueResponseModel(response));

        }

        return responsesUnique;
    }

    */
    
}
