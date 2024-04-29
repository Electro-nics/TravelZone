package com.personal.TravelZone.flightInfo;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table(name = "FlightInformation",schema = "Public")
public class FlightInformation {
	@Id
	@SequenceGenerator(name="flight_id_sequence",
	sequenceName = "flight_id_sequence"
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator="flight_id_sequence"
			)
	@Column(name = "id")
	private Integer id;
	@Column(name = "flightId")
	private String flightId;
	@Column(name = "airlineName")
	private String airlineName;
	@Column(name = "ETA")
	private String ETA;
	@Column(name = "EDT")
	private String EDT;
	@Column(name = "Fare")
	private float fare;
	@Column(name = "SeatCount")
	private long seatCount;
	@Column(name = "source")
	private String source;
	@Column(name = "destination")
	private String destination;
//	@Temporal(TemporalType.DATE)
	@Column(name = "depurtureDate")
	private String depurtureDate;
	public FlightInformation() {
		
	}
	public FlightInformation(String flightId, String airlineName, String eTA, String eDT, float fare, long seatCount,
			String source, String destination, String depurtureDate) {
		this.flightId = flightId;
		this.airlineName = airlineName;
		this.ETA = eTA;
		this.EDT = eDT;
		this.fare = fare;
		this.seatCount = seatCount;
		this.source = source;
		this.destination = destination;
		this.depurtureDate= depurtureDate;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getETA() {
		return ETA;
	}
	public void setETA(String eTA) {
		ETA = eTA;
	}
	public String getEDT() {
		return EDT;
	}
	public void setEDT(String eDT) {
		EDT = eDT;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	public long getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(long seatCount) {
		this.seatCount = seatCount;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String depurtureDate() {
		return depurtureDate;
	}
	public void setFlightAvalivilityDate(String depurtureDate) {
		this.depurtureDate = depurtureDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(EDT, ETA, airlineName, destination, fare, depurtureDate, flightId, seatCount,
				source);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightInformation other = (FlightInformation) obj;
		return Objects.equals(EDT, other.EDT) && Objects.equals(ETA, other.ETA)
				&& Objects.equals(airlineName, other.airlineName) && Objects.equals(destination, other.destination)
				&& Float.floatToIntBits(fare) == Float.floatToIntBits(other.fare)
				&& Objects.equals(depurtureDate, other.depurtureDate)
				&& Objects.equals(flightId, other.flightId) && seatCount == other.seatCount
				&& Objects.equals(source, other.source);
	}
	@Override
	public String toString() {
		return "FlightInformation [flightId=" + flightId + ", airlineName=" + airlineName + ", ETA=" + ETA + ", EDT="
				+ EDT + ", fare=" + fare + ", seatCount=" + seatCount + ", source=" + source + ", destination="
				+ destination + ", flightAvalivilityDate=" + depurtureDate + "]";
	}
	
	
	
}
