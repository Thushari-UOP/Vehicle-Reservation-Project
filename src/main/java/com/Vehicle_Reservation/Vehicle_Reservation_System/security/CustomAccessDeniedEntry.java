package com.Vehicle_Reservation.Vehicle_Reservation_System.security;

import com.Vehicle_Reservation.Vehicle_Reservation_System.resposes.ApiResponse;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
//import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomAccessDeniedEntry implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
        ObjectMapper objectMapper = new ObjectMapper();


        res.getWriter().write("Access denied");
    }
}
