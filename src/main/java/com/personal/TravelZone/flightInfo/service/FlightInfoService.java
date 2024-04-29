package com.personal.TravelZone.flightInfo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.personal.TravelZone.flightInfo.FlightInformation;
import com.personal.TravelZone.flightInfo.dataAccessObject.FlightInfoDAO;
import com.personal.TravelZone.flightInfo.recorder.FlightAvalibilityRecorder;
import com.personal.TravelZone.flightInfo.recorder.FlightDestinationRecorder;
import com.personal.TravelZone.flightInfo.recorder.FlightSourceRecorder;
@Service
public class FlightInfoService {
public final FlightInfoDAO flightInfoDAO;
//public final FlightInformationRecorder avalibilityRecorder;
//private FlightInformation flightInformation;
	
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

public List<FlightInformation> getOnewardsFlight(String source, String Destination, String Date) {
	// TODO Auto-generated method stub
	List<FlightInformation> flightData=flightInfoDAO.flightByDate(source, Destination, Date);
	return flightData;
}
}
