package com.codeup.springblog;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "posts")
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    public long id;
    @Column(nullable = false, name = "title", length = 200)
    public String title;
    @Column(nullable = false, name = "body", length = 1000)
    public String body;


    //@MapsId tells Hibernate to use the id column of post details as both primary key and foreign key.
    // Also, notice that the @Id column of the Address entity no longer uses the @GeneratedValue annotation.
    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
    private PostDetails postDetail;
    ////////////////
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImage> images;
    ///////////////
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    public Post() {
    }

    public Post(long id,
                String title,
                String body,
                PostDetails postDetail,
                List<PostImage> images,
                User users) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.postDetail = postDetail;
        this.images = images;
        this.user = users;

    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, PostDetails postDetails, User user) {
        this.title = title;
        this.body = body;
        this.postDetail = postDetails;
        this.user = user;

    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public PostDetails getPostDetails() {
        return postDetail;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetail = postDetails;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PostDetails getPostDetail() {
        return postDetail;
    }

    public void setPostDetail(PostDetails postDetail) {
        this.postDetail = postDetail;
    }

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
