package com.alvaro.rext.exchange.business.impl;

import com.alvaro.rext.exception.ExchangeRateException;
import com.alvaro.rext.exchange.repository.ExchangeRateRepository;
import com.alvaro.rext.util.Constants;
import com.alvaro.rext.exchange.business.ExchangeRateService;
import com.alvaro.rext.exchange.model.api.ExchangeRateDTO;
import com.alvaro.rext.exchange.model.entity.ExchangeRate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    @Override
    public Mono<ExchangeRateDTO> changeCoins(final ExchangeRateDTO exchangeRateDTO) {

        ExchangeRate exchangeRate = this.exchangeRateRepository.findByOriginCurrencyAndDestinationCurrency(
                exchangeRateDTO.getOriginCurrency(), exchangeRateDTO.getDestinationCurrency());

        if (exchangeRate != null) {
            exchangeRateDTO.setExchangeRate(exchangeRate.getExchangeRate());
            exchangeRateDTO.setAmountWithExchangeRate(
                    this.calculateAmount(exchangeRateDTO.getAmount(), exchangeRate.getExchangeRate()));

            return Mono.just(exchangeRateDTO);
        } else {
            throw new ExchangeRateException(String.format(Constants.EXCHANGE_RATE_NOT_AVAILABLE,
                    exchangeRateDTO.getOriginCurrency()).concat(exchangeRateDTO.getDestinationCurrency().name()));
        }
    }

    private BigDecimal calculateAmount(BigDecimal amount, Double exchangeRate) {
        return amount.multiply(BigDecimal.valueOf(exchangeRate)).setScale(Constants.DECIMALS);
    }

}
