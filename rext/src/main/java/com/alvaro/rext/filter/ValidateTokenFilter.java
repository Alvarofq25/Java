package com.alvaro.rext.filter;

import com.alvaro.rext.exception.TokenException;
import com.alvaro.rext.token.business.TokenService;
import com.alvaro.rext.util.Constants;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ValidateTokenFilter implements WebFilter {

    private final TokenService tokenService;

    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        if (request.getURI().getPath().contains("/authenticate")) {
            return webFilterChain.filter(serverWebExchange);
        }
        String userToken = serverWebExchange.getRequest().getHeaders().getFirst(Constants.TOKEN);
        if (userToken == null) throw new TokenException(Constants.TOKEN_NOT_NULL);
        this.tokenService.validateToken(UUID.fromString(userToken));
        return webFilterChain.filter(serverWebExchange);
    }
}