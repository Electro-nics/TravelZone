package com.personal.TravelZone.TicketBooking;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.personal.TravelZone.UserInfo.UserInformation;
import com.personal.TravelZone.UserInfo.UserInformationRepository;
import com.personal.TravelZone.flightInfo.FlightInformation;
import com.personal.TravelZone.flightInfo.repository.FlightInformationRepository;
import com.personal.TravelZone.passengerInfo.PassengerInformation;
import com.personal.TravelZone.passengerInfo.PassengerInformationRepository;


@Service
public class TicketBookingService {
	private final FlightInformationRepository flightInformationRepository;
	private final UserInformationRepository userInformationRepository;
	private final PassengerInformationRepository passengerInformationRepository;
	 private final TicketBookingRepository bookingRepository;
	

	public TicketBookingService(
			FlightInformationRepository flightInformationRepository,
			UserInformationRepository userInformationRepository,
			TicketBookingRepository bookingRepository,
			PassengerInformationRepository passengerInformationRepository
			)
	{
		this.flightInformationRepository = flightInformationRepository;
		this.userInformationRepository=userInformationRepository;
		this.passengerInformationRepository= passengerInformationRepository;
		this.bookingRepository=bookingRepository;
	}


	public ResponseEntity<String> flightBooking(Integer flightId, Integer userId, List<PassengerInformation> passengerInfo) {
		FlightInformation flightDetails=flightInformationRepository.findById(flightId).orElseThrow(null);
		// The Id used above is primary key of FlightInformation of Entity class, i,e. id
		if(flightDetails==null) {
			return ResponseEntity.badRequest().body("Invalid Flight Id !!");
		}
		Optional<UserInformation> userinfo= userInformationRepository.findById(userId);
		if(userinfo.isEmpty()) {
			return ResponseEntity.badRequest().body("User not found !!");
		}
		if(flightDetails.getSeatCount()<passengerInfo.size()) {
			return ResponseEntity.badRequest().body("Enough Seat not available !!");
		}
		// calculate ticket price
		float totalPrice = passengerInfo.size()* flightDetails.getFare();
		// Generate PNR Number
		String pnrDetails=gereratePNRNumber();
		String bookingDate= LocalDate.now().toString();
		String journeyDate= flightDetails.depurtureDate();
		String journeyTime= flightDetails.getEDT();
		Integer noOfSeat= passengerInfo.size();
		
		
		// Store Ticket Details
		TicketBooking bookingDeatils= new TicketBooking(
				pnrDetails,
				bookingDate,
				journeyDate,
				journeyTime,
				noOfSeat,
				totalPrice
				);
		bookingRepository.save(bookingDeatils);
//		FlightInformation flightInformation;
		// Store passenger Details
		for(PassengerInformation passengerInformation: passengerInfo) {
			passengerInformation.setPnrDetails(pnrDetails);
			passengerInformationRepository.saveAll(passengerInfo);
		}
			// Update flight seat count

			flightDetails.setSeatCount(flightDetails.getSeatCount()-passengerInfo.size());
			flightInformationRepository.save(flightDetails);
			
			// return PNR number with success message
			return ResponseEntity.ok("Ticket Booked Successfully with PNR number " + pnrDetails);
			

	}
	public String gereratePNRNumber() {
		return "PNR"+UUID.randomUUID().toString().
				substring(0, 4)
				.toUpperCase();
		
	}

}
