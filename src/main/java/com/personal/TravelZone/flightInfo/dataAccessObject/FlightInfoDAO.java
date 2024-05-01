package com.personal.TravelZone.flightInfo.dataAccessObject;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.personal.TravelZone.flightInfo.FlightInformation;

public interface FlightInfoDAO {
public List<String> getAllSourceLocation();
public List<String>getAllDestinationLocation();
public List<FlightInformation> getAllFlightsData();
public Optional<FlightInformation> flightByDate(String source, String destination, String journeydate);
}
