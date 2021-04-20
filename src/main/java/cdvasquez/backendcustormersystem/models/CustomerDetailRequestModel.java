package cdvasquez.backendcustormersystem.models;

public class CustomerDetailRequestModel {

	
	private String firstName;
	private String lastName;
	private String identId;
	private String email;
	private String phoneNumber;
	private CreditCardDetailRequestModel creditCard;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String address) {
		this.email = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CreditCardDetailRequestModel getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardDetailRequestModel creditCard) {
		this.creditCard = creditCard;
	}	

	public String getIdentId() {
		return identId;
	}

	public void setIdentIdn(String identId) {
		this.identId = identId;
	}
	
	

}
