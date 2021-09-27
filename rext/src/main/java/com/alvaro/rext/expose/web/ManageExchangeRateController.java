package com.alvaro.rext.expose.web;

import com.alvaro.rext.exchange.business.ManageExchangeRateService;
import com.alvaro.rext.exchange.model.api.ExchangeRateDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping("/manage/exchange-rate")
@AllArgsConstructor
public class ManageExchangeRateController {

    private final ManageExchangeRateService manageExchangeRateService;

    @PostMapping
    public ExchangeRateDTO register(@Valid @RequestBody ExchangeRateDTO exchangeRateDTO) {
        return this.manageExchangeRateService.register(exchangeRateDTO);
    }

    @PutMapping
    public ExchangeRateDTO update(@Valid @RequestBody ExchangeRateDTO exchangeRateDTO) {
        return this.manageExchangeRateService.update(exchangeRateDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> update(@NotNull @PathVariable UUID id) {
        this.manageExchangeRateService.delete(id);
        return ResponseEntity.ok()
                .build();
    }

}
