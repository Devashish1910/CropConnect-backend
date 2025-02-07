package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.model.PriceData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Service
public class DropdownService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "https://api.data.gov.in/resource/9ef84268-d588-465a-a308-a864a43d0070";
    private static final String API_KEY = "579b464db66ec23bdd000001cdd3946e44ce4aad7209ff7b23ac571b";

    public PriceData getPrices(String state, String district, String market, String commodity) {
        String url = String.format(
            "%s?api-key=%s&format=json&filters[state.keyword]=%s&filters[district]=%s&filters[market]=%s&filters[commodity]=%s",
            API_URL, API_KEY, state, district, market, commodity);
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode records = mapper.readTree(response).get("records");
            if (records.isArray() && records.size() > 0) {
                JsonNode record = records.get(0);
                PriceData priceData = new PriceData();
                priceData.setState(record.get("state").asText());
                priceData.setDistrict(record.get("district").asText());
                priceData.setMarket(record.get("market").asText());
                priceData.setCommodity(record.get("commodity").asText());
                priceData.setVariety(record.get("variety").asText());
                priceData.setGrade(record.get("grade").asText());
                priceData.setArrival_date(record.get("arrival_date").asText());
                priceData.setMin_price(record.get("min_price").asDouble());
                priceData.setMax_price(record.get("max_price").asDouble());
                priceData.setModal_price(record.get("modal_price").asDouble());
                return priceData;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new PriceData();
    }
}