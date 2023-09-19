package com.example.daisoproject1.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {
//
//    private String secretKey;

@Value("${security.jwt.token.secret-key}")
    private String secretKey;
    @Value("${security.jwt.token.expire-length}")
    private long validityInMilliseconds;
    public JwtTokenProvider(@Value("${security.jwt.token.secret-key}")String secretKey, @Value("${security.jwt.token.expire-length}") long validityInMilliseconds) {
        this.secretKey = secretKey;
        this.validityInMilliseconds = validityInMilliseconds;

    }

    //토큰생성
    public String createToken(String subject) {
        Claims claims = Jwts.claims().setSubject(subject);

        Date now = new Date();

        Date validity = new Date(now.getTime()
                + validityInMilliseconds);
        System.out.println(this.secretKey.getBytes());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, this.secretKey.getBytes())
                .compact();
    }

    //토큰에서 값 추출
    public String getSubject(String token) {
        try {
            System.out.println(this.secretKey.getBytes());
            String subject = Jwts.parser().setSigningKey(this.secretKey.getBytes()).parseClaimsJws(token).getBody().getSubject();
            System.out.println(subject);
            return subject;
        } catch (Exception E) {
            E.printStackTrace();
            return null;
        }
    }

    //유효한 토큰인지 확인
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token);
            if (claims.getBody().getExpiration().before(new Date())) {
                return false;
            }
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
