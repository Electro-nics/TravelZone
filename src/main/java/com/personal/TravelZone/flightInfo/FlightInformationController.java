package com.personal.TravelZone.flightInfo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	

}
