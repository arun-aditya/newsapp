package com.example.newsapp.apicall;

import com.example.newsapp.entity.favouritesnews;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class newsapimodel {

    @SerializedName("articles")
    public List<favouritesnews> homenewsdata;

    public List<favouritesnews> getHomenewsdata() {
        return homenewsdata;
    }

    public void setHomenewsdata(List<favouritesnews> homenewsdata) {
        this.homenewsdata = homenewsdata;
    }
}
