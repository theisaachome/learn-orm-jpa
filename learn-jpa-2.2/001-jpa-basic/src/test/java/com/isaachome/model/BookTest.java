package com.isaachome.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class BookTest extends AbstractPersistenceTest {


	@Test
	void shouldCreateABook()  throws Exception{
		  Book book = new Book(getRandomId(), "The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false);
		  tx.begin();
		  em.persist(book);
		  var persistedBook = em.find(Book.class, book.getId());
		  tx.commit();
		  assertNotNull(persistedBook.getId(),"ID should not be null");
	}

}
