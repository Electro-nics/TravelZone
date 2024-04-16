package com.personal.TravelZone.flightInfo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class FlightInfoService {
public final FlightInfoDAO flightInfoDAO;
	
public FlightInfoService(@Qualifier("jpa") FlightInfoDAO flightInfoDAO) {
	this.flightInfoDAO = flightInfoDAO;
}




public List<FlightSourceRecorder> getSouceLocationDetails(){
	List<String> sourceLocation= flightInfoDAO.getAllSourceLocation();
	
	
	return sourceLocation.stream().
			map(s-> new FlightSourceRecorder(s)).
			collect(Collectors.toList());
	
}
public List<FlightDestinationRecorder> getDestinationDetails(){
	List<String> locationDestination= flightInfoDAO.getAllDestinationLocation();
	return locationDestination.stream()
			.map(d-> new FlightDestinationRecorder(d))
			.collect(Collectors.toList());
}
}
