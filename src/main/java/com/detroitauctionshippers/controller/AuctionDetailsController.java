package com.detroitauctionshippers.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.detroitauctionshippers.Repo.AuctionRepository;
import com.detroitauctionshippers.Repo.CustomerDeatilsRepository;
import com.detroitauctionshippers.model.Auction;
import com.detroitauctionshippers.model.CustomerDetails;
import com.detroitauctionshippers.model.LotDetails;
import com.detroitauctionshippers.model.PackagingDetails;
import com.detroitauctionshippers.pojo.AuctionDetailsRequest;
import com.detroitauctionshippers.pojo.AuctionDetailsResponse;

@RestController
public class AuctionDetailsController {

	@Autowired
	private CustomerDeatilsRepository customerDeatilsRepository;

	@Autowired
	private AuctionRepository auctionRepository;

	@PostMapping(value = "/create/auction")
	public AuctionDetailsResponse createAuction(@RequestBody AuctionDetailsRequest auctionDetailsRequest) {
		AuctionDetailsResponse auctionDetailsResponse = new AuctionDetailsResponse();
		Optional<CustomerDetails> customerDetails = customerDeatilsRepository
				.findById(auctionDetailsRequest.getUserId());
		if (customerDetails.isPresent()) {
			List<Auction> auctionList = new ArrayList<>();
			Auction auction = new Auction();
			auction.setCustomerDetails(customerDetails.get());
			auction.setCreateDate(new Date());
			auction.setDeclaredValue(auctionDetailsRequest.getDeclaredvalue());
			auction.setTotalNolot(String.valueOf(auctionDetailsRequest.getLots().size()));
			auction.setTotalNoBox(String.valueOf(auctionDetailsRequest.getBoxes().size()));
			List<LotDetails> lotDetailsList = new ArrayList<>();
			auctionDetailsRequest.getLots().forEach(lot -> {
				LotDetails ld = new LotDetails();
				ld.setLotno(lot.getLotno());
				ld.setLotdescription(lot.getLotdescription());
				ld.setAuction(auction);
				lotDetailsList.add(ld);
			});
			List<PackagingDetails> packagingDetailsList = new ArrayList<>();
			auctionDetailsRequest.getBoxes().forEach(box -> {
				PackagingDetails pd = new PackagingDetails();
				pd.setAuction(auction);
				pd.setBoxWeight(box.getWeight());
				pd.setPackages(String.valueOf(box.isBubbles()));
				pd.setBoxType(box.getBoxsize());
				if (box.isBubbles() || box.isFoamsheet() || box.isDoubleBox() || box.isFoam() || box.isCardBoardpkg()
						|| box.isPenuts() || box.getOthers() !=null ) {
					StringBuilder packges = new StringBuilder("(");
					if(box.isBubbles()) {
						packges.append("bubbles, ");
					}
					if(box.isFoamsheet()) {
						packges.append("foamsheet, ");
					}
					if(box.isFoam()) {
						packges.append("foam, ");
					}
					if(box.isDoubleBox()) {
						packges.append("doublebox, ");
					}
					
					if(box.isCardBoardpkg()) {
						packges.append("cardBoardpkg, ");
					}
					if(box.isPenuts()) {
						packges.append("penuts,");
					}
					if(box.getOthers() !=null) {
						packges.append(box.getOthers()+", ");
					}
					packges.append(")");
					pd.setPackages(packges.toString());
				}
				
				packagingDetailsList.add(pd);
			});
			auction.setPackagingDetailsList(packagingDetailsList);
			auction.setLotDetailsList(lotDetailsList);
			auction.setIsActive(true);
			auctionList.add(auction);
			customerDetails.get().setAuctionList(auctionList);
			Auction dbAuction = auctionRepository.save(auction);
			auctionDetailsResponse.setAuctionId(dbAuction.getId());
		}
		return auctionDetailsResponse;

	}

}
