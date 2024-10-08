package com.isaachome.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isaachome.repo.ModelRepo;

@SpringBootTest
class ModelRepoTest {

	@Autowired
	private ModelRepo modelRepo;
	
	@Test
	void testFindModelPriceInRange() {
		var models =modelRepo.findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal.valueOf(800), BigDecimal.valueOf(1000));
		System.out.println("Find Model : "+models.size());
		assertNotNull(models);
	}
	
	@Test
	void testGetModelByType() {
		List<Model> models = modelRepo.findByModelTypeName("Electric");
		models.forEach(m->System.out.println(m.getName()));
		assertEquals(4, models.size());
	}
	
	@Test
	void testGetModelByModelTypes() {
		List<Model> models = 
				modelRepo.findByModelTypeNameIn(List.of("Electric","Accustic"));
		models.forEach(m->{
			assertTrue(
				m.getModelType().getName().equals("Electric") ||
				m.getModelType().getName().equals("Accustic")
					);
		});
	}
	
	@Test
	void testGetModelsByPriceRangeAndWoodType() {
		List<Model> models =modelRepo.queryByPriceRangeAndWoodTpe(BigDecimal.valueOf(1000L), BigDecimal.valueOf(2000L), "%"+"maple"+"%");
		assertNotNull(models);
		models.forEach(m->System.out.println(m.getName()));
		assertEquals(3, models.size());
	}
	
	@Test
	void testGetModelsByType() {
		List<Model> mods = modelRepo.findAllModelsByType("Electric");
		assertEquals(4, mods.size());
	}
	

}
