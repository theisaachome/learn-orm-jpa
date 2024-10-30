package com.isaac.learn.manyTomany;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    private Set<Post> posts = new HashSet<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
    public void addPost(Post post) {
        this.posts.add(post);
        post.getTags().add(this);
    }
    public void removePost(Post post) {
        this.posts.remove(post);
        post.getTags().remove(this);
    }
}
