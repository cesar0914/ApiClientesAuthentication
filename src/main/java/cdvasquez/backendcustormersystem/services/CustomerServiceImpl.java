package cdvasquez.backendcustormersystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdvasquez.backendcustormersystem.dto.CustomerDto;
import cdvasquez.backendcustormersystem.entities.CreditCardEntity;
import cdvasquez.backendcustormersystem.entities.CustomerEntity;
import cdvasquez.backendcustormersystem.exceptions.CustomerNotExistsException;
import cdvasquez.backendcustormersystem.exceptions.EmailExistsException;
import cdvasquez.backendcustormersystem.repositories.CustomerRepositoryInterface;

@Service
public class CustomerServiceImpl implements CustomerServiceInterface{
	
	@Autowired
	private CustomerRepositoryInterface customerRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	public List<CustomerDto> getCustomers(){
		
		List<CustomerEntity> customersEntity = new ArrayList<CustomerEntity>();
				
		customersEntity = customerRepository.findAll();
		
		List<CustomerDto> customersDto = new ArrayList<CustomerDto>();
		
		for (CustomerEntity customerEntity : customersEntity) {
			
			CustomerDto customerDto = mapper.map(customerEntity, CustomerDto.class);
			
			customersDto.add(customerDto);
		}
		
		return customersDto;
	}
	
	
	public CustomerDto createCustomer(CustomerDto customerDto) {
		
		if(customerRepository.findCustomerByEmail(customerDto.getEmail()) != null) {
			throw new EmailExistsException("El correo electrónico ya existe");
		}		
				
		CustomerEntity customerEntity = mapper.map(customerDto, CustomerEntity.class);
		
		CustomerEntity storedCustomer = customerRepository.save(customerEntity); 
		
		CustomerDto customerToReturn = mapper.map(storedCustomer, CustomerDto.class);
		
		return customerToReturn;
		
	}


	@Override
	public void deleteCustomer(Long customerId) {
		
		boolean exists = customerRepository.existsById(customerId);
		if(!exists) {
			throw new CustomerNotExistsException("student with id "+ customerId + " does not exists");
		}
		
		customerRepository.deleteById(customerId);
		
	}

	
	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {		
				
		Optional<CustomerEntity> customerOptional = customerRepository.findCustomerByIdentId(customerDto.getIdentId()); 
				
		if(customerOptional.isPresent()) {
						
			
			if(!Objects.equals(customerOptional.get().getEmail(), customerDto.getEmail())) {
					
				if(customerRepository.findCustomerByEmail(customerDto.getEmail()) != null) {
					throw new EmailExistsException("El correo electrónico ya existe");
				}				
			}
			
		}else {
			throw new CustomerNotExistsException("El usuario a actualizar no existe");
		}
						
		CustomerEntity customerToUpdate = customerOptional.get();
		
		customerToUpdate.setFirstName(customerDto.getFirstName());
		customerToUpdate.setLastName(customerDto.getLastName());
		customerToUpdate.setIdentId(customerDto.getIdentId());
		customerToUpdate.setPhoneNumber(customerDto.getPhoneNumber());
		
		CreditCardEntity creditCardEntity = new CreditCardEntity();
		
		creditCardEntity.setId(customerToUpdate.getCreditCard().getId());
		creditCardEntity.setCardNumber(customerDto.getCreditCard().getCardNumber());
		creditCardEntity.setCardName(customerDto.getCreditCard().getCardName());
		creditCardEntity.setExpirationMonth(customerDto.getCreditCard().getExpirationMonth());
		creditCardEntity.setExpirationYear(customerDto.getCreditCard().getExpirationYear());
		
		customerToUpdate.setCreditCard(creditCardEntity);
		
		CustomerEntity updatedCustomer = customerRepository.save(customerToUpdate);	
		
		CustomerDto customerToReturn = mapper.map(updatedCustomer, CustomerDto.class);
		
		return customerToReturn;
		
	}

}
