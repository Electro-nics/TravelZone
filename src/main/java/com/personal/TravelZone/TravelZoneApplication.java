package com.personal.TravelZone;

import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.personal.TravelZone.flightInfo.FlightInformation;
import com.personal.TravelZone.flightInfo.FlightInformationRepository;
import com.personal.TravelZone.passengerInfo.PassengerInformation;
import com.personal.TravelZone.passengerInfo.PassengerInformationRepository;


@SpringBootApplication
public class TravelZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelZoneApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(FlightInformationRepository flightInformationRepository,PassengerInformationRepository passengerRepository) {
		return args->{
			
			FlightInformation flightInfo= new FlightInformation("AI764",
					"AirIndia",
					"0900",
					"1030",
					5640,
					86,
					"Delhi",
					"Goa");
			List<FlightInformation> flightdetails=List.of(flightInfo);
			flightInformationRepository.saveAll(flightdetails);
			Faker fake=new Faker();
			Random rand=new Random();
			String name= fake.name().fullName();
			String gender ="Male";
			String age=Integer.toString(rand.nextInt(20, 60));
			String email=fake.internet().emailAddress();
			String pnr=name.subSequence(0, 2).toString().toUpperCase()
					+flightInfo.getFlightId().subSequence(0, 2).toString().toUpperCase()
					+flightInfo.getSource().subSequence(0, 1).toString().toUpperCase()
					+flightInfo.getDestination().substring(0, 1).toUpperCase();
			
			PassengerInformation passengerInformation= new PassengerInformation(name,
					age,
					email,
					gender,
					pnr);
			List<PassengerInformation> passengerInfo=List.of(passengerInformation);
			passengerRepository.saveAll(passengerInfo);
			
			
			
			
		};
	}

}
