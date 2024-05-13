package com.personal.TravelZone.TicketBooking;

import java.util.List;
import java.util.Objects;

import com.personal.TravelZone.flightInfo.FlightInformation;
import com.personal.TravelZone.passengerInfo.PassengerInformation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "TicketBooking", schema = "public")
public class TicketBooking {
	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Integer id;
	private String pnr;
	private String bookinDate;
	private String journeyDate;
	private String journeyTime;
	private Integer noOfSeats;
	private float totalFare;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private FlightInformation flightInformation;
	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "pnr_details")
	private List<PassengerInformation> passengers;
	
	public TicketBooking() {
	}

	public TicketBooking(String pnr, String bookinDate, String journeyDate,
			String journeyTime,
			Integer noOfSeats,
			float totalFare
			) {
		this.pnr = pnr;
		this.bookinDate = bookinDate;
		this.journeyDate = journeyDate;
		this.journeyTime = journeyTime;
		this.noOfSeats = noOfSeats;
		this.totalFare = totalFare;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookinDate, flightInformation, journeyDate, journeyTime, noOfSeats, passengers, pnr,
				totalFare);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketBooking other = (TicketBooking) obj;
		return Objects.equals(bookinDate, other.bookinDate)
				&& Objects.equals(flightInformation, other.flightInformation)
				&& Objects.equals(journeyDate, other.journeyDate) && Objects.equals(journeyTime, other.journeyTime)
				&& Objects.equals(noOfSeats, other.noOfSeats) && Objects.equals(passengers, other.passengers)
				&& Objects.equals(pnr, other.pnr)
				&& Float.floatToIntBits(totalFare) == Float.floatToIntBits(other.totalFare);
	}

	@Override
	public String toString() {
		return "TicketBooking [pnr=" + pnr + ", bookinDate=" + bookinDate + ", journeyDate=" + journeyDate
				+ ", journeyTime=" + journeyTime + ", noOfSeats=" + noOfSeats + ", totalFare=" + totalFare
				+ ", flightInformation=" + flightInformation + ", passengers=" + passengers + "]";
	}
	
	
	
	

}
