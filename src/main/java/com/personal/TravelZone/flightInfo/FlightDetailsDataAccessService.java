package com.personal.TravelZone.flightInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
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

}
