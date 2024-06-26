package com.personal.TravelZone.passengerInfo;

import java.util.Objects;

import com.personal.TravelZone.TicketBooking.TicketBooking;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "PassengerInformation")
public class PassengerInformation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "passenger_id")
	private Integer id;
	private String name;
	private String age;
	private String  email;
	private String gender;
	@Column(name = "pnr_details")
	private String pnrDetails;
	@ManyToOne
	@JoinColumn(name = "booking_id")
	 private TicketBooking ticketBooking;
	public PassengerInformation() {}
	public PassengerInformation( String name, String age,
			String email, String gender, String pnrDetails) {
		
		this.name = name;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.pnrDetails = pnrDetails;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPnrDetails() {
		return pnrDetails;
	}
	public void setPnrDetails(String pnrDetails) {
		this.pnrDetails = pnrDetails;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, email, gender, id, name, pnrDetails);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerInformation other = (PassengerInformation) obj;
		return Objects.equals(age, other.age) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(pnrDetails, other.pnrDetails);
	}
	@Override
	public String toString() {
		return "PassengerInformation [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", gender="
				+ gender + ", pnrDetails=" + pnrDetails + "]";
	}
	

}
