package com.example.demo.JWT;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final String SECRET = "AutoNovaSecretKeyParaJWTdeMinimo256bits1234567890";
    private static final long EXPIRATION_TIME = 86400000; // 1 día en milisegundos

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String correo, String role) {
        return Jwts.builder()
                .setSubject(correo)
                .claim("roles", role)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getCorreoFromToken(String token) {
        return getClaims(token).getSubject();
    }
}