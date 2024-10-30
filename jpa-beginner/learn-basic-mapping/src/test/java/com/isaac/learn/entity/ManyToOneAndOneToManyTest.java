package com.isaac.learn.entity;

import com.isaac.learn.onetomany.Author;
import com.isaac.learn.onetomany.Book;
import com.isaac.learn.onetomany.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ManyToOneAndOneToManyTest {

    static EntityManagerFactory entityManagerFactory ;

    @BeforeAll
    static  void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }
    @AfterAll
    static void close(){
        if(entityManagerFactory != null && entityManagerFactory.isOpen()){
            entityManagerFactory.close();
        }
    }



    @Test
    void manageBidirectionalBookAndCommentOneToManyAssociation(){
        var em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        // get  the primary key of Author and Book
        Long commentId = createCommentForBook();
        Long bookId = createBook();

        // load Book and Author entities by primary key
        var book = em.find(Book.class, bookId);
        var comment = em.find(Comment.class, commentId);

        // add the association
        comment.setBook(book);
        book.getComments().add(comment);
        em.getTransaction().commit();

    }


    @Test
    void manageBidirectionalAuthorAndBookOneToManyAssociationII(){
        var em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        // get  the primary key of Author and Book
        Long authorId = createAuthor();
        Long bookId = createBook();

        // load Book and Author entities by primary key
        var book = em.find(Book.class, bookId);
        var author = em.find(Author.class, authorId);

        // add the association
        author.getBooks().add(book);
        book.setAuthor(author);
        em.getTransaction().commit();

    }
    @Test
    void queryOneToManyAssociation(){

        Long authorId = prepareTestData();
        var em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        var author = em.find(Author.class, authorId);
        for(var book : author.getBooks()){
            System.out.println(book.getTitle());
        }
        em.getTransaction().commit();

    }

    private Long prepareTestData(){
        var em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Long authorId = createAuthor();
        Long bookId = createBook();
        var book = em.find(Book.class, bookId);
        var author = em.find(Author.class, authorId);
        author.getBooks().add(book);
        book.setAuthor(author);
        em.getTransaction().commit();
        return authorId;
    }

    private Long createBook() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        var book = new Book();
        book.setTitle("Spring Data JPA");
        em.persist(book);

        em.getTransaction().commit();
        em.close();
        return book.getId();
    }

    private Long createAuthor() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        var author = new Author();
        author.setName("John Doe");
        em.persist(author);
        em.getTransaction().commit();
        em.close();
        return author.getId();
    }
    private Long createCommentForBook() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        var comment = new Comment();
        comment.setContent("Very Good Book");
        em.persist(comment);
        em.getTransaction().commit();
        em.close();
        return comment.getId();
    }
}
