package com.example.newsapp.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.newsapp.entity.favouritesnews;

import java.util.List;

@Dao
public interface favnewsdao {

    @Insert
    void insert(favouritesnews favouritesnews);

    @Query("SELECT * FROM favourite_news")
    LiveData<List<favouritesnews>> getallfavnews();

    @Query("DELETE FROM favourite_news")
    void deleteallfavnews();

    @Delete
    void delete(favouritesnews favouritesnews);
}
