package com.personal.TravelZone.flightInfo.recorder;

public record FlightAvalibilityRecorder(
		String flightId, String airlineName, String eTA, String eDT, float fare,
		String source, String destination
		) {

}
