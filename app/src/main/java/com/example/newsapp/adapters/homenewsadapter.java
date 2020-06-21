package com.example.newsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.entity.favouritesnews;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class homenewsadapter extends RecyclerView.Adapter<homenewsadapter.homenewsviewholder>{

    private List<favouritesnews> mdata;
    private ViewPager2 vp2_adapter;
    Context context;
    onHomeNewsClick listener;

    public homenewsadapter(List<favouritesnews> mdata, ViewPager2 vp2_adapter, Context context,onHomeNewsClick listener) {
        this.mdata = mdata;
        this.vp2_adapter = vp2_adapter;
        this.context=context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public homenewsviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new homenewsviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.homenewsitem,parent,false),listener);
    }

    @Override
    public void onBindViewHolder(@NonNull homenewsviewholder holder, int position) {
        holder.homenewstitle.setText(mdata.get(position).getTitle());
        Glide.with(context).load(mdata.get(position).getUrlToImage()).fitCenter().centerCrop().into(holder.homenewsimg);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class homenewsviewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView homenewsimg;
        TextView homenewstitle;
        FloatingActionButton fb;
        onHomeNewsClick listener;

        public homenewsviewholder(@NonNull final View itemView, final onHomeNewsClick listener) {
            super(itemView);
            homenewsimg = itemView.findViewById(R.id.homenews_image);
            homenewstitle = itemView.findViewById(R.id.homenews_title);
            fb=itemView.findViewById(R.id.bookmark_homepage);
            this.listener=listener;
            homenewsimg.setOnClickListener(this);
            homenewstitle.setOnClickListener(this);
            fb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onSaveButtonClick(getAdapterPosition(),itemView);
                }
            });

        }

        @Override
        public void onClick(View view) {
            listener.onHomeNewsItemClicked(getAdapterPosition(),itemView);
        }
    }
    public interface onHomeNewsClick{
        void onHomeNewsItemClicked(int position,View view);
        void onSaveButtonClick(int pos,View view);
    }
}
