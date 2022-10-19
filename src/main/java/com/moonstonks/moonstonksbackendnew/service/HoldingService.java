package com.moonstonks.moonstonksbackendnew.service;

import com.moonstonks.moonstonksbackendnew.model.API.GlobalQuote;
import com.moonstonks.moonstonksbackendnew.model.Holding;

public interface HoldingService {
    Holding getHolding(String symbol);

}
