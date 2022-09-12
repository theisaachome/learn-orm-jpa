package com.isaachome.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.isaachome.repo.ModelTypeRepo;

@SpringBootTest
class ModelTypeTest {

	@Autowired
	private ModelTypeRepo modelTypeRepo;
	
	@Test
	void testFindByName() {
		ModelType mt = modelTypeRepo.findByName("Electric");
		assertEquals("Electric", mt.getName());
	}
	
	@Test
	void testFindByNameIsNull() {
		List<ModelType> mts= modelTypeRepo.findByNameIsNull();
		assertNotNull(mts);
	}
	@Test
	void testFindByNameIsNotNull() {
		List<ModelType> mts = modelTypeRepo.findByNameIsNotNull();
		assertNotNull(mts);
		mts.forEach(mt->System.out.println(mt.getName()));
	}

}
