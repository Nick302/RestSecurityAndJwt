package net.proselyte.jwtappdemo.security.jwt;

import org.springframework.security.core.AuthenticationException;



public class JwtAuthenticationException extends AuthenticationException {
   //класс исключений

    public JwtAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}
