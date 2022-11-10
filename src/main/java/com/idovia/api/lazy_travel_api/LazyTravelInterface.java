package com.idovia.api.lazy_travel_api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.idovia.api.lazy_travel_api.external_api.journey.exception.ExecutionRequestException;
import com.idovia.api.lazy_travel_api.model.LazyTravelRequestModel;
import com.idovia.api.lazy_travel_api.model.LazyTravelResponseModel;

public interface LazyTravelInterface {

    public List <LazyTravelResponseModel> findTravel (LazyTravelRequestModel request) throws StreamReadException, DatabindException, MalformedURLException, ParseException, ExecutionRequestException, IOException, InterruptedException, ExecutionException;
    
}
