package com.detroitauctionshippers.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ShippingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String shippingAddressName;
	private String shippingAddressStreet1;
	private String shippingAddressStreet2;
	private String shippingAddressCity;
	private String shippingAddressState;
	private String shippingAddressCountry;
	private String shippingAddressZipcode;

	@OneToOne
	private CustomerDetails customerDetails;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the shippingAddressName
	 */
	public String getShippingAddressName() {
		return shippingAddressName;
	}

	/**
	 * @param shippingAddressName the shippingAddressName to set
	 */
	public void setShippingAddressName(String shippingAddressName) {
		this.shippingAddressName = shippingAddressName;
	}

	/**
	 * @return the shippingAddressStreet1
	 */
	public String getShippingAddressStreet1() {
		return shippingAddressStreet1;
	}

	/**
	 * @param shippingAddressStreet1 the shippingAddressStreet1 to set
	 */
	public void setShippingAddressStreet1(String shippingAddressStreet1) {
		this.shippingAddressStreet1 = shippingAddressStreet1;
	}

	/**
	 * @return the shippingAddressStreet2
	 */
	public String getShippingAddressStreet2() {
		return shippingAddressStreet2;
	}

	/**
	 * @param shippingAddressStreet2 the shippingAddressStreet2 to set
	 */
	public void setShippingAddressStreet2(String shippingAddressStreet2) {
		this.shippingAddressStreet2 = shippingAddressStreet2;
	}

	/**
	 * @return the shippingAddressCity
	 */
	public String getShippingAddressCity() {
		return shippingAddressCity;
	}

	/**
	 * @param shippingAddressCity the shippingAddressCity to set
	 */
	public void setShippingAddressCity(String shippingAddressCity) {
		this.shippingAddressCity = shippingAddressCity;
	}

	/**
	 * @return the shippingAddressState
	 */
	public String getShippingAddressState() {
		return shippingAddressState;
	}

	/**
	 * @param shippingAddressState the shippingAddressState to set
	 */
	public void setShippingAddressState(String shippingAddressState) {
		this.shippingAddressState = shippingAddressState;
	}

	/**
	 * @return the shippingAddressCountry
	 */
	public String getShippingAddressCountry() {
		return shippingAddressCountry;
	}

	/**
	 * @param shippingAddressCountry the shippingAddressCountry to set
	 */
	public void setShippingAddressCountry(String shippingAddressCountry) {
		this.shippingAddressCountry = shippingAddressCountry;
	}

	/**
	 * @return the shippingAddressZipcode
	 */
	public String getShippingAddressZipcode() {
		return shippingAddressZipcode;
	}

	/**
	 * @param shippingAddressZipcode the shippingAddressZipcode to set
	 */
	public void setShippingAddressZipcode(String shippingAddressZipcode) {
		this.shippingAddressZipcode = shippingAddressZipcode;
	}

	/**
	 * @return the customerDetails
	 */
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	/**
	 * @param customerDetails the customerDetails to set
	 */
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

}
