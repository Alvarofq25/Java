package com.alvaro.rext.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class TokenException extends Exception {

    public TokenException(String message) {
        super(message);
    }

}
