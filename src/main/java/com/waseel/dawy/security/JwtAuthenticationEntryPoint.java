package com.waseel.dawy.security;

import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint,
        Serializable {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse
            response,
                         AuthenticationException authException) throws
            IOException, ServletException {
        JsonObject errors = new JsonObject();
        errors.addProperty("code", HttpServletResponse.SC_UNAUTHORIZED);
        errors.addProperty("status", HttpStatus.UNAUTHORIZED.getReasonPhrase());
        errors.addProperty("message", "Incorrect email or password.");
        response.getWriter().write(errors.toString());
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setHeader("Content-Type", "application/json");

    }
}