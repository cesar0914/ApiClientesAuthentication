package cdvasquez.backendcustormersystem.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import cdvasquez.backendcustormersystem.dto.UserDto;

@Service
public interface UserServiceInterface extends UserDetailsService {
	
	public UserDto createUser(UserDto userDto);
	public UserDto geteUser(String email);

}
