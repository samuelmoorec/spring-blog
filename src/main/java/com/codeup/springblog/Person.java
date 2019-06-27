package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class Person {
    @Id @GeneratedValue
    private Long id;

    @Column (nullable = false, length = 100)
    private String title;

    @Column (nullable = false)
    private String body;

    public Person(String title, String body) {
        this.title = title;
        this.body = body;
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
