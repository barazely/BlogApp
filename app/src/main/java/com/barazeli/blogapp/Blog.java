package com.barazeli.blogapp;

public class Blog {
    private String comment,date_post,image,uID;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate_post() {
        return date_post;
    }

    public void setDate_post(String date_post) {
        this.date_post = date_post;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public Blog(String comment, String date_post, String image, String uID) {
        this.comment = comment;
        this.date_post = date_post;
        this.image = image;
        this.uID = uID;
    }

    public Blog() {
    }
}
