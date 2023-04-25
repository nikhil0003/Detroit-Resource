
package com.detroitauctionshippers.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class BillingAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String BillingAddressName;
	private String BillingAddressStreet1;
	private String BillingAddressStreet2;
	private String BillingAddressCity;
	private String BillingAddressState;
	private String BillingAddressCountry;
	private String BillingAddressZipcode;

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
	 * @return the billingAddressName
	 */
	public String getBillingAddressName() {
		return BillingAddressName;
	}

	/**
	 * @param billingAddressName the billingAddressName to set
	 */
	public void setBillingAddressName(String billingAddressName) {
		BillingAddressName = billingAddressName;
	}

	/**
	 * @return the billingAddressStreet1
	 */
	public String getBillingAddressStreet1() {
		return BillingAddressStreet1;
	}

	/**
	 * @param billingAddressStreet1 the billingAddressStreet1 to set
	 */
	public void setBillingAddressStreet1(String billingAddressStreet1) {
		BillingAddressStreet1 = billingAddressStreet1;
	}

	/**
	 * @return the billingAddressStreet2
	 */
	public String getBillingAddressStreet2() {
		return BillingAddressStreet2;
	}

	/**
	 * @param billingAddressStreet2 the billingAddressStreet2 to set
	 */
	public void setBillingAddressStreet2(String billingAddressStreet2) {
		BillingAddressStreet2 = billingAddressStreet2;
	}

	/**
	 * @return the billingAddressCity
	 */
	public String getBillingAddressCity() {
		return BillingAddressCity;
	}

	/**
	 * @param billingAddressCity the billingAddressCity to set
	 */
	public void setBillingAddressCity(String billingAddressCity) {
		BillingAddressCity = billingAddressCity;
	}

	/**
	 * @return the billingAddressState
	 */
	public String getBillingAddressState() {
		return BillingAddressState;
	}

	/**
	 * @param billingAddressState the billingAddressState to set
	 */
	public void setBillingAddressState(String billingAddressState) {
		BillingAddressState = billingAddressState;
	}

	/**
	 * @return the billingAddressCountry
	 */
	public String getBillingAddressCountry() {
		return BillingAddressCountry;
	}

	/**
	 * @param billingAddressCountry the billingAddressCountry to set
	 */
	public void setBillingAddressCountry(String billingAddressCountry) {
		BillingAddressCountry = billingAddressCountry;
	}

	/**
	 * @return the billingAddressZipcode
	 */
	public String getBillingAddressZipcode() {
		return BillingAddressZipcode;
	}

	/**
	 * @param billingAddressZipcode the billingAddressZipcode to set
	 */
	public void setBillingAddressZipcode(String billingAddressZipcode) {
		BillingAddressZipcode = billingAddressZipcode;
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
