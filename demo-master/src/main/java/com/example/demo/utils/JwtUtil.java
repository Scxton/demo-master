package com.example.demo.utils;

import com.example.demo.service.JwtBlacklistService;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    @Autowired
    private JwtBlacklistService jwtBlacklistService;

    /**
     * 生成token
     * @param username
     * @return
     */
    public String generateToken(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 验证token
     * @param token
     * @param username
     * @return
     */
    public Boolean validateToken(String token, String username) {
        if (jwtBlacklistService.isTokenBlacklisted(token)) {
            return false;
        }
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    /**
     * 获取用户名
     * @param token
     * @return
     */
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    /**
     * 判断token是否过期
     * @param token
     * @return
     */
    public Boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    /**
     * 解析jwt
     * @param token
     * @return
     */
    public Claims extractAllClaims(String token) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token cannot be null or empty");
        }
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            log.error("Token has expired", e);
            throw new SecurityException("Token has expired");
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token", e);
            throw new SecurityException("Unsupported JWT token");
        } catch (MalformedJwtException e) {
            log.error("Malformed JWT token", e);
            throw new SecurityException("Malformed JWT token");
        } catch (SignatureException e) {
            log.error("Invalid JWT signature", e);
            throw new SecurityException("Invalid JWT signature");
        } catch (IllegalArgumentException e) {
            log.error("Invalid token", e);
            throw new SecurityException("Invalid token");
        }
    }
}