package com.personal.TravelZone.TicketBooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal.TravelZone.passengerInfo.PassengerInformation;
import com.personal.TravelZone.responsePayload.ResponseMessage;

@RestController
@CrossOrigin
@RequestMapping("api/v1/flights/booking")
public class TicketBookingController {
public final TicketBookingService ticketBookingService;


public TicketBookingController(TicketBookingService ticketBookingService) {
	this.ticketBookingService = ticketBookingService;

}
@PostMapping(path = "/flight-booking")
public ResponseEntity<String>flightTicketBooking(@RequestParam Integer flightId,
		@RequestParam Integer userId,
		@RequestBody List<PassengerInformation> passengerInfo
		){
	ResponseEntity<String>  bookingResponse= ticketBookingService.flightBooking(flightId,
			userId,
			passengerInfo);
	 
	return bookingResponse;
	
}
}
