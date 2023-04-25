package com.detroitauctionshippers.model;


import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Auction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	
	private String totalNolot;
	
	private String totalNoBox;
	
	private String  declaredValue;
	
	private Date createDate;
	
	private Boolean isActive;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "auction")
	private List<LotDetails> lotDetailsList;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "auction")
	private List<PackagingDetails> packagingDetailsList;
	
	private String status;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private CustomerDetails customerDetails;
	
	
	
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



	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		Id = id;
	}

	/**
	 * @return the totalNolot
	 */
	public String getTotalNolot() {
		return totalNolot;
	}

	/**
	 * @param totalNolot the totalNolot to set
	 */
	public void setTotalNolot(String totalNolot) {
		this.totalNolot = totalNolot;
	}

	/**
	 * @return the totalNoBox
	 */
	public String getTotalNoBox() {
		return totalNoBox;
	}

	/**
	 * @param totalNoBox the totalNoBox to set
	 */
	public void setTotalNoBox(String totalNoBox) {
		this.totalNoBox = totalNoBox;
	}

	/**
	 * @return the declaredValue
	 */
	public String getDeclaredValue() {
		return declaredValue;
	}

	/**
	 * @param declaredValue the declaredValue to set
	 */
	public void setDeclaredValue(String declaredValue) {
		this.declaredValue = declaredValue;
	}

	/**
	 * @return the lotDetailsList
	 */
	public List<LotDetails> getLotDetailsList() {
		return lotDetailsList;
	}

	/**
	 * @param lotDetailsList the lotDetailsList to set
	 */
	public void setLotDetailsList(List<LotDetails> lotDetailsList) {
		this.lotDetailsList = lotDetailsList;
	}

	/**
	 * @return the packagingDetailsList
	 */
	public List<PackagingDetails> getPackagingDetailsList() {
		return packagingDetailsList;
	}

	/**
	 * @param packagingDetailsList the packagingDetailsList to set
	 */
	public void setPackagingDetailsList(List<PackagingDetails> packagingDetailsList) {
		this.packagingDetailsList = packagingDetailsList;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
