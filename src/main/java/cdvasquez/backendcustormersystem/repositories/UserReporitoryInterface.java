package cdvasquez.backendcustormersystem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cdvasquez.backendcustormersystem.entities.UserEntity;

@Repository
public interface UserReporitoryInterface extends CrudRepository<UserEntity, Long> {
	
	public UserEntity findUserByEmail(String email);

}
