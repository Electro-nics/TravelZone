package com.personal.TravelZone;

import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.personal.TravelZone.UserInfo.UserInformation;
import com.personal.TravelZone.UserInfo.UserInformationRepository;
import com.personal.TravelZone.flightInfo.FlightInformation;
import com.personal.TravelZone.flightInfo.FlightInformationRepository;
import com.personal.TravelZone.passengerInfo.PassengerInformation;
import com.personal.TravelZone.passengerInfo.PassengerInformationRepository;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TravelZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelZoneApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(FlightInformationRepository flightInformationRepository,
			PassengerInformationRepository passengerRepository,
			UserInformationRepository userinformationRepository) {
		Faker fake=new Faker();
		Random rand=new Random();
		String airLine=fake.aviation().aircraft();
		Integer randomNumber= (rand.nextInt(1000,9999));
		String flightNumber=airLine.substring(0, 2).toUpperCase()+randomNumber.toString();
		int hours=fake.number().numberBetween(0, 23);
		int min= fake.number().numberBetween(0, 59);
		String ETD=String.format("%02d", hours)+String.format("%02d", min);
		String ETA=String.format("%02d", hours)+String.format("%02d", min);
		int fare= fake.number().numberBetween(1000, 9999);
		String gender="Male";
		int age=rand.nextInt(20, 60);
		
		return args->{

			
			FlightInformation flightInfo= new FlightInformation(flightNumber,
					airLine,
					ETD,
					ETA,
					fare,
					age,
					fake.address().city(),
					fake.address().city());
			List<FlightInformation> flightdetails=List.of(flightInfo);
			flightInformationRepository.saveAll(flightdetails);
			
			String name= fake.name().fullName();
			
			String email=fake.internet().emailAddress();
			String pnr=name.subSequence(0, 2).toString().toUpperCase()
					+flightInfo.getFlightId().subSequence(0, 2).toString().toUpperCase()
					+flightInfo.getSource().subSequence(0, 1).toString().toUpperCase()
					+flightInfo.getDestination().substring(0, 1).toUpperCase();
			
			PassengerInformation passengerInformation= new PassengerInformation(name,
					Integer.toString(age),
					email,
					gender,
					pnr);
			List<PassengerInformation> passengerInfo=List.of(passengerInformation);
			passengerRepository.saveAll(passengerInfo);
			UserInformation user= new UserInformation(fake.address().city(),
					name+String.valueOf(age),
					"ytui",
					email,
					fake.phoneNumber().phoneNumber());
			List<UserInformation> userinfo=List.of(user);
			userinformationRepository.saveAll(userinfo);
			
			
			
			
		};
	}

}
