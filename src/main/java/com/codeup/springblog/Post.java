package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Column (nullable = false, length = 100)
    private String title;

    @Column (nullable = false)
    private String body;

    public Post(){}

    public Post(String title, String body, User author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }


    public Post(String title, String body, Long id){
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
