package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.model.PriceData;
import com.app.service.DropdownService;

@RestController
@RequestMapping("/dailyprice")
public class StateController {

    @Autowired
    private DropdownService dropdownService;

    @GetMapping("/prices")
    public PriceData getPrices(@RequestParam String state, @RequestParam String district, @RequestParam String market, @RequestParam String commodity) {
        return dropdownService.getPrices(state, district, market, commodity);
    }
}