package com.moonstonks.moonstonksbackendnew.service;

import com.moonstonks.moonstonksbackendnew.model.Holding;
import com.moonstonks.moonstonksbackendnew.model.Portfolio;

import java.util.List;

public interface PortfolioService {

    Portfolio createPortfolio(Portfolio portfolio);

    String updateName(String name);

    String getName();

    double getPortfolioValue();

    double getPortfolioRevenue();

    double getPortfolioRevenuePercent();

    void createHolding(Holding holding);

    void addHolding(String holdingSymbol, int amount);

    void removeHolding(String holdingSymbol, int amount);

    List<Holding> getHoldings();

}
