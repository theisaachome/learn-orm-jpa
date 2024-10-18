package com.isaac.learn.entity;
import com.isaac.learn.manyTomany.Post;
import com.isaac.learn.manyTomany.Tag;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ManyToManyTest {

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
    void manageManyToMangy(){
      var em = entityManagerFactory.createEntityManager();
      em.getTransaction().begin();
      Long postId1 = createPost("How to get Customer");
      Long postId2 = createPost("Backend Roadmap");
      Long tag1 = createTag("Junior");
      Long tag2 = createTag("Senior");

      // load post
        var post1 = em.find(Post.class, postId1);
        var post2 = em.find(Post.class, postId2);

      // load Tag
        var tagObj1 = em.find(Tag.class,tag1);
        var tagObj2 = em.find(Tag.class,tag2);


        // add the association
        post1.getTags().add(tagObj1);
        tagObj1.getPosts().add(post1);
        post2.getTags().add(tagObj2);
        tagObj2.getPosts().add(post2);
        em.getTransaction().commit();
    }

    private Long createPost(String title){
        var em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        var post = new Post();
        post.setTitle(title);
        em.persist(post);
        em.getTransaction().commit();
        return post.getId();
    }
    private Long createTag(String tag){
        var em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        var tagName = new Tag();
        tagName.setName(tag);
        em.persist(tagName);
        em.getTransaction().commit();
        return tagName.getId();
    }

}
