package com.example.springssoauthserver.security;

import com.example.springssoauthserver.constant.JwtConstant;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.util.Date;

public class HiringJwtUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(HiringJwtUtil.class);

    public static String generateToken(String subject, int validDuration) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(validDuration).toInstant()))
                .signWith(SignatureAlgorithm.HS256, JwtConstant.JWT_REGISTERING_KEY);

        return builder.compact();
    }

    public static String getSubjectFromJwt(String token) {
        try {
            String subject = Jwts.parser().setSigningKey(JwtConstant.JWT_REGISTERING_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            return subject;
        } catch (SignatureException e) {
            LOGGER.warn("Invalid Jwt Signature");
            return null;
        } catch (ExpiredJwtException e) {
            LOGGER.warn("Expired Jwt");
            return null;
        } catch (Exception e) {
            LOGGER.warn("Exception Parsing Jwt");
            return null;
        }
    }

    public static Claims getClaimsFromJwt(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(JwtConstant.JWT_REGISTERING_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return claims;
        } catch (SignatureException e) {
            LOGGER.warn("Invalid Jwt Signature");
            return null;
        } catch (ExpiredJwtException e) {
            LOGGER.warn("Expired Jwt");
            return null;
        } catch (Exception e) {
            LOGGER.warn("Exception Parsing Jwt");
            return null;
        }
    }
}
