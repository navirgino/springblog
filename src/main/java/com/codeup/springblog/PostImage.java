package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table(name = "post_image")
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(1000)")
    private String url;


    @ManyToOne
    @JoinColumn(name = "post_image_id")
    private Post post;


    public PostImage(){}

    public PostImage(long id, String url, Post post) {
        this.id = id;
        this.url = url;
        this.post = post;
    }
    public PostImage(String url, Post post) {
        this.url = url;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
