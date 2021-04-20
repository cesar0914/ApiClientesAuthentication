package cdvasquez.backendcustormersystem.models;

public class CustomerRest {

	private long id;	
	private String firstName;
	private String lastName;
	private String identId;
	private String email;
	private String phoneNumber;
	private CreditCardRest creditCard;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentId() {
		return identId;
	}

	public void setIdentId(String identId) {
		this.identId = identId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CreditCardRest getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardRest creditCard) {
		this.creditCard = creditCard;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
