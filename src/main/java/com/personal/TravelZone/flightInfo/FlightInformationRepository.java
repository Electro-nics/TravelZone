package com.personal.TravelZone.flightInfo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface FlightInformationRepository extends JpaRepository<FlightInformation, Integer> {
	@Query("SELECT DISTINCT source from FlightInformation")
	List<String> findAllDistinctSource();
	@Query("SELECT DISTINCT destination from FlightInformation")
	List<String> findAllDistinctDestination();
	

}
