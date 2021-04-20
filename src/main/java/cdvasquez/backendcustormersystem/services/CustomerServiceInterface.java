package cdvasquez.backendcustormersystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cdvasquez.backendcustormersystem.dto.CustomerDto;
import cdvasquez.backendcustormersystem.entities.CustomerEntity;

@Service
public interface CustomerServiceInterface {
	
	
	public List<CustomerDto> getCustomers();
	
	public CustomerDto createCustomer(CustomerDto customer);

	public void deleteCustomer(Long customerId);

	public CustomerDto updateCustomer(CustomerDto customerDto);
	
	
}
