package com.detroitauctionshippers.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.detroitauctionshippers.model.BillingAddress;

@Repository
public interface BillingRepository extends CrudRepository<BillingAddress, Long> {
	
	

}
