package com.app.model;

public class PriceData {
	private String state;
    private String district;
    private String market;
    private String commodity;
    private String price;

    // Constructors
    public PriceData() {}
    
    public PriceData(String state, String district, String market, String commodity, String price) {
        this.state = state;
        this.district = district;
        this.market = market;
        this.commodity = commodity;
        this.price = price;
    }

    // Getters and Setters
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getMarket() { return market; }
    public void setMarket(String market) { this.market = market; }

    public String getCommodity() { return commodity; }
    public void setCommodity(String commodity) { this.commodity = commodity; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
}
