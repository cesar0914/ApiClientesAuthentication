package cdvasquez.backendcustormersystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdvasquez.backendcustormersystem.entities.CustomerEntity;

@Repository
public interface CustomerRepositoryInterface extends JpaRepository<CustomerEntity, Long>{
	
	public Optional<CustomerEntity> findCustomerByIdentId(String identId);
	
	public CustomerEntity findCustomerByEmail(String email);
}

