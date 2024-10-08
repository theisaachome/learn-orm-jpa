package com.highway.sms.learnspringdatajpa.repo;

import com.highway.sms.learnspringdatajpa.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepo extends JpaRepository<Location, Long> {
    Location findFirstByState(String stateName);
    Optional<Location> findByStateLike(String stateName);
}
