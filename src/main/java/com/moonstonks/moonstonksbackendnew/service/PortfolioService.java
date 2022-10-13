package com.moonstonks.moonstonksbackendnew.service;

import com.moonstonks.moonstonksbackendnew.model.Portfolio;

public interface PortfolioService {

    Portfolio createPortfolio(Portfolio portfolio);

    double getPortfolioValue();
}
