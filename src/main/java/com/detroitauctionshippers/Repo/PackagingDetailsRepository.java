package com.detroitauctionshippers.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.detroitauctionshippers.model.PackagingDetails;

@Repository
public interface PackagingDetailsRepository extends CrudRepository<PackagingDetails, Long> {

}
