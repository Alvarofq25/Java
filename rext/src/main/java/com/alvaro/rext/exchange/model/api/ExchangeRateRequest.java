package com.alvaro.rext.exchange.model.api;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ExchangeRateRequest {

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Currency originCurrency;

    @NotNull
    private Currency destinationCurrency;


}
