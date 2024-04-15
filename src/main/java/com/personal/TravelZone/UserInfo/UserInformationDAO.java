package com.personal.TravelZone.UserInfo;

import java.util.Optional;

import com.personal.TravelZone.UserInfo.responsePayload.LoginMessage;

public interface UserInformationDAO {
	
public void userInformationRegistration(UserInformation userInformation);
public Boolean UserWithDuplicateEmail(String email);
public Boolean userWithDuplicatePhoneNumber(String phone);
public Optional<UserInformation>findUserByEmailandPassword (String email, String password);
public UserInformation findUserByEmail(String Email);
public LoginMessage userLogin(LoginMessage loginMessage);
}
