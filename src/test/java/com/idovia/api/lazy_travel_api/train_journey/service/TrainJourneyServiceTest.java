package com.idovia.api.lazy_travel_api.train_journey.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.idovia.api.lazy_travel_api.train_journey.tictitrip.service.TrainJourneyService;

@SpringBootTest
@ActiveProfiles("test")
public class TrainJourneyServiceTest {

    @Autowired
    private TrainJourneyService trainJourneyService;


    @Test
    void shouldReturn0For10And10() throws ParseException {
        assertEquals(0L, trainJourneyService.getTimeTravel("10:00", "10:00"));
    }

    @Test
    void shouldReturn120For8And10() throws ParseException {
        assertEquals(120L, trainJourneyService.getTimeTravel("08:00", "10:00"));
    }

    @Test
    void shouldReturn150For1030And8() throws ParseException {
        assertEquals(150L, trainJourneyService.getTimeTravel("10:30", "08:00"));
    }

    @Test
    void shouldReturn120For10And8() throws ParseException {
        assertEquals(120L, trainJourneyService.getTimeTravel("10:00", "08:00"));
    }

    @Test
    void shouldReturn300For15And10() throws ParseException {
        assertEquals(300L, trainJourneyService.getTimeTravel("15:00", "10:00"));
    }
    
}
