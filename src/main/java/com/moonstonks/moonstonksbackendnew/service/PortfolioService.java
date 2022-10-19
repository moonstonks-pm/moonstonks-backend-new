package com.moonstonks.moonstonksbackendnew.service;

import com.moonstonks.moonstonksbackendnew.model.Holding;
import com.moonstonks.moonstonksbackendnew.model.Portfolio;

import java.util.List;

public interface PortfolioService {

    Portfolio createPortfolio(Portfolio portfolio);

    void deletePortfolio(Long id);

    Portfolio getPortfolio(Long id);

    String updatePortfolioName(Long id, String name);

    double getPortfolioRevenue(long id);

    double getPortfolioRevenuePercent(long id);

    Holding addHolding(long id, String holdingSymbol, int amount);

    void removeHolding(Long id, String holdingSymbol, int amount);

    List<Holding> getAllHoldings(Long id);

    Portfolio updateValues(Long id);
}
