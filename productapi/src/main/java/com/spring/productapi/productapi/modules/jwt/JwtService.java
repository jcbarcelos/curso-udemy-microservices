package com.spring.productapi.productapi.modules.jwt;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import static org.springframework.util.ObjectUtils.isEmpty;

public class JwtService {

    private static final String BEARER = "bearer ";
    @Value("${app-config.secretes.api-secret}")
    private String apiSecret;

    public void isAuthorized(String token) {
        try {

        } catch (Exception exception) {

        }
    }
    public String extractToken(String token) {
       if (isEmpty(token)){
           return null;
       }
       if (token.toLowerCase().contains(BEARER)){
           return token.replace(BEARER, Strings.EMPTY);
       }
    }

}
