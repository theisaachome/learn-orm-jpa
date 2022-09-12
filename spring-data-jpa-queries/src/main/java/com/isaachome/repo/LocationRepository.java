package com.isaachome.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

	List<Location> findByStateOrCountry(String param1,String param2);
	Location findByStateAndCountry(String state,String country);
	
	List<Location> findByStateLike(String state); // params => "new%";
	List<Location> findByStateNotLike(String stateName); // params => "New%";
	
	List<Location> findByStateIgnoreCaseStartingWith(String stateName);
	List<Location> findByStateStartingWith(String stateName); // params => "A";  no more %
	
	List<Location> findByStateIgnoreCaseEndingWith(String stateName);
	
	Location findByStateIgnoreCaseIs(String stateName);
	List<Location> findByStateNot(String string);
	List<Location> findByStateIsOrCountryEquals(String params1,String params2);
	List<Location> findByStateContaining(String param);
}
