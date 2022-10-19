package com.moonstonks.moonstonksbackendnew.controller;

import com.moonstonks.moonstonksbackendnew.model.Holding;
import com.moonstonks.moonstonksbackendnew.model.Portfolio;
import com.moonstonks.moonstonksbackendnew.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/portfolio")
public class PortfolioController {

    private PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }


    @PostMapping("")
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    @DeleteMapping("/{id}")
    public void deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);
    }

    @GetMapping("/{id}")
    public Portfolio getPortfolio(@PathVariable Long id) {
        return portfolioService.getPortfolio(id);
    }

    @PutMapping("/{id}/{name}")
    public String updatePortfolioName(@PathVariable Long id, @PathVariable String name) {
        return portfolioService.updatePortfolioName(id,name);
    }

    //Revenue

    @GetMapping("{id}/revenue")
    public double getPortfolioRevenue(@PathVariable long id) {
        return portfolioService.getPortfolioRevenue(id);
    }

    @GetMapping("{id}/revenue/percent")
    public double getPortfolioRevenuePercent(@PathVariable long id) {
        return portfolioService.getPortfolioRevenuePercent(id);
    }

    //Holding

    @PostMapping("/{id}/holdings/{holdingSymbol}/{amount}")
    public Holding addHolding(@PathVariable long id,@PathVariable String holdingSymbol, @PathVariable int amount) {
        return portfolioService.addHolding(id, holdingSymbol, amount);
    }

    @DeleteMapping("/{id}/holdings/{holdingSymbol}/{amount}")
    public void removeHolding(@PathVariable Long id, @PathVariable String holdingSymbol, @PathVariable int amount) {
        portfolioService.removeHolding(id, holdingSymbol, amount);
    }

    @GetMapping("/{id}/holdings")
    public List<Holding> getAllHoldings(@PathVariable Long id) {
        return portfolioService.getAllHoldings(id);
    }

    @PutMapping("/{id}/updateValues")
    public Portfolio updateValues(@PathVariable Long id) {
        return portfolioService.updateValues(id);
    }
}
