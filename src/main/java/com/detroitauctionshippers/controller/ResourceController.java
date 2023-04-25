package com.detroitauctionshippers.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.detroitauctionshippers.Repo.CustomerDeatilsRepository;
import com.detroitauctionshippers.model.BillingAddress;
import com.detroitauctionshippers.model.CustomerDetails;
import com.detroitauctionshippers.model.ShippingAddress;
import com.detroitauctionshippers.pojo.CustomerDetailsRequest;

@RestController
public class ResourceController {

	@Autowired
	private CustomerDeatilsRepository customerDeatilsRepository;

	@PostMapping(value = "/customerDetails")
	public CustomerDetails updateCustomerDetails(@RequestBody CustomerDetailsRequest customerDetailsRequest) {
		if(customerDetailsRequest.getCustomerId()!=null) {
			Optional<CustomerDetails> cd = customerDeatilsRepository.findById(Long.valueOf(customerDetailsRequest.getCustomerId()));
			if(cd.isPresent()) {
				return cd.get();
			}
			else 
				return cd.get();
		}
		
		else {
			CustomerDetails newCd = new CustomerDetails();
			newCd.setFirstname(customerDetailsRequest.getFirstName());
			newCd.setLastname(customerDetailsRequest.getLastName());
			newCd.setMiddlename(customerDetailsRequest.getMiddlename());
			newCd.setPhone(customerDetailsRequest.getPhone());
			newCd.setEmail(customerDetailsRequest.getEmail());
			ShippingAddress shippingAddress = new ShippingAddress();
			shippingAddress.setShippingAddressStreet1(customerDetailsRequest.getShippingAddressStreet1());
			shippingAddress.setShippingAddressStreet2(customerDetailsRequest.getShippingAddressStreet2());
			shippingAddress.setShippingAddressState(customerDetailsRequest.getShippingAddressState());
			shippingAddress.setShippingAddressCountry(customerDetailsRequest.getShippingAddressCountry());
			shippingAddress.setShippingAddressCity(customerDetailsRequest.getShippingAddressCity());
			shippingAddress.setShippingAddressZipcode(customerDetailsRequest.getShippingAddressZipcode());
			BillingAddress billingAddress = new BillingAddress();
			billingAddress.setBillingAddressStreet1(customerDetailsRequest.getBillingAddressStreet1());
			billingAddress.setBillingAddressStreet2(customerDetailsRequest.getBillingAddressStreet2());
			billingAddress.setBillingAddressState(customerDetailsRequest.getBillingAddressState());
			billingAddress.setBillingAddressCountry(customerDetailsRequest.getBillingAddressCountry());
			billingAddress.setBillingAddressCity(customerDetailsRequest.getBillingAddressCity());
			billingAddress.setBillingAddressZipcode(customerDetailsRequest.getBillingAddressZipcode());
			newCd.setBillingAddress(billingAddress);
			newCd.setShippingAddress(shippingAddress);
			return customerDeatilsRepository.save(newCd);
		}

	}
	
	@PostMapping(value="/Search")
	public CustomerDetails getCustomerDeatils (@RequestBody CustomerDetailsRequest customerDetailsRequest) {
		return customerDeatilsRepository.findByEmail(customerDetailsRequest.getEmail());
		
	}

}
