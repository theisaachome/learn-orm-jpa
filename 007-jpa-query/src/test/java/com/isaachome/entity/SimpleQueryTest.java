package com.isaachome.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleQueryTest extends AbstractQueryTest {

	@Test
	void test_select_count_query() {
		var query = em.createQuery("""
				 SELECT COUNT(cat) FROM Category cat
				""",Long.class);
		var totalCount = query.getSingleResult();
		assertEquals(8, totalCount);
	}
	
	@Test
	void test_select_all_query() {
		var query = em.createQuery("""
				SELECT c FROM  Category c
				""",Category.class);
		var stream = query.getResultStream();
		stream.forEach(c->System.out.println(c.getName()));
	}
	@Test
	void test_update_query() {
		em.getTransaction().begin();
		var query = em.createQuery("""
				update Category c SET c.name = :name WHERE c.id = :id
				""");
        query.setParameter("name", "Men Clothes");
        query.setParameter("id", 1);
        
        var count = query.executeUpdate();
        
		em.getTransaction().commit();
		assertEquals(1, count);
		
	}

}
