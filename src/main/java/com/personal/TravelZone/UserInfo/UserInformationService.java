package com.personal.TravelZone.UserInfo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.personal.TravelZone.exceptions.DuplicateResourceException;
@Service
public class UserInformationService {
	public final UserInformationDAO userInformationDAO;
	public final PasswordEncoder passwordEncoder;

	public UserInformationService(@Qualifier("jpa") UserInformationDAO userInformationDAO, PasswordEncoder passwordEncoder) {
		this.userInformationDAO = userInformationDAO;
		this.passwordEncoder=passwordEncoder;
	}
	public void userRegistration(UserRegistrationDetails userRegistrationDetails) {
		String email=userRegistrationDetails.email();
		String phone=userRegistrationDetails.phone();
		
		if(userInformationDAO.UserWithDuplicateEmail(email)) {
			throw new DuplicateResourceException("Email Already in Use");
		}
		if(userInformationDAO.userWithDuplicatePhoneNumber(phone)) {
			throw new DuplicateResourceException("Phone Number Already in use");
		}
		
		userInformationDAO.userInformationRegistration(
				new UserInformation(userRegistrationDetails.userAddress(),
						userRegistrationDetails.userName(),
						this.passwordEncoder.encode(userRegistrationDetails.password()),
						userRegistrationDetails.email(),
						userRegistrationDetails.phone())
				
				);
		
		
	}
	
	

}
