package com.example.newsapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newsapp.entity.favouritesnews;
import com.example.newsapp.repositories.homenewsrepo;

import java.util.List;

public class vmodel extends AndroidViewModel {
    private homenewsrepo homenewsrepo;
    private LiveData<List<favouritesnews>> allfavoritenews_vmodel;
    private MutableLiveData<List<favouritesnews>> allhomenews_vmodel, allbusinessnews_vmodel, alltechnews_vmodel, allhealthnews_vmodel, allsciencenews_vmodel, allsportsnews_vmodel, allenternainmentnews_vmodel;

    public vmodel(@NonNull Application application) {
        super(application);
        homenewsrepo = new homenewsrepo(application);
        allfavoritenews_vmodel = homenewsrepo.getallfavnews_repo();
        allhomenews_vmodel = homenewsrepo.getapi();
        allbusinessnews_vmodel = homenewsrepo.getbusinessnews();
        alltechnews_vmodel = homenewsrepo.gettechnews();
        allhealthnews_vmodel = homenewsrepo.gethealthnews();
        allsciencenews_vmodel = homenewsrepo.getsciencenews();
        allsportsnews_vmodel = homenewsrepo.getsportsnews();
        allenternainmentnews_vmodel = homenewsrepo.getentertainmentnews();
    }

    public void insert_vmodel(favouritesnews fav){ homenewsrepo.insert_repo(fav);}
    public LiveData<List<favouritesnews>> getallfavnews_vmodel() {
        return allfavoritenews_vmodel;
    }

    public void delete_vmodel(favouritesnews fav){homenewsrepo.delete_repo(fav);}

    public MutableLiveData<List<favouritesnews>> getallhomenews_vmodel() {
        return allhomenews_vmodel;
    }

    public MutableLiveData<List<favouritesnews>> getallbusinessnews_vmodel() {
        return allbusinessnews_vmodel;
    }

    public MutableLiveData<List<favouritesnews>> getallsportsnews_vmodel() {
        return allsportsnews_vmodel;
    }

    public MutableLiveData<List<favouritesnews>> getallhealthnews_vmodel() {
        return allhealthnews_vmodel;
    }

    public MutableLiveData<List<favouritesnews>> getalltechnews_vmodel() {
        return alltechnews_vmodel;
    }

    public MutableLiveData<List<favouritesnews>> getallentertainmentnews_vmodel() {
        return allenternainmentnews_vmodel;
    }
    public MutableLiveData<List<favouritesnews>> getallsciencenews_vmodel(){
        return allsciencenews_vmodel;
    }
}
