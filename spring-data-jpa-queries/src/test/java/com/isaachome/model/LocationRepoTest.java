package com.isaachome.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isaachome.repo.LocationRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
class LocationRepoTest {

	
	@Autowired
	private LocationRepository locationRepository;
	
	
	@Test
	void  test_find_all_locations() {
		List<Location> locations = locationRepository.findAll();
		assertNotNull(locations);
	}
	
	
	@Test
	@Transactional
	void testSaveAndGetAndDelete() {
		// create new location
		var location = new Location();
		location.setCountry("Canada");
		location.setState("British Columbia");
		location = locationRepository.saveAndFlush(location);
		
		// get location by ID
		var otherLocation = locationRepository.findById(location.getId()).get();
		assertEquals("Canada", otherLocation.getCountry());
		assertEquals("British Columbia", otherLocation.getState());
		
		log.info(otherLocation.getCountry());
		locationRepository.delete(otherLocation);
		
	}
	
	@Test
	void testFindWithLike() {
		// get State  Name like
		var locs = locationRepository.findByStateLike("N%");
		assertEquals(8, locs.size());
	}

	@Test
	void testFindByStateNotLike() {

		// get all States Name not like
		List<Location> otherLocs = locationRepository.findByStateNotLike("new%");
		assertEquals(46, otherLocs.size());
		
//		otherLocs.forEach((l)->{
//			log.info(l.getState());
//		});
	}
	
	@Test
	void testFindByStateStartingWith() {
		List<Location> locs = locationRepository.findByStateIgnoreCaseStartingWith("new");
		assertEquals(4, locs.size());
	}
	
	@Test
	void testFindByStateEndingWith() {
		List<Location> locs = locationRepository.findByStateIgnoreCaseEndingWith("a");
		assertEquals(21, locs.size());
	}
	
	@Test
	void testFindByStateContaining() {
		List<Location> locs = locationRepository.findByStateContaining("in");
		assertEquals(11, locs.size());
 	}
	@Test
	void testFindByStateOrCountry() {
		List<Location> locs = locationRepository.findByStateOrCountry("Utah","Utah");
		assertEquals("Utah", locs.get(0).getState());
	}
	
	@Test
	void testFindByStateAndCountry() {
		var location = locationRepository.findByStateAndCountry("Nevada", "United States");
		assertEquals("Nevada", location.getState());
	}
	
	@Test
	void testFindByStateNot() {
		List<Location> location = locationRepository.findByStateNot("CA");
		assertNotEquals(49, location.size());
	}
	
	@Test
	void testFindByStateIsOr() {
		List<Location> locations = locationRepository.findByStateIsOrCountryEquals("Zurih", "United States");
		assertEquals("United States", locations.get(0).getCountry());
	}
	@Test
	void testFindByStateIs() {
		var location = locationRepository.findByStateIgnoreCaseIs("california");
		assertEquals("California", location.getState());
	}

}
