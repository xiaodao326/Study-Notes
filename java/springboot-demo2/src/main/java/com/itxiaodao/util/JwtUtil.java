package com.itxiaodao.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "secret";
    private static final long EXPIRATION = 3600_000; // 1小时

    public static String generateToken(Integer userId, String username) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("username", username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
