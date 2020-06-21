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
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.adapters.newsfragmentadapter;
import com.example.newsapp.entity.favouritesnews;
import com.example.newsapp.viewmodel.vmodel;

import java.util.List;

public class NewsFragment extends Fragment implements newsfragmentadapter.onNewsClick {
    public String category;
    private RecyclerView recview;
    private vmodel vm;
    public newsfragmentadapter nadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.newsfragment_layout,container,false);
        Bundle bundle=this.getArguments();
        category=bundle.getString("category");
        Toast.makeText(getContext(), "cat:"+category, Toast.LENGTH_SHORT).show();
        recview=view.findViewById(R.id.recyclerview_newsfrag);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));
        recview.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        switch (category){
            case "Sports":
                vm= ViewModelProviders.of(this).get(vmodel.class);
                vm.getallsportsnews_vmodel().observe(getViewLifecycleOwner(), new Observer<List<favouritesnews>>() {
                    @Override
                    public void onChanged(final List<favouritesnews> news) {
                        nadapter=new newsfragmentadapter(news, getContext(), new newsfragmentadapter.onNewsClick() {
                            @Override
                            public void onNewsItemSelected(int position, View view) {
                                Toast.makeText(getContext(), "itemclicked"+news.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                                Bundle bundle=new Bundle();
                                bundle.putString("imagetodetailed",news.get(position).getUrlToImage());
                                bundle.putString("title",news.get(position).getTitle());
                                bundle.putString("desc",news.get(position).getDescription());
                                Navigation.findNavController(view).navigate(R.id.detailedFragment,bundle);
                            }
                        });
                        recview.setAdapter(nadapter);
                    }
                });
                break;
            case "Science":
                vm= ViewModelProviders.of(this).get(vmodel.class);
                vm.getallsciencenews_vmodel().observe(getViewLifecycleOwner(), new Observer<List<favouritesnews>>() {
                    @Override
                    public void onChanged(final List<favouritesnews> news) {
                        nadapter=new newsfragmentadapter(news, getContext(), new newsfragmentadapter.onNewsClick() {
                            @Override
                            public void onNewsItemSelected(int position, View view) {
                                Toast.makeText(getContext(), "itemclicked"+position, Toast.LENGTH_SHORT).show();
                                Bundle bundle=new Bundle();
                                bundle.putString("imagetodetailed",news.get(position).getUrlToImage());
                                bundle.putString("title",news.get(position).getTitle());
                                bundle.putString("desc",news.get(position).getDescription());
                                Navigation.findNavController(view).navigate(R.id.detailedFragment,bundle);
                            }
                        });
                        recview.setAdapter(nadapter);
                    }
                });
                break;
            case "Technology":
                vm= ViewModelProviders.of(this).get(vmodel.class);
                vm.getalltechnews_vmodel().observe(getViewLifecycleOwner(), new Observer<List<favouritesnews>>() {
                    @Override
                    public void onChanged(final List<favouritesnews> news) {
                        nadapter=new newsfragmentadapter(news, getContext(), new newsfragmentadapter.onNewsClick() {
                            @Override
                            public void onNewsItemSelected(int position, View view) {
                                Toast.makeText(getContext(), "itemclicked"+position, Toast.LENGTH_SHORT).show();
                                Bundle bundle=new Bundle();
                                bundle.putString("imagetodetailed",news.get(position).getUrlToImage());
                                bundle.putString("title",news.get(position).getTitle());
                                bundle.putString("desc",news.get(position).getDescription());
                                Navigation.findNavController(view).navigate(R.id.detailedFragment,bundle);
                            }
                        });
                        recview.setAdapter(nadapter);
                    }
                });
                break;
            case "Health":
                vm= ViewModelProviders.of(this).get(vmodel.class);
                vm.getallhealthnews_vmodel().observe(getViewLifecycleOwner(), new Observer<List<favouritesnews>>() {
                    @Override
                    public void onChanged(final List<favouritesnews> news) {
                        nadapter=new newsfragmentadapter(news, getContext(), new newsfragmentadapter.onNewsClick() {
                            @Override
                            public void onNewsItemSelected(int position, View view) {
                                Toast.makeText(getContext(), "itemclicked"+position, Toast.LENGTH_SHORT).show();
                                Bundle bundle=new Bundle();
                                bundle.putString("imagetodetailed",news.get(position).getUrlToImage());
                                bundle.putString("title",news.get(position).getTitle());
                                bundle.putString("desc",news.get(position).getDescription());
                                Navigation.findNavController(view).navigate(R.id.detailedFragment,bundle);
                            }
                        });
                        recview.setAdapter(nadapter);
                    }
                });
                break;
            case "Entertainment":
                vm= ViewModelProviders.of(this).get(vmodel.class);
                vm.getallentertainmentnews_vmodel().observe(getViewLifecycleOwner(), new Observer<List<favouritesnews>>() {
                    @Override
                    public void onChanged(final List<favouritesnews> news) {
                        nadapter=new newsfragmentadapter(news, getContext(), new newsfragmentadapter.onNewsClick() {
                            @Override
                            public void onNewsItemSelected(int position, View view) {
                                Toast.makeText(getContext(), "itemclicked"+position, Toast.LENGTH_SHORT).show();
                                Bundle bundle=new Bundle();
                                bundle.putString("imagetodetailed",news.get(position).getUrlToImage());
                                bundle.putString("title",news.get(position).getTitle());
                                bundle.putString("desc",news.get(position).getDescription());
                                Navigation.findNavController(view).navigate(R.id.detailedFragment,bundle);
                            }
                        });
                        recview.setAdapter(nadapter);
                    }
                });
                break;
            case "Business":
                vm= ViewModelProviders.of(this).get(vmodel.class);
                vm.getallbusinessnews_vmodel().observe(getViewLifecycleOwner(), new Observer<List<favouritesnews>>() {
                    @Override
                    public void onChanged(final List<favouritesnews> news) {
                        nadapter=new newsfragmentadapter(news, getContext(), new newsfragmentadapter.onNewsClick() {
                            @Override
                            public void onNewsItemSelected(int position, View view) {
                                Toast.makeText(getContext(), "itemclicked"+position, Toast.LENGTH_SHORT).show();
                                Bundle bundle=new Bundle();
                                bundle.putString("imagetodetailed",news.get(position).getUrlToImage());
                                bundle.putString("title",news.get(position).getTitle());
                                bundle.putString("desc",news.get(position).getDescription());
                                Navigation.findNavController(view).navigate(R.id.detailedFragment,bundle);
                            }
                        });
                        recview.setAdapter(nadapter);
                    }
                });
                break;
        }
    }


    @Override
    public void onNewsItemSelected(int position, View view) {

    }
}
