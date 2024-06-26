package com.personal.TravelZone.passengerInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PassengerInformationRepository extends JpaRepository<PassengerInformation, Integer>{

}
