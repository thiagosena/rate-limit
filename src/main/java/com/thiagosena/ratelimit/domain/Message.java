package com.thiagosena.ratelimit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String user;
    private String content;

    public Message(Long id, String user, String content) {
        this.id = id;
        this.user = user;
        this.content = content;
    }

    public Message() {
    }

    public Message(String user, String content) {
        this.user = user;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }
}
