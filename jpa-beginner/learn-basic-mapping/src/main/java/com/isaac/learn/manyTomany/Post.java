package com.isaac.learn.manyTomany;
import com.isaac.learn.onetomany.Comment;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "posts")
    private Set<Tag> tags = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "post_comment",
        joinColumns = @JoinColumn(name = "post_id"),
        inverseJoinColumns = @JoinColumn(name = "comment_id")
    )
    private Set<Comment> comments = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }


    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
        tag.getPosts().add(this);
    }
    public void removeTag(Tag tag) {
        this.tags.remove(tag);
        tag.getPosts().remove(this);
    }
}
