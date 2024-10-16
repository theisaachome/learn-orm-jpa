package com.isaachome.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NamedQueryTest extends AbstractQueryTest {

	@Test
	void test_select_count_query() {
		var query = em.createNamedQuery("Category.getCount",Long.class);
		var totalCount = query.getSingleResult();
		assertEquals(8, totalCount);
	}
	
	@Test
	void test_select_all_query() {
		var query = em.createNamedQuery("Category.getAll",Category.class);
		var stream = query.getResultStream();
		stream.forEach(c->System.out.println(c.getName()));
	}
	@Test
	void test_update_query() {
		em.getTransaction().begin();
		var query = em.createNamedQuery("Category.updateNameById");
        query.setParameter("name", "Men Clothes");
        query.setParameter("id", 1);
        var count = query.executeUpdate();
		em.getTransaction().commit();
		assertEquals(1, count);
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"c,2",
		"b,1"
	})
	void test_search_category_by_name_like(String name,int count) {
		var query = em.createNamedQuery("Category.findByNameLike",Category.class);
		query.setParameter(1, name.toLowerCase().concat("%"));
		
		var list= query.getResultList();
		assertEquals(count, list.size());
		
	}

}
