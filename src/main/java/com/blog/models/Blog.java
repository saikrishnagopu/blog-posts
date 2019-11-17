package com.blog.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "blogs")
public class Blog{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private String name;

    private String content;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdOn;

    @Version
    @Column(updatable=true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date lastUpdate;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }

    public Long getId() {
        return id;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreatedOn() {
        return createdOn;
    }
}
