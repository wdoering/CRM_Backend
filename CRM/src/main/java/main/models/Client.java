package main.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields: 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	@Column(nullable = false)
	private Integer cnpj;
	@Column(nullable = false)
	private String tradeName;
	@Column(nullable = false)
	private String legalName;
	private String stateRegistrationNumber;
	@Column(nullable = false)
	private String primaryContactName;
	@Column(nullable = false)
	private String street;
	private String addressNumber;
	private String neighborhood;
	private String city;
	private Integer stateID; //FK to the states ENTITY
	private String postalCode;
	private String email;

	public Client() {

	}

	public Integer getCNPJ() {
		return cnpj;
	}

	public void setCNPJ(Integer cNPJ) {
		cnpj = cNPJ;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getStateRegistrationNumber() {
		return stateRegistrationNumber;
	}

	public void setStateRegistrationNumber(String stateRegistrationNumber) {
		this.stateRegistrationNumber = stateRegistrationNumber;
	}

	public String getPrimaryContactName() {
		return primaryContactName;
	}

	public void setPrimaryContactName(String primaryContactName) {
		this.primaryContactName = primaryContactName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}


}
