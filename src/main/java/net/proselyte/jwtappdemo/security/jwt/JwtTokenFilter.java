package net.proselyte.jwtappdemo.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



public class JwtTokenFilter extends GenericFilterBean {
    //фильтрация запросов на основании токена , нет токена - аташол :D

    private JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    //
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {

        String token = jwtTokenProvider.resolveToken((HttpServletRequest) req); // получаем токен из запроса
        if (token != null && jwtTokenProvider.validateToken(token)) { // если все ок
            Authentication auth = jwtTokenProvider.getAuthentication(token);

            if (auth != null) {
                SecurityContextHolder.getContext().setAuthentication(auth); // аутинтифицируем запрос
            }
        }
        filterChain.doFilter(req, res);
    }

}
