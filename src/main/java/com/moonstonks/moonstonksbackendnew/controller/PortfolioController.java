package com.moonstonks.moonstonksbackendnew.controller;

import com.moonstonks.moonstonksbackendnew.model.Portfolio;
import com.moonstonks.moonstonksbackendnew.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping("")
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    @GetMapping("/value")
    public double getPortfolioValue() {
        return portfolioService.getPortfolioValue();
    }
}
