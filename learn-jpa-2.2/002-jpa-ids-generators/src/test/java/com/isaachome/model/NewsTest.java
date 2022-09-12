package com.isaachome.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NewsTest extends AbstractPersistenceTest {

	@Test
	void shouldCreateANews() throws Exception {
		News news = new News(new NewsId("Richard Wright has died", "EN"), "The keyboard of Pink Floyd has died today");
		tx.begin();
		em.persist(news);
		tx.commit();
		
		news = em.find(News.class, new NewsId("Richard Wright has died", "EN"));

	    assertEquals("The keyboard of Pink Floyd has died today", news.getContent());
	}

}
