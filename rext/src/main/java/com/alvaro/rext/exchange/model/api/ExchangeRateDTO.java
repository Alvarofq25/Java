package com.alvaro.rext.exchange.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeRateDTO {

    private UUID id;
    private BigDecimal amount;

    @NotNull
    private Currency originCurrency;

    @NotNull
    private Currency destinationCurrency;

    private BigDecimal amountWithExchangeRate;

    @NotNull
    private Double exchangeRate;

}
