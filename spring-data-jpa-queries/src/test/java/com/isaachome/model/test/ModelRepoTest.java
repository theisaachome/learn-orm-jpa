package com.isaachome.model.test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

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

}
