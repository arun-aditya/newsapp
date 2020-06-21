package com.example.newsapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.newsapp.R;
import com.example.newsapp.adapters.homenewsadapter;
import com.example.newsapp.entity.favouritesnews;
import com.example.newsapp.viewmodel.vmodel;

import java.util.List;

public class HomeFragment extends Fragment implements homenewsadapter.onHomeNewsClick{
    vmodel viewmodel;
    ViewPager2 vp2_home;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.homefragment_layout,container,false);
        setHasOptionsMenu(true);

        vp2_home=view.findViewById(R.id.vpager_home);
        viewmodel= ViewModelProviders.of(this).get(vmodel.class);
        viewmodel.getallhomenews_vmodel().observe(getViewLifecycleOwner(), new Observer<List<favouritesnews>>() {
            @Override
            public void onChanged(final List<favouritesnews> favouritesnews) {
                homenewsadapter hmadapter=new homenewsadapter(favouritesnews, vp2_home, getContext(), new homenewsadapter.onHomeNewsClick() {
                    @Override
                    public void onHomeNewsItemClicked(final int position, View view) {
                        Bundle bundl=new Bundle();
                        bundl.putString("imagetodetailed",favouritesnews.get(position).getUrlToImage());
                        bundl.putString("title",favouritesnews.get(position).getTitle());
                        bundl.putString("desc",favouritesnews.get(position).getDescription());
                        Navigation.findNavController(view).navigate(R.id.detailedFragment,bundl);
                    }

                    @Override
                    public void onSaveButtonClick(int pos, View view) {
                        Toast.makeText(getContext(), "Saved To Bookmarks", Toast.LENGTH_SHORT).show();
                        viewmodel.insert_vmodel(favouritesnews.get(pos));
                    }
                });

                vp2_home.setAdapter(hmadapter);
//                vp2_home.setPageTransformer(new zoomOutPageTransformer());
                vp2_home.setClipToPadding(false);
                vp2_home.setClipChildren(false);
                vp2_home.setOffscreenPageLimit(3);
                vp2_home.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
                CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
                compositePageTransformer.addTransformer(new MarginPageTransformer(40));
                compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                    @Override
                    public void transformPage(@NonNull View page, float position) {
                        float r=1-Math.abs(position);
                        page.setScaleY(0.85f+ r*0.15f);
                    }
                });
                vp2_home.setPageTransformer(compositePageTransformer);
            }
        });

        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        ((AppCompatActivity)getActivity()).getMenuInflater().inflate(R.menu.menu_tool, menu);
         super.onCreateOptionsMenu(menu,menuInflater);
    }

    @Override
    public void onHomeNewsItemClicked(int position, View view) {

    }

    @Override
    public void onSaveButtonClick(int pos, View view) {

    }
}
