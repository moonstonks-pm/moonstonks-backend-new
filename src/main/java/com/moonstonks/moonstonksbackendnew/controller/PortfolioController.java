package com.moonstonks.moonstonksbackendnew.controller;

import com.moonstonks.moonstonksbackendnew.model.Holding;
import com.moonstonks.moonstonksbackendnew.model.Portfolio;
import com.moonstonks.moonstonksbackendnew.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/name")
    public String updatePortfolioName(@RequestBody String name) {
        return portfolioService.updateName(name);
    }

    @GetMapping("/name")
    public String getPortfolioName() {
        return portfolioService.getName();
    }


    @GetMapping("/value")
    public double getPortfolioValue() {
        return portfolioService.getPortfolioValue();
    }

    //Revenue

    @GetMapping("/revenue")
    public double getPortfolioRevenue() {
        return portfolioService.getPortfolioRevenue();
    }

    @GetMapping("/revenue/percent")
    public double getPortfolioRevenuePercent() {
        return portfolioService.getPortfolioRevenuePercent();
    }

    //Holding

    @PostMapping("/holdings")
    public void createHolding(@RequestBody Holding holding) {
        portfolioService.createHolding(holding);
    }

    @PutMapping("/holdings/{holdingSymbol}")
    public void addHolding(@PathVariable String holdingSymbol, @PathVariable int amount) {
        portfolioService.addHolding(holdingSymbol, amount);
    }

    @DeleteMapping("/holdings/{holdingSymbol}")
    public void removeHolding(@PathVariable String holdingSymbol, @PathVariable int amount) {
        portfolioService.removeHolding(holdingSymbol, amount);
    }

    @GetMapping("/holdings")
    public List<Holding> getHoldings() {
        return portfolioService.getHoldings();
    }

    //needs other stats like count of assetklasses, sectors, countries, etc
}
