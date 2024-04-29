package com.personal.TravelZone.flightInfo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal.TravelZone.flightInfo.FlightInformation;
import com.personal.TravelZone.flightInfo.recorder.FlightAvalibilityRecorder;
import com.personal.TravelZone.flightInfo.recorder.FlightDestinationRecorder;
import com.personal.TravelZone.flightInfo.recorder.FlightSourceRecorder;
import com.personal.TravelZone.flightInfo.response.ObjectResponse;
import com.personal.TravelZone.flightInfo.service.FlightInfoService;
@RestController
@CrossOrigin
@RequestMapping("api/v1/flights")
public class FlightInformationController {
	public final FlightInfoService  flightInfoService;
	

	public FlightInformationController(FlightInfoService  flightInfoService) {
		this.flightInfoService= flightInfoService;
	}
	@GetMapping("/source")
	public ResponseEntity<List<FlightSourceRecorder>> getAllSourceLocation(){
		List<FlightSourceRecorder> flightSource=flightInfoService.getSouceLocationDetails();
		return new ResponseEntity<>(flightSource,HttpStatus.OK);
	}
	@GetMapping("/destination")
	public ResponseEntity<List<FlightDestinationRecorder>> getAllDestinationLocation(){
		List<FlightDestinationRecorder> locationDestination= flightInfoService.getDestinationDetails();
		return new ResponseEntity<>(locationDestination,HttpStatus.OK);
	}
@GetMapping("/search-flight")
public ResponseEntity<ObjectResponse> getAllOnwardFlights(
		@RequestParam String source,
		@RequestParam String destination,
		@RequestParam String departureDate
		)
{
	ObjectResponse resp= new ObjectResponse();
	List<FlightInformation> oneWayFlights= flightInfoService.getOnewardsFlight(source, destination, departureDate);
	if(oneWayFlights.isEmpty()) {
		resp.setMessage("No Flights available !!");
		
		
		return new ResponseEntity<ObjectResponse>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	try {
		
		resp.setResponseData(oneWayFlights);
		resp.setStatusCode(HttpStatus.OK);
		resp.setMessageType("SUCCESS");
		
	} catch (Exception e) {
		resp.setResponseData(HttpStatus.BAD_REQUEST);
		resp.setMessage("Something went wrong in Server");
		resp.setMessageType("ERROR");
		e.printStackTrace();
		// TODO: handle exception
	}
	
	
	
	return new ResponseEntity<ObjectResponse>(resp,resp.getStatusCode()) ;
}
	

}
