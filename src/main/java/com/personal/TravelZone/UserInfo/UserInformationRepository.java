package com.personal.TravelZone.UserInfo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {
@Query
boolean existsUserByEmail(String email);
boolean existsUserByPhone(String phone);
Optional<UserInformation> findUserByEmailAndPassword(String email, String password);
UserInformation findUserByEmail(String email);
}
