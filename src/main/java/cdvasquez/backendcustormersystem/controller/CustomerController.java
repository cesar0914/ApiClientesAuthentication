package cdvasquez.backendcustormersystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cdvasquez.backendcustormersystem.dto.CustomerDto;
import cdvasquez.backendcustormersystem.models.CustomerDetailRequestModel;
import cdvasquez.backendcustormersystem.models.CustomerRest;
import cdvasquez.backendcustormersystem.models.OperationStatusModel;
import cdvasquez.backendcustormersystem.services.CustomerServiceInterface;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerServiceInterface customerService;

	@Autowired
	private ModelMapper mapper;

	@GetMapping(path = "/list")
	public List<CustomerRest> getCustomers() {

		List<CustomerDto> customersDto = customerService.getCustomers();

		List<CustomerRest> customersRest = new ArrayList<CustomerRest>();

		for (CustomerDto customerDto : customersDto) {

			CustomerRest customerRest = mapper.map(customerDto, CustomerRest.class);

			customersRest.add(customerRest);

		}

		return customersRest;
	}

	@PostMapping(path = "/create")
	public CustomerRest createCustomer(@RequestBody CustomerDetailRequestModel customerDetail) {

		CustomerDto customerDto = mapper.map(customerDetail, CustomerDto.class);

		CustomerDto createdCustomer = customerService.createCustomer(customerDto);

		CustomerRest customerToreturn = mapper.map(createdCustomer, CustomerRest.class);

		return customerToreturn;
	}

	@DeleteMapping(path = "/{customerId}")
	public OperationStatusModel deleteCustomer(@PathVariable Long customerId) {

		OperationStatusModel operationStatusModel = new OperationStatusModel();

		operationStatusModel.setName("DELETE");

		customerService.deleteCustomer(customerId);

		operationStatusModel.setResult("SUCCESS");

		return operationStatusModel;
	}

	@PutMapping
	public OperationStatusModel updateCustomer(@RequestBody CustomerDetailRequestModel customerDetail) {

		CustomerDto customerDto = mapper.map(customerDetail, CustomerDto.class);

		OperationStatusModel operationStatusModel = new OperationStatusModel();

		operationStatusModel.setName("UPDATE");

		customerService.updateCustomer(customerDto);

		operationStatusModel.setResult("SUCCESS");

		return operationStatusModel;

	}

}
