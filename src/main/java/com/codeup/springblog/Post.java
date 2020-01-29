package com.codeup.springblog;

import com.codeup.springblog.repositories.PostRepository;
import org.hibernate.tool.schema.extract.spi.ExtractionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

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


    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
    private PostDetails postDetail;
    //@MapsId tells Hibernate to use the id column of post details as both primary key and foreign key.
    // Also, notice that the @Id column of the Address entity no longer uses the @GeneratedValue annotation.


    public Post() {
    }

    public Post(long id, String title, String body, PostDetails postDetail) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.postDetail = postDetail;

    }

    public Post(String title, String body, PostDetails postDetails) {
        this.title = title;
        this.body = body;
        this.postDetail = postDetails;
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


}
