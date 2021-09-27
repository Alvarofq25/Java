package com.alvaro.rext.expose.web;

import com.alvaro.rext.exchange.business.ExchangeRateService;
import com.alvaro.rext.exchange.model.api.ExchangeRateDTO;
import com.alvaro.rext.exchange.model.api.ExchangeRateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/exchange-rate")
@AllArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @PostMapping
    public Mono<ExchangeRateDTO> exchange(@Valid @RequestBody ExchangeRateRequest exchangeRateRequest) {
        return exchangeRateService.changeCoins(ExchangeRateDTO.builder()
                .amount(exchangeRateRequest.getAmount())
                .originCurrency(exchangeRateRequest.getOriginCurrency())
                .destinationCurrency(exchangeRateRequest.getDestinationCurrency())
                .build());
    }

}
