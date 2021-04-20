package cdvasquez.backendcustormersystem.exceptions;

public class CustomerNotExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CustomerNotExistsException(String message) {
		super(message);
	}
}
