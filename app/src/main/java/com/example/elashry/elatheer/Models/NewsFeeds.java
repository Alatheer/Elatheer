package com.example.elashry.elatheer.Models;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsFeeds {

    private String img;
private String title;

    public NewsFeeds(String content_new, String title_new, String date_new) {
        this.content_new = content_new;
        this.title_new = title_new;
        this.date_new = date_new;
    }

    public String getContent_new() {
        return content_new;
    }

    public String getTitle_new() {
        return title_new;
    }

    public String getDate_new() {
        return date_new;
    }

    private String content_new;
    private String title_new;
    private String date_new;


    public NewsFeeds(String img, String title) {
        this.img=img;
//        this.date=date;
        this.title=title;
    }

    public NewsFeeds() {

    }

    public String getImg() {
        return img;
    }

//    public String getDate() {
//        return date;
//    }

    public String getTitle() {
        return title;
    }
}