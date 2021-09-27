package com.alvaro.rext.exception;

import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(value = ExchangeRateException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Map<String, String> exchangeRateException(ExchangeRateException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("message", exception.getMessage());
        return response;
    }

    @ExceptionHandler(value = TokenException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public Map<String, String> tokenException(TokenException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("message", exception.getMessage());
        return response;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, String> argumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("message", exception.getFieldError().getDefaultMessage());
        return response;
    }

    @ExceptionHandler(value = DecodingException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, String> decodingException(DecodingException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("message", exception.getMessage());
        return response;
    }

}
