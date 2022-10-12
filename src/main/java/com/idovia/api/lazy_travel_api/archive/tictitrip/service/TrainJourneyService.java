package com.idovia.api.lazy_travel_api.archive.tictitrip.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import com.idovia.api.lazy_travel_api.city.model.CityModel;
import com.idovia.api.lazy_travel_api.archive.model.TrainJourneyModel;
import com.idovia.api.lazy_travel_api.archive.tictitrip.TrainJourneyInterface;

@Service
public class TrainJourneyService implements TrainJourneyInterface {

    private String URL = "https://www.tictactrip.eu/results?origin=Paris&originId=628&nfs=&nft=&destination=Lille&destinationId=453&outboundDate=2022-09-12T00%3A00%3A00Z&outboundTime=8&returnTime=0&passengers=%5B%22%7B%5C%22id%5C%22%3A0%2C%5C%22age%5C%22%3A35%2C%5C%22category%5C%22%3A%5C%22adults%5C%22%2C%5C%22discountCards%5C%22%3A%5B%5D%7D%22%5D";
    private ChromeDriver driver;

    public TrainJourneyService () {
        System.setProperty("webdriver.chrome.driver", "/Users/clement/Local/Projet/lazy_travel_api/src/main/resources/static/driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    public List <TrainJourneyModel> findTrainJourneys (CityModel cityDeparture, CityModel cityArrival, String date) throws InterruptedException {
        driver.get(URL);

        waitForDriverGetReady();

        List <WebElement> stations = driver.findElements(By.cssSelector(".TripOD__Place-sc-7b5xzk-2.LAPYT"));
        List <WebElement> hours = driver.findElements(By.cssSelector(".TripOD__Col-sc-7b5xzk-4.XnfNW"));
        List <WebElement> prices = driver.findElements(By.cssSelector(".TripPrice__Container-sc-23aeng-0.jPDEZi"));

        List <TrainJourneyModel> trainJourneys = new ArrayList<>();
        for (int i = 0; i<6; i++) {
            //trainJourneys.add(new TrainJourneyModel(hours.get(2*i).getText(), stations.get(2*i).getText(), hours.get(2*i+1).getText(), stations.get(2*i+1).getText(), prices.get(i).getText()));
            trainJourneys.add(new TrainJourneyModel(stations.get(2*i).getText(), stations.get(2*i+1).getText(), hours.get(2*i).getText(), hours.get(2*i+1).getText(), prices.get(i).getText().split("\n")[1]));

        }
        driver.quit();
        /*
        System.out.println("-------------------------------------------------------------");
        System.out.println(trainJourneys.get(0).getTimeDeparture());
        System.out.println(trainJourneys.get(0).getDeparture());
        System.out.println(trainJourneys.get(0).getTimeArrival());
        System.out.println(trainJourneys.get(0).getArrival());
        System.out.println(trainJourneys.get(0).getPrice());
        */
        return trainJourneys;
    }

    private void waitForDriverGetReady() throws InterruptedException {
        boolean ready = false;
        while (!ready) {
            List <WebElement> hours = driver.findElements(By.cssSelector(".TripOD__Place-sc-7b5xzk-2.LAPYT"));
            try {
                hours.get(0).getText();
                ready=true;
            } catch (Exception e) {
                Thread.sleep(500);
            }
        }
    }

    @Override
    public TrainJourneyModel findTrainJourneyBestMatch(CityModel cityDeparture, CityModel cityArrival, String date) throws InterruptedException {
        List <TrainJourneyModel> trainJourneys = findTrainJourneys(cityDeparture, cityArrival, date);
        return trainJourneys.stream().sorted(Comparator.comparingDouble(TrainJourneyModel::getPrice)).collect(Collectors.toList()).get(0);
    }

    @Override
    public TrainJourneyModel findTrainJourneyBestMatch(CityModel cityDeparture, CityModel cityArrival, String date, long maxTimeTravel) throws InterruptedException, ParseException {
        List <TrainJourneyModel> trainJourneys = findTrainJourneys(cityDeparture, cityArrival, date);
        return trainJourneys.stream().sorted(Comparator.comparingDouble(TrainJourneyModel::getPrice)).filter(t -> {
            try {
                return getTimeTravel(t.getTimeDeparture(), t.getTimeArrival()) < maxTimeTravel;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList()).get(0);
    }

    public long getTimeTravel (String hour1, String hour2) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        
        Date h1 = dateFormat.parse(hour1);
        Date h2 = dateFormat.parse(hour2);

        return (Math.abs(h2.getTime() - h1.getTime())/(60*1000));
    }
}
