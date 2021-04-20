package cdvasquez.backendcustormersystem.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionsHandler {
	
	
	@ExceptionHandler(value = { EmailExistsException.class})
	public ResponseEntity<Object> handlerEmailExistsExceptions(EmailExistsException ex, WebRequest webRequest){
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { CustomerNotExistsException.class})
	public ResponseEntity<Object> handlerCustomerNotExistsExceptions(CustomerNotExistsException ex, WebRequest webRequest){
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	// resto de excepciones
	@ExceptionHandler(value = { Exception.class})
	public ResponseEntity<Object> handlerExceptions(Exception ex, WebRequest webRequest){
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
