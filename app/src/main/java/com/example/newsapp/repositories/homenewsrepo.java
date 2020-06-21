package com.example.newsapp.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newsapp.apicall.apiinterface;
import com.example.newsapp.apicall.newsapimodel;
import com.example.newsapp.dao.favnewsdao;
import com.example.newsapp.databases.favouritesnews_database;
import com.example.newsapp.entity.favouritesnews;
import com.example.newsapp.retrofit.retrofitclass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class homenewsrepo {

    private favnewsdao favdao_repo;
    private LiveData<List<favouritesnews>> allfavnewsinrepo;
    public MutableLiveData<List<favouritesnews>> Livedata =new MutableLiveData<>();
    public List<favouritesnews> allhomenews,allbusinessnews,allsportsnews,alltechnews,allentertainmentnews,allsciencenews,allhealthnews;
    public MutableLiveData<List<favouritesnews>> Livebusinessdata =new MutableLiveData<>();
    public MutableLiveData<List<favouritesnews>> Livetechdata =new MutableLiveData<>();
    public MutableLiveData<List<favouritesnews>> Livesportsdata =new MutableLiveData<>();
    public MutableLiveData<List<favouritesnews>> Liveentertainmentdata =new MutableLiveData<>();
    public MutableLiveData<List<favouritesnews>> Livehealthdata =new MutableLiveData<>();
    public MutableLiveData<List<favouritesnews>> Livesciencedata =new MutableLiveData<>();




    //constructor:
    public homenewsrepo(Application application) {
        favouritesnews_database hdb= favouritesnews_database.getInstance(application);
        favdao_repo=hdb.favnewsdao();
        allfavnewsinrepo=favdao_repo.getallfavnews();
    }

    //retrieving favouritesnews from database
    public LiveData<List<favouritesnews>> getallfavnews_repo(){return allfavnewsinrepo;}

    //addingfavouritesnews
    public void insert_repo(favouritesnews fn){new inserthomenewsasynctask(favdao_repo).execute(fn);}

    public void delete_repo(favouritesnews fn){new deletehomenewsasynctask(favdao_repo).execute(fn);}



    //apifetchingforhomenews:
    public MutableLiveData<List<favouritesnews>> getapi() {
        apiinterface apiinterfaceobject= retrofitclass.getinstance().create(apiinterface.class);

        apiinterfaceobject.getapihomenews().enqueue(new Callback<newsapimodel>() {
            @Override
            public void onResponse(Call<newsapimodel> call, Response<newsapimodel> response) {
                allhomenews=response.body().getHomenewsdata();
                Livedata.postValue(allhomenews);
            }
            @Override
            public void onFailure(Call<newsapimodel> call, Throwable t) {
            }
        });
        return Livedata;
    }

    //apifetchingforbusinessnews
    public MutableLiveData<List<favouritesnews>> getbusinessnews(){

        apiinterface apiinterface=retrofitclass.getinstance().create(com.example.newsapp.apicall.apiinterface.class);
        apiinterface.getapibusinessnews().enqueue(new Callback<newsapimodel>() {
            @Override
            public void onResponse(Call<newsapimodel> call, Response<newsapimodel> response) {
                allbusinessnews=response.body().getHomenewsdata();
                Livebusinessdata.postValue(allbusinessnews);
            }
            @Override
            public void onFailure(Call<newsapimodel> call, Throwable t) {
            }
        });
        return Livebusinessdata;
    }
    //apifetchingforsportsnews
    public MutableLiveData<List<favouritesnews>> getsportsnews(){

        apiinterface apiinterface=retrofitclass.getinstance().create(com.example.newsapp.apicall.apiinterface.class);
        apiinterface.getapisportsnews().enqueue(new Callback<newsapimodel>() {
            @Override
            public void onResponse(Call<newsapimodel> call, Response<newsapimodel> response) {
                allsportsnews=response.body().getHomenewsdata();
                Livesportsdata.postValue(allsportsnews);
            }
            @Override
            public void onFailure(Call<newsapimodel> call, Throwable t) {
            }
        });
        return Livesportsdata;
    }
    //apifetchingforentertainmentnews
    public MutableLiveData<List<favouritesnews>> getentertainmentnews(){

        apiinterface apiinterface=retrofitclass.getinstance().create(com.example.newsapp.apicall.apiinterface.class);
        apiinterface.getapientertainmentnews().enqueue(new Callback<newsapimodel>() {
            @Override
            public void onResponse(Call<newsapimodel> call, Response<newsapimodel> response) {
                allentertainmentnews=response.body().getHomenewsdata();
                Liveentertainmentdata.postValue(allentertainmentnews);
            }
            @Override
            public void onFailure(Call<newsapimodel> call, Throwable t) {
            }
        });
        return Liveentertainmentdata;
    }
    //apifetchingforhealthnews
    public MutableLiveData<List<favouritesnews>> gethealthnews(){

        apiinterface apiinterface=retrofitclass.getinstance().create(com.example.newsapp.apicall.apiinterface.class);
        apiinterface.getapihealthnews().enqueue(new Callback<newsapimodel>() {
            @Override
            public void onResponse(Call<newsapimodel> call, Response<newsapimodel> response) {
                allhealthnews=response.body().getHomenewsdata();
                Livehealthdata.postValue(allhealthnews);
            }
            @Override
            public void onFailure(Call<newsapimodel> call, Throwable t) {
            }
        });
        return Livehealthdata;
    }
    //apifetchingfortechnologynews
    public MutableLiveData<List<favouritesnews>> gettechnews(){

        apiinterface apiinterface=retrofitclass.getinstance().create(com.example.newsapp.apicall.apiinterface.class);
        apiinterface.getapitechnologynews().enqueue(new Callback<newsapimodel>() {
            @Override
            public void onResponse(Call<newsapimodel> call, Response<newsapimodel> response) {
                alltechnews=response.body().getHomenewsdata();
                Livetechdata.postValue(alltechnews);
            }
            @Override
            public void onFailure(Call<newsapimodel> call, Throwable t) {
            }
        });
        return Livetechdata;
    }
    //apifetchingforsciencenews
    public MutableLiveData<List<favouritesnews>> getsciencenews(){

        apiinterface apiinterface=retrofitclass.getinstance().create(com.example.newsapp.apicall.apiinterface.class);
        apiinterface.getapisciencenews().enqueue(new Callback<newsapimodel>() {
            @Override
            public void onResponse(Call<newsapimodel> call, Response<newsapimodel> response) {
                allsciencenews=response.body().getHomenewsdata();
                Livesciencedata.postValue(allsciencenews);
            }
            @Override
            public void onFailure(Call<newsapimodel> call, Throwable t) {
            }
        });
        return Livesciencedata;
    }


    //insertasynctask:
    private static class inserthomenewsasynctask extends AsyncTask<favouritesnews, Void,Void> {
        favnewsdao hndao;
        public inserthomenewsasynctask(favnewsdao hndao) {
            this.hndao = hndao;
        }
        @Override
        protected Void doInBackground(favouritesnews... favouritesnews) {
            hndao.insert(favouritesnews[0]);
            return null;
        }
    }
    private static class deletehomenewsasynctask extends AsyncTask<favouritesnews, Void,Void> {
        favnewsdao hndao;
        public deletehomenewsasynctask(favnewsdao hndao) {
            this.hndao = hndao;
        }
        @Override
        protected Void doInBackground(favouritesnews... favouritesnews) {
            hndao.delete(favouritesnews[0]);
            return null;
        }
    }

}
