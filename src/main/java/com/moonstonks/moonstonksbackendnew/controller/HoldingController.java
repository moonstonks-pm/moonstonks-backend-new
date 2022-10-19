package com.moonstonks.moonstonksbackendnew.controller;

import com.moonstonks.moonstonksbackendnew.model.API.GlobalQuote;
import com.moonstonks.moonstonksbackendnew.model.Holding;
import com.moonstonks.moonstonksbackendnew.service.HoldingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/holding")
public class HoldingController {

    private HoldingService holdingService;

    public HoldingController(HoldingService holdingService) {
        this.holdingService = holdingService;
    }

    @GetMapping("/{symbol}")
    public Holding getHolding(@PathVariable String symbol) {
        return holdingService.getHolding(symbol);
    }

}
