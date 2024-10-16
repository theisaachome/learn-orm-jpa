package com.highway.sms.learnspringdatajpa.repo;

import com.highway.sms.learnspringdatajpa.oneToOne.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
