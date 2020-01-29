package com.codeup.springblog;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name = "post_details")
public class PostDetails {
    @Id
    public long id;

    @Column(nullable = false, name = "isAwesome")
    public boolean isAwesome;

    @Column(nullable = false, name = "historyOfPost")
    public String historyOfPost;

    @Column(nullable = false, name = "topicDescription", length = 255)
    public String topicDescription;


    @OneToOne
    @MapsId
    public Post post;

    public PostDetails(){}

    public PostDetails(boolean isAwesome, String historyOfPost, String topicDescription, Post post) {
        this.isAwesome = isAwesome;
        this.historyOfPost = historyOfPost;
        this.topicDescription = topicDescription;
        this.post = post;
    }

    public PostDetails(long id, boolean isAwesome, String historyOfPost, String topicDescription) {
        this.id = id;
        this.isAwesome = isAwesome;
        this.historyOfPost = historyOfPost;
        this.topicDescription = topicDescription;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public void setHistoryOfPost(String historyOfPost) {
        this.historyOfPost = historyOfPost;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public long getId() {
        return id;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public String getHistoryOfPost() {
        return historyOfPost;
    }

    public String getTopicDescription() {
        return topicDescription;
    }
}
