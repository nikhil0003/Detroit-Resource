package com.detroitauctionshippers.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PackagingDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String boxType;
	
	private String boxWeight;
	
	private String packages;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "auction_id")
	private Auction auction;

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
	 * @return the boxType
	 */
	public String getBoxType() {
		return boxType;
	}

	/**
	 * @param boxType the boxType to set
	 */
	public void setBoxType(String boxType) {
		this.boxType = boxType;
	}

	/**
	 * @return the auction
	 */
	public Auction getAuction() {
		return auction;
	}

	/**
	 * @param auction the auction to set
	 */
	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	/**
	 * @return the packages
	 */
	public String getPackages() {
		return packages;
	}

	/**
	 * @param packages the packages to set
	 */
	public void setPackages(String packages) {
		this.packages = packages;
	}

	/**
	 * @return the boxWeight
	 */
	public String getBoxWeight() {
		return boxWeight;
	}

	/**
	 * @param boxWeight the boxWeight to set
	 */
	public void setBoxWeight(String boxWeight) {
		this.boxWeight = boxWeight;
	}
	
	
	

}
