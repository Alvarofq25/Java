package com.alvaro.rext.exchange.business;

import com.alvaro.rext.exchange.model.api.ExchangeRateDTO;

import java.util.UUID;

public interface ManageExchangeRateService {

    ExchangeRateDTO register(ExchangeRateDTO exchangeRateDTO);
    ExchangeRateDTO update(ExchangeRateDTO exchangeRateDTO);
    void delete(UUID id);

}
