package com.isaachome.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.model.Manufacturer;

public interface ManufacturerRepo extends JpaRepository<Manufacturer,Integer> {
	
}
