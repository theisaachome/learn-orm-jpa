package com.isaachome.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
