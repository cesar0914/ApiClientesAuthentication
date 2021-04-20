package cdvasquez.backendcustormersystem.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import cdvasquez.backendcustormersystem.SpringApplicationContex;
import cdvasquez.backendcustormersystem.dto.UserDto;
import cdvasquez.backendcustormersystem.models.UserLoginRequestModel;
import cdvasquez.backendcustormersystem.services.UserServiceInterface;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;
	
	
	public AuthenticationFilter(AuthenticationManager authenticationManager) {		
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		
		try {
			UserLoginRequestModel userLoginRequestModel = new ObjectMapper().readValue(request.getInputStream(), UserLoginRequestModel.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginRequestModel.getEmail(), userLoginRequestModel.getPassword(), new ArrayList<>()));
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		String username = ((User) authResult.getPrincipal()).getUsername();
		
		String token =Jwts.builder()
				.setSubject(username)
				.setExpiration(new  Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_DATE))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret()).compact();
		
		UserServiceInterface userServiceInterface = (UserServiceInterface) SpringApplicationContex.getBean("userServiceImpl");
		
		UserDto userDto = userServiceInterface.geteUser(username);
		
		response.addHeader("UserId", userDto.getUserId());
		response.addHeader(SecurityConstants.HEARER_STRING, SecurityConstants.TOKEN_PREFIX+token);
		
	}
	
	
	
	
		
}
