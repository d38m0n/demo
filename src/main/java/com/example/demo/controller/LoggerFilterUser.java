package com.example.demo.controller;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class LoggerFilterUser implements Filter {

    private static final Logger loger = LoggerFactory.getLogger(LoggerFilterUser.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest instanceof HttpServletRequest) {
            var httpRequest = (HttpServletRequest) servletRequest;
            loger.info("[doFilter] " + httpRequest.getMethod() + " " + httpRequest.getRequestURI());
        }
        filterChain.doFilter(servletRequest,servletResponse);


    }
}
