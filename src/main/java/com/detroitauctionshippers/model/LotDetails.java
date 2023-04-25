package com.detroitauctionshippers.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LotDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String lotno;
	
	private String lotdescription;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="auction_id")
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
	 * @return the lotno
	 */
	public String getLotno() {
		return lotno;
	}

	/**
	 * @param lotno the lotno to set
	 */
	public void setLotno(String lotno) {
		this.lotno = lotno;
	}

	/**
	 * @return the lotdescription
	 */
	public String getLotdescription() {
		return lotdescription;
	}

	/**
	 * @param lotdescription the lotdescription to set
	 */
	public void setLotdescription(String lotdescription) {
		this.lotdescription = lotdescription;
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
			
	

}
