package com.example.android.retrofitstudy1.model;

public class Model {
    int userid,id;
    String title,body;

    public Model(int userid, int id, String title, String body)
    {
        this.userid = userid;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        this.title = title;
        return title;
    }
}
