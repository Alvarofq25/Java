package com.alvaro.rext.token.business;

import com.alvaro.rext.exception.TokenException;
import com.alvaro.rext.token.model.api.TokenDTO;

import java.util.UUID;

public interface TokenService {

    TokenDTO generateToken();
    void validateToken(UUID userToken) throws TokenException;

}
