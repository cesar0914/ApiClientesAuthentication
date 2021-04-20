package cdvasquez.backendcustormersystem.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cdvasquez.backendcustormersystem.dto.CreditCardDto;
import cdvasquez.backendcustormersystem.models.CreditCardDetailRequestModel;

@Entity(name = "customers")
@Table(indexes = {@Index(columnList = "identId", name = "index_identid", unique = true), 
		          @Index(columnList = "email", name = "index_email", unique = true)})
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String identId;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="creditCardId", nullable = false)	
	@JsonIgnore
	private CreditCardEntity creditCard;

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

	public CreditCardEntity getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardEntity creditCard) {
		this.creditCard = creditCard;
	}
	

}
