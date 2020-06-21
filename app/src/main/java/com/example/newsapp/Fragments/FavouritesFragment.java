package com.example.newsapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.adapters.newsfragmentadapter;
import com.example.newsapp.entity.favouritesnews;
import com.example.newsapp.viewmodel.vmodel;

import java.util.List;

public class FavouritesFragment extends Fragment {
    private RecyclerView rv;
    vmodel vm;
    public newsfragmentadapter nad;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.favouritesfragment_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv=view.findViewById(R.id.recyclerview_favsfrag);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);
        vm= ViewModelProviders.of(this).get(vmodel.class);
        vm.getallfavnews_vmodel().observe(getViewLifecycleOwner(), new Observer<List<favouritesnews>>() {
            @Override
            public void onChanged(List<favouritesnews> favouritesnews) {
                nad=new newsfragmentadapter(favouritesnews, getContext(), new newsfragmentadapter.onNewsClick() {
                    @Override
                    public void onNewsItemSelected(int position, View view) {

                    }
                });
                rv.setAdapter(nad);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                vm.delete_vmodel(nad.getnoteat(viewHolder.getAdapterPosition()));
                Toast.makeText(getContext(), "Note deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(rv);
    }
 }

