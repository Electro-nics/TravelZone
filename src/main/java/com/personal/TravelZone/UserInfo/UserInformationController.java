package com.personal.TravelZone.UserInfo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.TravelZone.UserInfo.responsePayload.LoginMessage;

@RestController
@CrossOrigin
@RequestMapping("api/v1/travelZoneUser")
public class UserInformationController {
	public final UserInformationService userInformationService;
	
public UserInformationController(UserInformationService userInformationService) {
		this.userInformationService = userInformationService;
	}
@PostMapping(path = "/user-registration")
public void userRegistration(@RequestBody UserRegistrationDetails userRegistrationDetails) {
	userInformationService.userRegistration(userRegistrationDetails);
}
@PostMapping(path = "/user-login")
public ResponseEntity<?> userLogin(@RequestBody UserLoginDetails userLoginDetails){
	
	LoginMessage loginMessage= userInformationService.userLogin(userLoginDetails);
	
	return ResponseEntity.ok(loginMessage);
	
}
}
