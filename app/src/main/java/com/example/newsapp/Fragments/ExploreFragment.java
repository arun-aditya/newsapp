package com.example.newsapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.adapters.explorerecycler;
import com.example.newsapp.entity.exploreitem;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment implements explorerecycler.onNoteClick {
    RecyclerView review;
    List<exploreitem> mdt=new ArrayList<>();
    explorerecycler expadapt;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.explorefragment_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        review=view.findViewById(R.id.rview_explore);
        review.setHasFixedSize(true);
        review.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mdt.add(new exploreitem("Sports",R.drawable.medal));
        mdt.add(new exploreitem("Science",R.drawable.microscope));
        mdt.add(new exploreitem("Technology",R.drawable.tech));
        mdt.add(new exploreitem("Health",R.drawable.hela));
        mdt.add(new exploreitem("Entertainment",R.drawable.clapperboard));
        mdt.add(new exploreitem("Business",R.drawable.graphic));
        expadapt=new explorerecycler(mdt,getContext(),this);
        review.setAdapter(expadapt);
    }


    @Override
    public void onNoteItemSelected(int position,View view) {
        Toast.makeText(getContext(), "itemclicked at:"+position, Toast.LENGTH_SHORT).show();
        Bundle bud=new Bundle();
        switch(position){
            case 0:
                bud.putString("category","Sports");
                Navigation.findNavController(view).navigate(R.id.newsFragment2,bud);
                break;
            case 1:
                bud.putString("category","Science");
                Navigation.findNavController(view).navigate(R.id.newsFragment2,bud);
                break;
            case 2:
                bud.putString("category","Technology");
                Navigation.findNavController(view).navigate(R.id.newsFragment2,bud);
                break;
            case 3:
                bud.putString("category","Health");
                Navigation.findNavController(view).navigate(R.id.newsFragment2,bud);
                break;
            case 4:
                bud.putString("category","Entertainment");
                Navigation.findNavController(view).navigate(R.id.newsFragment2,bud);
                break;
            case 5:
                bud.putString("category","Business");
                Navigation.findNavController(view).navigate(R.id.newsFragment2,bud);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mdt.clear();
    }


}
