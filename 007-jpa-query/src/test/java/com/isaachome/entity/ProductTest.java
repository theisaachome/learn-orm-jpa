package com.isaachome.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProductTest extends AbstractQueryTest{

	@ParameterizedTest
	@CsvSource({
		"b,12",
		"c,25",
	})
	void test_find_by_category_name_like(String name,int count) {
		 var query = em.createNamedQuery("Product.findByCategoryNameLike",Product.class);
		 query.setParameter("name", name.toLowerCase().concat("%"));
		 var list = query.getResultList();
		 var stream = query.getResultStream();
		 stream.forEach(p->{
			 System.out.println(p.getName() +" : "+p.getCategory().getName());
		 });
		 assertEquals(count, list.size());
	}

}
