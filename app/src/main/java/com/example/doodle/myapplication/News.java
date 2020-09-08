package com.example.doodle.myapplication;

/**
 * Created by ${Lengyuedong} on 2020/9/7.
 */

public class News {
    private String title;
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
