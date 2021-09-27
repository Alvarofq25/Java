package com.alvaro.rext.exchange.business.impl;

import com.alvaro.rext.exception.ExchangeRateException;
import com.alvaro.rext.exchange.repository.ExchangeRateRepository;
import com.alvaro.rext.util.Constants;
import com.alvaro.rext.exchange.builder.ExchangeRateBuilder;
import com.alvaro.rext.exchange.business.ManageExchangeRateService;
import com.alvaro.rext.exchange.model.api.ExchangeRateDTO;
import com.alvaro.rext.exchange.model.entity.ExchangeRate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ManageExchangeRateServiceImpl implements ManageExchangeRateService {

    private final ExchangeRateBuilder exchangeRateBuilder;
    private final ExchangeRateRepository exchangeRateRepository;

    @Override
    public ExchangeRateDTO register(ExchangeRateDTO exchangeRateDTO) {
        return this.exchangeRateBuilder.buildExchangeRateDTO(
                this.exchangeRateRepository.save(this.exchangeRateBuilder.buildExchangeRate(exchangeRateDTO)));
    }

    @Override
    public ExchangeRateDTO update(ExchangeRateDTO exchangeRateDTO) {
        if (exchangeRateDTO.getId() != null) {
            ExchangeRate exchangeRate = this.exchangeRateRepository.findById(exchangeRateDTO.getId())
                    .orElseThrow(() -> new ExchangeRateException(Constants.EXCHANGE_RATE_NOT_FOUND));
            exchangeRate.setExchangeRate(exchangeRateDTO.getExchangeRate());
            exchangeRate.setOriginCurrency(exchangeRateDTO.getOriginCurrency());
            exchangeRate.setDestinationCurrency(exchangeRateDTO.getDestinationCurrency());
            return this.exchangeRateBuilder.buildExchangeRateDTO(this.exchangeRateRepository.save(exchangeRate));
        } else {
            throw new ExchangeRateException(Constants.EXCHANGE_RATE_NOT_NULL);
        }
    }

    @Override
    public void delete(UUID id) {
        this.exchangeRateRepository.deleteById(id);
    }
}
