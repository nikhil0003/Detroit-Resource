package com.detroitauctionshippers.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.detroitauctionshippers.model.CustomerDetails;

@Repository
public interface CustomerDeatilsRepository  extends CrudRepository<CustomerDetails, Long> {

	CustomerDetails findByEmail(String email);

}
