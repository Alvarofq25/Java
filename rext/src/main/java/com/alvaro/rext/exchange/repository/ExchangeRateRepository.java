package com.alvaro.rext.exchange.repository;

import com.alvaro.rext.exchange.model.api.Currency;
import com.alvaro.rext.exchange.model.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, UUID> {

    ExchangeRate findByOriginCurrencyAndDestinationCurrency(Currency originCurrency, Currency destinationCurrency);

}
