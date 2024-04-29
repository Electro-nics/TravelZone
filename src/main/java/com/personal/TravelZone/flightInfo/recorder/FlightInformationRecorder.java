package com.personal.TravelZone.flightInfo.recorder;

import java.util.Date;

public record FlightInformationRecorder(String flightId,
		String airlineName,
		String eTA,
		String eDT,
		float fare,
		long seatCount,
		String source,
		String destination,
		Date flightAvalivilityDate) {

}
