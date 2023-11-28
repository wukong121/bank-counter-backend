package com.mastercard.paymenttransfersystem.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class JwtUtil {
    
    @Autowired
    JwtProperties jwtProperties;
    
    @Autowired
    private static JwtUtil jwtUtil;
    
    @PostConstruct
    public void init() {
        jwtUtil = this;
        jwtUtil.jwtProperties = this.jwtProperties;
    }
    
    public static String sign(String account, String currentTimeMillis) {
        String secret = account + jwtUtil.jwtProperties.getSecretKey();
        Date date = new Date(System.currentTimeMillis() + jwtUtil.jwtProperties.getTokenExpireTime() * 60 * 1000L);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create().withClaim(SecurityConstant.ACCOUNT, account)
                .withClaim(SecurityConstant.CURRENT_TIME_MILLIS, currentTimeMillis).withExpiresAt(date).sign(algorithm);
    }
    
    public static String getClaim(String token, String claim) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim(claim).asString();
    }
    
    public static boolean verify(String token) {
        String secret = getClaim(token, SecurityConstant.ACCOUNT) + jwtUtil.jwtProperties.getSecretKey();
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm).build();
        verifier.verify(token);
        return true;
    }
    
}
