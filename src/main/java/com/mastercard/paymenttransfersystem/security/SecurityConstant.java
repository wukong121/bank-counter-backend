package com.mastercard.paymenttransfersystem.security;

public class SecurityConstant {
    
    public static final String LOGIN_SALT = "story-admin";
    
    /**
     * request请求头属性
     */
    public static final String REQUEST_AUTH_HEADER = "Authorization";
    
    /**
     * JWT-account
     */
    public static final String ACCOUNT = "account";
    
    /**
     * 组织ID
     */
    public static final String ORG_ID_TOKEN = "orgIdToken";
    
    /**
     * Shiro redis prefix
     */
    public static final String PREFIX_SHIRO_CACHE = "story-admin:cache:";
    
    /**
     * redis-key-prefix-shiro:refresh_token
     */
    public final static String PREFIX_SHIRO_REFRESH_TOKEN = "story-admin:refresh_token:";
    
    /**
     * redis-key-prefix-shiro:refresh_check
     */
    public final static String PREFIX_SHIRO_REFRESH_CHECK = "story:refresh_check:";
    
    /**
     * JWT-currentTimeMillis
     */
    public final static String CURRENT_TIME_MILLIS = "currentTimeMillis";
    
}
