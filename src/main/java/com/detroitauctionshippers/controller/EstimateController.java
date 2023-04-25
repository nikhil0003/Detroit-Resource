package com.detroitauctionshippers.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.detroitauctionshippers.Repo.AuctionRepository;
import com.detroitauctionshippers.email.MailConstructor;
import com.detroitauctionshippers.model.Auction;
import com.detroitauctionshippers.model.CustomerDetails;
import com.detroitauctionshippers.model.LotDetails;
import com.detroitauctionshippers.model.PackagingDetails;
import com.detroitauctionshippers.model.ShippingAddress;
import com.detroitauctionshippers.pojo.EmailTemplate;

@RestController
public class EstimateController {

	@Autowired
	private AuctionRepository auctionRepository;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Autowired
	private JavaMailSender mailSender;

	@PostMapping("/estimate/{id}")
	public boolean estimate(@PathVariable("id") Long id) {

		EmailTemplate emailTemplate = new EmailTemplate();
		Optional<Auction> auction = auctionRepository.findById(id);
		if (auction.isPresent()) {
			CustomerDetails customerDetails = auction.get().getCustomerDetails();
			ShippingAddress shippingAddress = customerDetails.getShippingAddress();
			List<LotDetails> lotDetails = auction.get().getLotDetailsList();
			List<PackagingDetails> pdlist  = auction.get().getPackagingDetailsList();
			
			List<String> lotdetailsList = new ArrayList<>();
			lotDetails.forEach(lot ->{
				lotdetailsList.add("Lot "+lot.getLotno()+" "+lot.getLotdescription());
			});
			
			emailTemplate.setLotdetails(lotdetailsList);
			emailTemplate.setAddressline1(customerDetails.getFirstname() +" "
			+customerDetails.getMiddlename()+" "+customerDetails.getFirstnamename());
			emailTemplate.setAddressline2(shippingAddress.getShippingAddressStreet1()+" "+shippingAddress.getShippingAddressStreet2()); 
			emailTemplate.setAddressline3(shippingAddress.getShippingAddressCity() +" " +shippingAddress.getShippingAddressState()+" "
					+shippingAddress.getShippingAddressCountry()+" "+shippingAddress.getShippingAddressZipcode());
			emailTemplate.setEmail(customerDetails.getEmail());
			emailTemplate.setDeclaredValue(auction.get().getDeclaredValue());
			StringBuilder boxWeights = new StringBuilder("");
			StringBuilder boxTypes = new StringBuilder("");

			pdlist.forEach(box ->{
				boxWeights.append(box.getBoxWeight()+", ");
				boxTypes.append(box.getBoxType());
				if(box.getPackages() !=null) {
					boxTypes.append(box.getPackages()+", ");
				}

			});
			emailTemplate.setWeights(boxWeights.toString());
			emailTemplate.setBoxes(boxTypes.toString());
			emailTemplate.setShipvia("The total estimated cost to pick up, pack, and ship via UPS ground is $200 (Transit time: 5-8 business days).");
			MimeMessagePreparator email = mailConstructor.constructEstimateEmail(emailTemplate, Locale.ENGLISH);
			mailSender.send(email);
			return true;
		} else {
			return false;

		}

	}
}
