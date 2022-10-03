package com.idovia.api.lazy_travel_api.hotel_planner.model;

public class HotelPlannerResponseModel {

    // API KEY : AIzaSyAJ4B7FN5C3otCX9Qjx2x24Q1yxGx6IEcY

    //https://fr.hotelplanner.com/common/cfcs/services/search.cfc?method=citySearch&vendor=tgx&aky=9DDEBF6FC917CD9DE0CDBD12FAD94E0B&City=VILLE%2C%20France&InDate=$s%2F$s%2F$s&OutDate=$s%2F$s%2F$s&NumRooms=1&destinationLatitude=$s&destinationLongitude=$s&IncludeDiscountBiz=1&amenityIds=&Landmark=0&SortBy=LatLonDistance&latLonName=none&latitude=none&longitude=none&_=1663654117684
    //https://fr.hotelplanner.com/common/cfcs/services/search.cfc?method=citySearch&vendor=tgx&aky=9DDEBF6FC917CD9DE0CDBD12FAD94E0B&City=VILLE%2C%20France&InDate=10%2F22%2F2022&OutDate=10%2F23%2F2022&NumRooms=1&destinationLatitude=43.604652&destinationLongitude=1.444209&IncludeDiscountBiz=1&amenityIds=&Landmark=0&SortBy=LatLonDistance&latLonName=none&latitude=none&longitude=none&_=1663654117628
    //https://fr.hotelplanner.com/common/cfcs/services/search.cfc?method=citySearch&vendor=eps&usePublicRates=1&modfilter=7&aky=9DDEBF6FC917CD9DE0CDBD12FAD94E0B&City=Lille%2C%20France&InDate=10%2F22%2F2022&OutDate=10%2F23%2F2022&NumRooms=1&destinationLatitude=50.637182&destinationLongitude=3.063017&IncludeDiscountBiz=1&amenityIds=&_=1663653766335

    private String currency;
    private String success;
    private String locale;
    private HotelPlannerModel data [];
    private String metric;
    private int totalCount;


    public HotelPlannerResponseModel() {
    }

    public HotelPlannerResponseModel(String currency, String success, String locale, HotelPlannerModel[] data,
            String metric, int totalCount) {
        this.currency = currency;
        this.success = success;
        this.locale = locale;
        this.data = data;
        this.metric = metric;
        this.totalCount = totalCount;
    }



    // Getter and Setter 
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }
    public String getLocale() {
        return locale;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }
    public HotelPlannerModel[] getData() {
        return data;
    }
    public void setData(HotelPlannerModel[] hotels) {
        this.data = hotels;
    }
    public String getMetric() {
        return metric;
    }
    public void setMetric(String metric) {
        this.metric = metric;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


}
