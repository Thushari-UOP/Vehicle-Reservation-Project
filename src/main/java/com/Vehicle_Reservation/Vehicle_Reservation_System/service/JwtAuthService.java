package com.Vehicle_Reservation.Vehicle_Reservation_System.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtAuthService {

    public String generateToken(String userName) {
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private String createToken(Map<String,Object> claims, String userName){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60))
                .signWith(getSignedKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignedKey(){
        String secretKey = "MySecretKeyMySecretKeyMySecretKeyMySecretKeyMySecretKeyMySecretKey";
        byte[] bytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(bytes);
    }

    public String extractUserName(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignedKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String name = extractUserName(token);
        return (name.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public Date extractExpiration(String token){
        return extractClaims(token,Claims::getExpiration);
    }
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


}
