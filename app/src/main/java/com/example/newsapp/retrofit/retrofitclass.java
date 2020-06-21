package com.example.newsapp.retrofit;

import com.example.newsapp.apicall.apiinterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitclass {

    public static Retrofit retrofit=null;
    public static String BASE_URL="https://newsapi.org/v2/";


    public static Retrofit getinstance(){

        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
