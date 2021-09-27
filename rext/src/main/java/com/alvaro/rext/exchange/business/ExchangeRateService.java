package com.alvaro.rext.exchange.business;

import com.alvaro.rext.exchange.model.api.ExchangeRateDTO;
import reactor.core.publisher.Mono;

public interface ExchangeRateService {

    Mono<ExchangeRateDTO> changeCoins(ExchangeRateDTO exchangeRateDTO);

}
