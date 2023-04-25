package com.detroitauctionshippers.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.detroitauctionshippers.model.Auction;

@Repository
public interface AuctionRepository extends CrudRepository<Auction, Long>{

}
