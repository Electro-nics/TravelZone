package com.personal.TravelZone.UserInfo;

public interface UserInformationDAO {
	
public void userInformationRegistration(UserInformation userInformation);
public Boolean UserWithDuplicateEmail(String email);
public Boolean userWithDuplicatePhoneNumber(String phone);
}
