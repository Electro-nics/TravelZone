package com.personal.TravelZone.UserInfo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/travelZoneUser")
public class UserInformationController {
	public final UserInformationService userInformationService;
	
public UserInformationController(UserInformationService userInformationService) {
		this.userInformationService = userInformationService;
	}
@PostMapping
public void userRegistration(@RequestBody UserRegistrationDetails userRegistrationDetails) {
	userInformationService.userRegistration(userRegistrationDetails);
}
}
