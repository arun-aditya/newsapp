package com.example.newsapp.apicall;

import retrofit2.Call;
import retrofit2.http.GET;

public interface apiinterface {


    @GET("top-headlines?country=in&apiKey=14636f8ed9fb4f558715fe5375c4630b")
    Call<newsapimodel> getapihomenews();

    @GET("top-headlines?country=in&category=business&apiKey=14636f8ed9fb4f558715fe5375c4630b")
    Call<newsapimodel> getapibusinessnews();

    @GET("top-headlines?country=in&category=health&apiKey=14636f8ed9fb4f558715fe5375c4630b")
    Call<newsapimodel> getapihealthnews();

    @GET("top-headlines?country=in&category=science&apiKey=14636f8ed9fb4f558715fe5375c4630b")
    Call<newsapimodel> getapisciencenews();

    @GET("top-headlines?country=in&category=sports&apiKey=14636f8ed9fb4f558715fe5375c4630b")
    Call<newsapimodel> getapisportsnews();

    @GET("top-headlines?country=in&category=entertainment&apiKey=14636f8ed9fb4f558715fe5375c4630b")
    Call<newsapimodel> getapientertainmentnews();


    @GET("top-headlines?country=in&category=technology&apiKey=14636f8ed9fb4f558715fe5375c4630b")
    Call<newsapimodel> getapitechnologynews();


}
