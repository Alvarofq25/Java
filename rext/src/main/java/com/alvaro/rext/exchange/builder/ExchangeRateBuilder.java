package com.alvaro.rext.exchange.builder;

import com.alvaro.rext.exchange.model.api.ExchangeRateDTO;
import com.alvaro.rext.exchange.model.entity.ExchangeRate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ExchangeRateBuilder {

    public ExchangeRate buildExchangeRate(ExchangeRateDTO exchangeRateDTO) {
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setId(exchangeRateDTO.getId());
        exchangeRate.setOriginCurrency(exchangeRateDTO.getOriginCurrency());
        exchangeRate.setDestinationCurrency(exchangeRateDTO.getDestinationCurrency());
        exchangeRate.setExchangeRate(exchangeRateDTO.getExchangeRate());
        return exchangeRate;
    }

    public ExchangeRateDTO buildExchangeRateDTO(ExchangeRate exchangeRate) {
        return ExchangeRateDTO.builder()
                .id(exchangeRate.getId())
                .originCurrency(exchangeRate.getOriginCurrency())
                .destinationCurrency(exchangeRate.getDestinationCurrency())
                .exchangeRate(exchangeRate.getExchangeRate())
                .build();
    }

}
