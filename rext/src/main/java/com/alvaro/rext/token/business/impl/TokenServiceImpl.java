package com.alvaro.rext.token.business.impl;

import com.alvaro.rext.exception.TokenException;
import com.alvaro.rext.token.business.TokenService;
import com.alvaro.rext.token.model.api.TokenDTO;
import com.alvaro.rext.token.model.entity.Token;
import com.alvaro.rext.util.Constants;
import com.alvaro.rext.token.repository.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    @Override
    public TokenDTO generateToken() {
        Long time = System.currentTimeMillis();

        Token token = new Token();
        token.setCreatedDate(new Date(time));
        token.setExpirationDate(new Date(time + 300000));
        this.tokenRepository.save(token);
        return TokenDTO.builder()
                .userToken(token.getId())
                .build();
    }

    @Override
    public void validateToken(UUID userToken) throws TokenException {
        Token token = this.tokenRepository.findById(userToken)
                .orElseThrow(() -> new TokenException(Constants.TOKEN_NOT_FOUND));
        this.valid(token);
    }

    private void valid(Token token) throws TokenException {
        Date now = new Date();
        if (now.after(token.getExpirationDate())) {
            this.tokenRepository.delete(token);
            throw new TokenException(Constants.TOKEN_EXPIRED);
        }
    }

}
