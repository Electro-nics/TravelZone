package com.personal.TravelZone.flightInfo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personal.TravelZone.flightInfo.FlightInformation;

@Repository
@EnableJpaRepositories
public interface FlightInformationRepository extends JpaRepository<FlightInformation, Integer> {
	@Query("SELECT DISTINCT source from FlightInformation")
	List<String> findAllDistinctSource();
	@Query("SELECT DISTINCT destination from FlightInformation")
	List<String> findAllDistinctDestination();
	
	List<FlightInformation>findBySourceAndDestinationAndDepurtureDate(String source, String destination, String journeyDate);

	
	

}
