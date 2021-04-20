package cdvasquez.backendcustormersystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cdvasquez.backendcustormersystem.security.AppProperties;

@SpringBootApplication
public class BackendcustormersystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendcustormersystemApplication.class, args);
		System.out.println("funcionando");
	}
	
	@Bean
	public ModelMapper modelMapper() {		
		ModelMapper modelMapper = new ModelMapper();		
		return modelMapper;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();		
	}

	
	@Bean
	public SpringApplicationContex springApplicationContex() {
		return new SpringApplicationContex();
	}
	
	@Bean(name = "AppProperties")
	public AppProperties getAppProperties() {
		return new AppProperties();
	}
}
