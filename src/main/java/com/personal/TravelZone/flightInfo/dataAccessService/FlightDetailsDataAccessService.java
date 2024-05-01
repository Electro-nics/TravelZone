package com.personal.TravelZone.flightInfo.dataAccessService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.personal.TravelZone.flightInfo.FlightInformation;
import com.personal.TravelZone.flightInfo.dataAccessObject.FlightInfoDAO;
import com.personal.TravelZone.flightInfo.repository.FlightInformationRepository;
@Qualifier("jpa")
@Repository
public class FlightDetailsDataAccessService implements FlightInfoDAO {
public final FlightInformationRepository flightInformationRepository;

	public FlightDetailsDataAccessService(FlightInformationRepository flightInformationRepository) {
	this.flightInformationRepository = flightInformationRepository;
}

	@Override
	public List<String> getAllSourceLocation() {
		
		return flightInformationRepository.findAllDistinctSource();
	}

	@Override
	public List<String> getAllDestinationLocation() {
		// TODO Auto-generated method stub
		return flightInformationRepository.findAllDistinctDestination();
	}



	@Override
	public List<FlightInformation> getAllFlightsData() {
		// TODO Auto-generated method stub
		return flightInformationRepository.findAll();  
	}

	@Override
	public Optional<FlightInformation> flightByDate(String source, String destination, String journeydate) {
		
		return flightInformationRepository.findBySourceAndDestinationAndDepurtureDate(source, destination, journeydate);
	}

}
