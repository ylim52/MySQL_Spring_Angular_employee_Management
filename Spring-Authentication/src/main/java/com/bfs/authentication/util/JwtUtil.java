package com.bfs.authentication.util;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JwtUtil {

    public static String generateToken(String signingKey, String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
//        Date expire = new Date(nowMillis + TimeUnit.MINUTES.toMillis(30));

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
//                .setExpiration(expire)
                .signWith(SignatureAlgorithm.HS256, signingKey);
        return builder.compact();
    }
}
