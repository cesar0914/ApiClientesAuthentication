package cdvasquez.backendcustormersystem.services;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cdvasquez.backendcustormersystem.dto.UserDto;
import cdvasquez.backendcustormersystem.entities.UserEntity;
import cdvasquez.backendcustormersystem.repositories.UserReporitoryInterface;

@Service
public class UserServiceImpl implements UserServiceInterface {
	
	@Autowired
	private UserReporitoryInterface userReporitory;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		UserEntity userEntity = mapper.map(userDto, UserEntity.class);
		
		UUID userId = UUID.randomUUID();
		
		userEntity.setUserId(userId.toString());
		
		userEntity.setEncrypptedPassword(
				bCryptPasswordEncoder.encode(userDto.getPassword()));
		
		UserEntity storedUser = userReporitory.save(userEntity);
		
		UserDto userToReturn = mapper.map(storedUser, UserDto.class);
		
		return userToReturn;
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userReporitory.findUserByEmail(email);
		
		if(userEntity == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new User(userEntity.getEmail(), userEntity.getEncrypptedPassword(), new ArrayList<>());
	}


	@Override
	public UserDto geteUser(String email) {
		UserEntity userEntity = userReporitory.findUserByEmail(email);
		
		if(userEntity == null) {
			throw new UsernameNotFoundException(email);
		}
		
		UserDto userToReturn = mapper.map(userEntity, UserDto.class);
		
		return userToReturn;
		
		
	}

}
