package cdvasquez.backendcustormersystem.security;

import cdvasquez.backendcustormersystem.SpringApplicationContex;

public class SecurityConstants {
	
	public static final long EXPIRATION_DATE = 864000000; // 10 días
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEARER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/v1/users";
    
    
    public static String getTokenSecret() {
    	AppProperties appProperties = (AppProperties) SpringApplicationContex.getBean("AppProperties");
    	
    	return appProperties.getTokenSecret();
    }
}
