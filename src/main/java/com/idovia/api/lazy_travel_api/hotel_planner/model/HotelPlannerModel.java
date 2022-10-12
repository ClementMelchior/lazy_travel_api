package com.idovia.api.lazy_travel_api.hotel_planner.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelPlannerModel {

    @JsonProperty("Zip")
    private String Zip;
    @JsonProperty("HotelDetailsLink")
    private String HotelDetailsLink;
    @JsonProperty("DistanceAddress")
    private String DistanceAddress;
    @JsonProperty("HotelName")
    private String HotelName;
    @JsonProperty("Longitude")
    private Double Longitude;
    @JsonProperty("Phone")
    private String Phone;
    @JsonProperty("State")
    private String State;
    @JsonProperty("Comments")
    private String Comments;
    @JsonProperty("AddressDirection")
    private String AddressDirection;
    @JsonProperty("LatLonDirection")
    private String LatLonDirection;
    private Double cscore;
    private int priority;
    @JsonProperty("Cost")
    private String Cost;
    @JsonProperty("HotelIdTypeId")
    private int HotelIdTypeId;
    @JsonProperty("ThumbnailURL")
    private String ThumbnailURL;
    private String id;
    @JsonProperty("LandmarkDirection")
    private String LandmarkDirection;
    @JsonProperty("Address1")
    private String Address1;
    @JsonProperty("HotelId")
    private int HotelId;
    @JsonProperty("Currency")
    private String Currency;
    private Double totalTaxRate;
    @JsonProperty("DistanceToAddress")
    private String DistanceToAddress;
    @JsonProperty("LatLonDistance")
    private String LatLonDistance;
    @JsonProperty("ZipCode")
    private int ZipCode;
    @JsonProperty("CostNumeric")
    private Double CostNumeric;
    @JsonProperty("ZipDirection")
    private String ZipDirection;
    @JsonProperty("PromoText")
    private String PromoText;
    @JsonProperty("CostLong")
    private String CostLong;
    @JsonProperty("CityDirection")
    private String CityDirection;
    @JsonProperty("IsExclusiveRate")
    private int IsExclusiveRate;
    @JsonProperty("DistanceFromCity")
    private Double DistanceFromCity;
    @JsonProperty("DistanceFromLandmark")
    private String DistanceFromLandmark;
    private String tnid;
    @JsonProperty("Landmark")
    private String Landmark;
    @JsonProperty("City")
    private String City;
    @JsonProperty("CountryCode")
    private String CountryCode;
    @JsonProperty("Rating")
    private Double Rating;
    @JsonProperty("DistanceFromZip")
    private String DistanceFromZip;
    @JsonProperty("Review")
    private Double Review;
    @JsonProperty("ValueAdds")
    private String ValueAdds;
    private String vendor;
    @JsonProperty("Latitude")
    private Double Latitude;
    @JsonProperty("SecondaryLine")
    private String SecondaryLine;
    

    public HotelPlannerModel(String Zip, String hotelDetailsLink, String distanceAddress, String hotelName,
            Double longitude, String phone, String state, String comments, String addressDirection,
            String latLonDirection, Double cscore, int priority, String cost, int hotelIdTypeId, String thumbnailURL,
            String id, String landmarkDirection, String address1, int hotelId, String currency, Double totalTaxRate,
            String distanceToAddress, String latLonDistance, int zipCode, Double costNumeric, String zipDirection,
            String promoText, String costLong, String cityDirection, int isExclusiveRate, Double distanceFromCity,
            String distanceFromLandmark, String tnid, String landmark, String city, String countryCode, Double rating,
            String distanceFromZip, Double review, String valueAdds, String vendor, Double latitude,
            String secondaryLine) {
                this.Zip = Zip;
                this.HotelDetailsLink = hotelDetailsLink;
                this.DistanceAddress = distanceAddress;
                this.HotelName = hotelName;
                this.Longitude = longitude;
                this.Phone = phone;
                this.State = state;
                this.Comments = comments;
                this.AddressDirection = addressDirection;
                this.LatLonDirection = latLonDirection;
                this.cscore = cscore;
                this.priority = priority;
                this.Cost = cost;
                this.HotelIdTypeId = hotelIdTypeId;
                this.ThumbnailURL = thumbnailURL;
                this.id = id;
                this.LandmarkDirection = landmarkDirection;
                this.Address1 = address1;
                this.Currency = currency;
                this.totalTaxRate = totalTaxRate;
                this.DistanceToAddress = distanceToAddress;
                this.LatLonDistance = latLonDistance;
                this.ZipCode = zipCode;
                this.CostNumeric = costNumeric;
                this.ZipDirection = zipDirection;
                this.PromoText = promoText;
                this.CostLong = costLong;
                this.CityDirection = cityDirection;
                this.IsExclusiveRate = isExclusiveRate;
                this.DistanceFromCity = distanceFromCity;
                this.DistanceFromLandmark = distanceFromLandmark;
                this.tnid = tnid;
                this.Landmark=landmark;
                this.City = city;
                this.CountryCode = countryCode;
                this.Rating = rating;
                this.DistanceFromZip = distanceFromZip;
                this.Review = review;
                this.ValueAdds = valueAdds;
                this.vendor = vendor;
                this.Latitude = latitude;
                this.SecondaryLine = secondaryLine;
    }


    public HotelPlannerModel() {
    }


    public String toString () {
        return this.HotelId + " | " + this.Address1 + " | " + this.City + " | " + this.Cost + " | " + this.HotelName + " | " + this.Review + " | " + this.DistanceFromCity;
    }

    // Getter and Setter

    public String getZip() {
        return Zip;
    }

    public void setZip(String Zip) {
        this.Zip = Zip;
    }

    public String getHotelDetailsLink() {
        return HotelDetailsLink;
    }

    public void setHotelDetailsLink(String hotelDetailsLink) {
        HotelDetailsLink = hotelDetailsLink;
    }

    public String getDistanceAddress() {
        return DistanceAddress;
    }

    public void setDistanceAddress(String distanceAddress) {
        DistanceAddress = distanceAddress;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public String getAddressDirection() {
        return AddressDirection;
    }

    public void setAddressDirection(String addressDirection) {
        AddressDirection = addressDirection;
    }

    public String getLatLonDirection() {
        return LatLonDirection;
    }

    public void setLatLonDirection(String latLonDirection) {
        LatLonDirection = latLonDirection;
    }

    public Double getCscore() {
        return cscore;
    }

    public void setCscore(Double cscore) {
        this.cscore = cscore;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public int getHotelIdTypeId() {
        return HotelIdTypeId;
    }

    public void setHotelIdTypeId(int hotelIdTypeId) {
        HotelIdTypeId = hotelIdTypeId;
    }

    public String getThumbnailURL() {
        return ThumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        ThumbnailURL = thumbnailURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLandmarkDirection() {
        return LandmarkDirection;
    }

    public void setLandmarkDirection(String landmarkDirection) {
        LandmarkDirection = landmarkDirection;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public int getHotelId() {
        return HotelId;
    }

    public void setHotelId(int hotelId) {
        HotelId = hotelId;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public Double getTotalTaxRate() {
        return totalTaxRate;
    }

    public void setTotalTaxRate(Double totalTaxRate) {
        this.totalTaxRate = totalTaxRate;
    }

    public String getDistanceToAddress() {
        return DistanceToAddress;
    }

    public void setDistanceToAddress(String distanceToAddress) {
        DistanceToAddress = distanceToAddress;
    }

    public String getLatLonDistance() {
        return LatLonDistance;
    }

    public void setLatLonDistance(String latLonDistance) {
        LatLonDistance = latLonDistance;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public void setZipCode(int zipCode) {
        ZipCode = zipCode;
    }

    public Double getCostNumeric() {
        return CostNumeric;
    }

    public void setCostNumeric(Double costNumeric) {
        CostNumeric = costNumeric;
    }

    public String getZipDirection() {
        return ZipDirection;
    }

    public void setZipDirection(String zipDirection) {
        ZipDirection = zipDirection;
    }

    public String getPromoText() {
        return PromoText;
    }

    public void setPromoText(String promoText) {
        PromoText = promoText;
    }

    public String getCostLong() {
        return CostLong;
    }

    public void setCostLong(String costLong) {
        CostLong = costLong;
    }

    public String getCityDirection() {
        return CityDirection;
    }

    public void setCityDirection(String cityDirection) {
        CityDirection = cityDirection;
    }

    public int getIsExclusiveRate() {
        return IsExclusiveRate;
    }

    public void setIsExclusiveRate(int isExclusiveRate) {
        IsExclusiveRate = isExclusiveRate;
    }

    public Double getDistanceFromCity() {
        return DistanceFromCity;
    }

    public void setDistanceFromCity(Double distanceFromCity) {
        DistanceFromCity = distanceFromCity;
    }

    public String getDistanceFromLandmark() {
        return DistanceFromLandmark;
    }

    public void setDistanceFromLandmark(String distanceFromLandmark) {
        DistanceFromLandmark = distanceFromLandmark;
    }

    public String getTnid() {
        return tnid;
    }

    public void setTnid(String tnid) {
        this.tnid = tnid;
    }

    public String getLandmark() {
        return Landmark;
    }

    public void setLandmark(String landmark) {
        Landmark = landmark;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }

    public String getDistanceFromZip() {
        return DistanceFromZip;
    }

    public void setDistanceFromZip(String distanceFromZip) {
        DistanceFromZip = distanceFromZip;
    }

    public Double getReview() {
        return Review;
    }

    public void setReview(Double review) {
        Review = review;
    }

    public String getValueAdds() {
        return ValueAdds;
    }

    public void setValueAdds(String valueAdds) {
        ValueAdds = valueAdds;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public String getSecondaryLine() {
        return SecondaryLine;
    }

    public void setSecondaryLine(String secondaryLine) {
        SecondaryLine = secondaryLine;
    }
    
}
