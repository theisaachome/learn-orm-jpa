package com.isaachome.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isaachome.repo.ManufacturerRepo;

@SpringBootTest
class ManufacturerTest {

	@Autowired
	private ManufacturerRepo manufacturerRepo;

	@Test
	void testGetManufacturersFoundedBeforeDate() {
		List<Manufacturer> menafuList = manufacturerRepo.findByFoundedDateBefore(new Date());
		assertEquals(2, menafuList.size());
	}

	@Test
	void testGetManufacturerByName() {
		Manufacturer manu = manufacturerRepo.findByName("Fender Musical Instruments Corporation");
		assertEquals("Fender Musical Instruments Corporation", manu.getName());
	}

	@Test
	void testGetManufacturerByActiveTrue() {
		List<Manufacturer> mans = manufacturerRepo.findByActiveTrue();
		assertNotNull(mans);
		assertEquals("Fender Musical Instruments Corporation", mans.get(0).getName());
	}
	@Test
	void testGetManufactuereByActiveFalse() {
		List<Manufacturer> mans = manufacturerRepo.findByActiveFalse();
		assertNotNull(mans);
		assertEquals(1, mans.size());
	}
	@Test
	void testGetAllThatSellModelOfType() {
		List<Manufacturer> mans = manufacturerRepo.getAllThatSellModelOfType("Electric");
		assertNotNull(mans);
	}
}
