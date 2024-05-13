package com.personal.TravelZone.UserInfo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.personal.TravelZone.exceptions.DuplicateResourceException;
import com.personal.TravelZone.responsePayload.LoginMessage;
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
		String username=userRegistrationDetails.userName();
		
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
	public LoginMessage userLogin(UserLoginDetails userLoginDetails) {
		//check if the user exists or not
		UserInformation user=userInformationDAO.findUserByEmail(userLoginDetails.email());
		if(user!=null) {
			String userPassword=userLoginDetails.password();
			String encodedPassword=user.getPassword();
			boolean isvalidPassword=passwordEncoder.matches(userPassword, encodedPassword);
			if(isvalidPassword) {
				Optional<UserInformation> currentUser=userInformationDAO.
						findUserByEmailandPassword(userLoginDetails.email(), encodedPassword);
				if(currentUser.isPresent()) {
					return userInformationDAO.userLogin(new LoginMessage("Login Successfull !", true));
				}
				else {
					return userInformationDAO.userLogin(new LoginMessage("Login falied !", false));
				}
			}else {
				return userInformationDAO.userLogin(new LoginMessage("Wrong Password !! Please check again", false));
			}
		}else {
			return userInformationDAO.userLogin(new LoginMessage("Email does not exits", false));
		}
	}
	
	

}
