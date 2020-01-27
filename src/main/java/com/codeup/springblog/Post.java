package com.codeup.springblog;

public class Post {
    private String title;
    private String body;
    private int id;

    public Post(){}

    public Post(int id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }
    public Post(String title, String body) {
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
