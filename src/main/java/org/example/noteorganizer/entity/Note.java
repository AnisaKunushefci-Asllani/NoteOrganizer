package org.example.noteorganizer.entity;

import java.io.Serializable;

public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String content;
    private String tags;
    private User user;

    public Note() {}

    public Note(Long id, String title, String content, String tags, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.user = user;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
