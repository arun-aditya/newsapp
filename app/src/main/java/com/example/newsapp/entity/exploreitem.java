package com.example.newsapp.entity;

public class exploreitem {
    private String text;
    private int ima;

    public exploreitem(String text, int ima) {
        this.text = text;
        this.ima = ima;
    }

    public int getIma() {
        return ima;
    }

    public void setIma(int ima) {
        this.ima = ima;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
