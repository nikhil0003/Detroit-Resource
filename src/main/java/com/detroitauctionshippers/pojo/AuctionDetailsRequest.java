package com.detroitauctionshippers.pojo;

import java.util.List;

public class AuctionDetailsRequest {
	
	public Long userId;
	public String declaredvalue;
	public String estimate;
	public String shipvia;
	public List<Lot> lots;
	public List<Box> boxes;

	/**
	 * @return the declaredvalue
	 */
	public String getDeclaredvalue() {
		return declaredvalue;
	}

	/**
	 * @param declaredvalue the declaredvalue to set
	 */
	public void setDeclaredvalue(String declaredvalue) {
		this.declaredvalue = declaredvalue;
	}

	/**
	 * @return the estimate
	 */
	public String getEstimate() {
		return estimate;
	}

	/**
	 * @param estimate the estimate to set
	 */
	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}

	/**
	 * @return the shipvia
	 */
	public String getShipvia() {
		return shipvia;
	}

	/**
	 * @param shipvia the shipvia to set
	 */
	public void setShipvia(String shipvia) {
		this.shipvia = shipvia;
	}

	/**
	 * @return the lots
	 */
	public List<Lot> getLots() {
		return lots;
	}

	/**
	 * @param lots the lots to set
	 */
	public void setLots(List<Lot> lots) {
		this.lots = lots;
	}

	/**
	 * @return the boxes
	 */
	public List<Box> getBoxes() {
		return boxes;
	}

	/**
	 * @param boxes the boxes to set
	 */
	public void setBoxes(List<Box> boxes) {
		this.boxes = boxes;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}


	
	
	

}
