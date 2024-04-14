package com.personal.TravelZone.UserInfo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
	

}
