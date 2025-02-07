package com.app.model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceData {
    private String state;
    private String district;
    private String market;
    private String commodity;
    private String variety;
    private String grade;
    private String arrival_date;
    private double min_price;
    private double max_price;
    private double modal_price;
/*
    // Getters and setters
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getMarket() {
        return market;
    }
    public void setMarket(String market) {
        this.market = market;
    }
    public String getCommodity() {
        return commodity;
    }
    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }
    public String getVariety() {
        return variety;
    }
    public void setVariety(String variety) {
        this.variety = variety;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getArrival_date() {
        return arrival_date;
    }
    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }
    public double getMin_price() {
        return min_price;
    }
    public void setMin_price(double min_price) {
        this.min_price = min_price;
    }
    public double getMax_price() {
        return max_price;
    }
    public void setMax_price(double max_price) {
        this.max_price = max_price;
    }
    public double getModal_price() {
        return modal_price;
    }
    public void setModal_price(double modal_price) {
        this.modal_price = modal_price;
    }*/
}