package com.isaachome.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.model.Manufacturer;

public interface ManufacturerRepo extends JpaRepository<Manufacturer,Integer> {
	
	Manufacturer findByName(String name);
	List<Manufacturer> findByFoundedDateBefore(Date foundedDate);
	List<Manufacturer> findByFoundedDateAfter(Date afterDate);
	List<Manufacturer> findByFoundedDateBetween(Date startDate,Date endDate);
	
	List<Manufacturer> findByActive(Boolean active);
	List<Manufacturer> findByActiveTrue();
	List<Manufacturer> findByActiveFalse();
	
	List<Manufacturer> getAllThatSellModelOfType(String modelType);
}
