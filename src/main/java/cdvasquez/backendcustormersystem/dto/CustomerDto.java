package cdvasquez.backendcustormersystem.dto;

import java.io.Serializable;

import cdvasquez.backendcustormersystem.models.CreditCardDetailRequestModel;

public class CustomerDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String identId;	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private CreditCardDto creditCard;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdentId() {
		return identId;
	}

	public void setIdentId(String identId) {
		this.identId = identId;
	}

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

	public CreditCardDto getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardDto creditCard) {
		this.creditCard = creditCard;
	}

}
