package com.bookstore.entity.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Review;

class BookStoreTest {

	static EntityManagerFactory emf;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("bookstore-jpa");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@Test
	void test_new_review() {

		// Add a new Review
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Book book = em.find(Book.class, 1);
		Review review = new Review();
		review.setComment("Very good book");
		review.setBook(book);
		
		book.getReviews().add(review);
		em.persist(review);
		em.getTransaction().commit();
		em.close();
		assertEquals("Very good book", review.getComment());
		
	}
	
	@Test
	void test_fetch_with_book_review() {

		// Get Book entity with Reviews
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var book = em.find(Book.class, 1);
		
		var reviews = book.getReviews();
		assertEquals(book, reviews.get(0).getBook());
		

		em.getTransaction().commit();
		em.close();
	}

}



