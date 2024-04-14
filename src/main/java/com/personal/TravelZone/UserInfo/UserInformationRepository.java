package com.personal.TravelZone.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {
@Query
boolean existsUserByEmail(String email);
boolean existsUserByPhone(String phone);
}
