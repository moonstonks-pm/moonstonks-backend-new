package com.moonstonks.moonstonksbackendnew.service;

import com.moonstonks.moonstonksbackendnew.model.Holding;
import com.moonstonks.moonstonksbackendnew.model.Portfolio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        return null;
    }

    @Override
    public String updateName(String name) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPortfolioValue() {
        return 0;
    }

    @Override
    public double getPortfolioRevenue() {
        return 0;
    }

    @Override
    public double getPortfolioRevenuePercent() {
        return 0;
    }

    @Override
    public void createHolding(Holding holding) {

    }

    @Override
    public void addHolding(String holdingSymbol, int amount) {

    }

    @Override
    public void removeHolding(String holdingSymbol, int amount) {

    }

    @Override
    public List<Holding> getHoldings() {
        return null;
    }

}
