package com.alvaro.rext.exchange.model.entity;

import com.alvaro.rext.exchange.model.api.Currency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "exchange_rate")
@Getter
@Setter
public class ExchangeRate {

    @Id
    @GeneratedValue
    private UUID id;

    private Currency originCurrency;
    private Currency destinationCurrency;
    private Double exchangeRate;

}
