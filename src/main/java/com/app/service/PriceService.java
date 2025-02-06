package com.app.service;

import java.util.*;

import org.json.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import com.app.model.PriceData;

@Service
public class PriceService {
	
	  private final String API_URL = "https://api.data.gov.in/resource/9ef84268-d588-465a-a308-a864a43d0070?api-key=579b464db66ec23bdd000001757d65ded0294c736cce4065702c67dd&offset=0&limit=all&format=csv&format=json";
	  public List<String> getStates() {
		  
		  
	        List<String> states = new ArrayList<>();
	        RestTemplate restTemplate = new RestTemplate();
	        String response = restTemplate.getForObject(API_URL, String.class);
	        JSONObject json = new JSONObject(response);
	        JSONArray records = json.getJSONArray("records");

	        for (int i = 0; i < records.length(); i++) {
	            String state = records.getJSONObject(i).getString("state");
	            if (!states.contains(state)) {
	                states.add(state);
	            }
	        }
	        
	        for (int i = 0; i < records.length(); i++) {
	            String state = records.getJSONObject(i).getString("state");
	            System.out.println(state+" ");
	        }
	        return states;
	    }

	    public List<String> getDistricts(String state) {
	        List<String> districts = new ArrayList<>();
	        RestTemplate restTemplate = new RestTemplate();
	        String response = restTemplate.getForObject(API_URL, String.class);
	        JSONObject json = new JSONObject(response);
	        JSONArray records = json.getJSONArray("records");

	        for (int i = 0; i < records.length(); i++) {
	            JSONObject record = records.getJSONObject(i);
	            if (record.getString("state").equalsIgnoreCase(state)) {
	                String district = record.getString("district");
	                if (!districts.contains(district)) {
	                    districts.add(district);
	                }
	            }
	        }
	        return districts;
	    }

	    public List<String> getMarkets(String state, String district) {
	        List<String> markets = new ArrayList<>();
	        RestTemplate restTemplate = new RestTemplate();
	        String response = restTemplate.getForObject(API_URL, String.class);
	        JSONObject json = new JSONObject(response);
	        JSONArray records = json.getJSONArray("records");

	        for (int i = 0; i < records.length(); i++) {
	            JSONObject record = records.getJSONObject(i);
	            if (record.getString("state").equalsIgnoreCase(state) &&
	                record.getString("district").equalsIgnoreCase(district)) {
	                String market = record.getString("market");
	                if (!markets.contains(market)) {
	                    markets.add(market);
	                }
	            }
	        }
	        return markets;
	    }

	    public PriceData getPrice(String state, String district, String market, String commodity) {
	        RestTemplate restTemplate = new RestTemplate();
	        String response = restTemplate.getForObject(API_URL, String.class);
	        JSONObject json = new JSONObject(response);
	        JSONArray records = json.getJSONArray("records");

	        for (int i = 0; i < records.length(); i++) {
	            JSONObject record = records.getJSONObject(i);
	            if (record.getString("state").equalsIgnoreCase(state) &&
	                record.getString("district").equalsIgnoreCase(district) &&
	                record.getString("market").equalsIgnoreCase(market) &&
	                record.getString("commodity").equalsIgnoreCase(commodity)) {
	                return new PriceData(state, district, market, commodity, record.getString("modal_price"));
	            }
	        }
	        return null;
	
}
}