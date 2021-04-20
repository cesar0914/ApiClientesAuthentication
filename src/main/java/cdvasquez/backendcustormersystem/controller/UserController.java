package cdvasquez.backendcustormersystem.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdvasquez.backendcustormersystem.dto.UserDto;
import cdvasquez.backendcustormersystem.models.UserDetailRequesModel;
import cdvasquez.backendcustormersystem.models.UserRest;
import cdvasquez.backendcustormersystem.services.UserServiceInterface;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public UserRest getUsers() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String email = authentication.getPrincipal().toString();
		
		UserDto userDto = userService.geteUser(email);
		
		UserRest userToReturn = mapper.map(userDto, UserRest.class);
		
		return userToReturn;
		
	}
	
	
	@PostMapping(path = "/create")
	public UserRest createuser(@RequestBody UserDetailRequesModel userDetail ) {
		
		UserDto userDto = mapper.map(userDetail, UserDto.class);
		
		UserDto createdUser = userService.createUser(userDto);
		
		UserRest userToReturn = mapper.map(createdUser, UserRest.class );
		
		return userToReturn;
	}


}
