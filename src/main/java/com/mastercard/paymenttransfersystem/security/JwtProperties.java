package com.mastercard.paymenttransfersystem.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "token")
@Data
public class JwtProperties {
    
    Integer tokenExpireTime;
    
    Integer refreshCheckTime;
    
    Integer refreshTokenExpireTime;
    
    Integer shiroCacheExpireTime;
    
    String secretKey;
}
