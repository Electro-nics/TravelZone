package com.personal.TravelZone.UserInfo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.personal.TravelZone.exceptions.DuplicateResourceException;
@Service
public class UserInformationService {
	public final UserInformationDAO userInformationDAO;

	public UserInformationService(@Qualifier("jpa") UserInformationDAO userInformationDAO) {
		this.userInformationDAO = userInformationDAO;
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
						userRegistrationDetails.password(),
						userRegistrationDetails.email(),
						userRegistrationDetails.phone())
				
				);
		
		
	}
	
	

}
