package com.app.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.model.PriceData;
import com.app.service.PriceService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class PriceController {
	 @Autowired
	    private PriceService priceService;

	    @GetMapping("/states")
	    public List<String> getStates() {
	        return priceService.getStates();
	    }

	    @GetMapping("/districts")
	    public List<String> getDistricts(@RequestParam String state) {
	        return priceService.getDistricts(state);
	    }

	    @GetMapping("/markets")
	    public List<String> getMarkets(@RequestParam String state, @RequestParam String district) {
	        return priceService.getMarkets(state, district);
	    }

	    @GetMapping("/price")
	    public PriceData getPrice(
	        @RequestParam String state,
	        @RequestParam String district,
	        @RequestParam String market,
	        @RequestParam String commodity
	    ) {
	        return priceService.getPrice(state, district, market, commodity);
	    }
}
