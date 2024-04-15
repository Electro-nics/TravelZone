package com.personal.TravelZone.UserInfo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.personal.TravelZone.UserInfo.responsePayload.LoginMessage;

@Qualifier("jpa")
@Repository
public class UserInformationDataAccessService implements UserInformationDAO{

	public final UserInformationRepository informationRepository;
	
	public UserInformationDataAccessService(UserInformationRepository informationRepository) {
		this.informationRepository=informationRepository;
		
	}
	@Override
	public void userInformationRegistration(UserInformation userInformation) {
		informationRepository.save(userInformation);
		// TODO Auto-generated method stub
		
	}
	@Override
	public Boolean UserWithDuplicateEmail(String email) {
		
		return informationRepository.existsUserByEmail(email);
	}
	@Override
	public Boolean userWithDuplicatePhoneNumber(String phone) {

		return informationRepository.existsUserByPhone(phone);
	}
	@Override
	public Optional<UserInformation> findUserByEmailandPassword(String email, String password) {
		// TODO Auto-generated method stub
		return informationRepository.findUserByEmailAndPassword(email, password);
	}
	@Override
	public UserInformation findUserByEmail(String Email) {
		// TODO Auto-generated method stub
		return informationRepository.findUserByEmail(Email);
	}
	@Override
	public LoginMessage userLogin(LoginMessage loginMessage) {
		return new LoginMessage(loginMessage.getMessage(), loginMessage.isStatus());
		// TODO Auto-generated method stub
		
	}

	

}
