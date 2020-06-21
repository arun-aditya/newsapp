package com.example.newsapp.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.newsapp.dao.favnewsdao;
import com.example.newsapp.entity.favouritesnews;

@Database(entities = {favouritesnews.class},version = 1,exportSchema = false)
public abstract class favouritesnews_database extends RoomDatabase {

    private static favouritesnews_database instance;
    public  abstract favnewsdao favnewsdao();

    public static synchronized favouritesnews_database getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder
                    (context.getApplicationContext(), favouritesnews_database.class, "favouritesnews_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }



}
