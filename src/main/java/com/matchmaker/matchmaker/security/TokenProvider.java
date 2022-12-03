package com.matchmaker.matchmaker.security;


import com.matchmaker.matchmaker.config.Config;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenProvider {

    private final Config config;

    public String createToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date exirationData = new Date(now.getTime() + config.getTokenExpirationMsec());
        String jwt = Jwts.builder()
                .setSubject(userPrincipal.getId())
                .setIssuedAt(now)
                .setExpiration(exirationData)
                .signWith(SignatureAlgorithm.HS512, config.getTokenSecret())
                .compact();
        log.info(jwt);
        return jwt;
    }

    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(config.getTokenSecret())
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(config.getTokenSecret())
                    .parseClaimsJws(token);

            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT token is null or empty");
        }

        return false;
    }
}
