package com.alvaro.rext.expose.web;

import com.alvaro.rext.token.business.TokenService;
import com.alvaro.rext.token.model.api.TokenDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/authenticate")
@AllArgsConstructor
public class TokenController {

    private final TokenService tokenService;

    @GetMapping
    public TokenDTO getToken() {
        return this.tokenService.generateToken();
    }

}
