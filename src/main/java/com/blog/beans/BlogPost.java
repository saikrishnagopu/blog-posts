package com.blog.beans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogPost {

    private Long id;

    private String name;

    private String content;

    private Long createdAt;

    private boolean isActive;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
