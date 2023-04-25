package com.detroitauctionshippers.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.detroitauctionshippers.model.LotDetails;

@Repository
public interface LotDetailsRepository  extends CrudRepository<LotDetails, Long> {

}
