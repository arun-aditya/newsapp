package com.example.newsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.entity.favouritesnews;


import java.util.List;

public class newsfragmentadapter extends RecyclerView.Adapter<newsfragmentadapter.newsfragviewholder>{
    private List<favouritesnews> mdatanewsfrag;
    Context context;
    onNewsClick listener;

    public newsfragmentadapter(List<favouritesnews> mdatanewsfrag,Context context,onNewsClick listener) {
        this.context=context;
        this.mdatanewsfrag=mdatanewsfrag;
        this.listener=listener;
    }
    public favouritesnews getnoteat(int position) {
        return mdatanewsfrag.get(position);
    }

    @NonNull
    @Override
    public newsfragviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new newsfragviewholder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.newsitem_newsfrag,parent,false),listener);
    }

    @Override
    public void onBindViewHolder(@NonNull newsfragviewholder holder, int position) {
        holder.newstxt.setText(mdatanewsfrag.get(position).getTitle());
        Glide.with(context).load(mdatanewsfrag.get(position).getUrlToImage()).fitCenter().centerCrop().into(holder.newsimg);

    }


    @Override
    public int getItemCount() {
        return mdatanewsfrag.size();
    }

    class newsfragviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView newsimg;
        TextView newstxt;
        onNewsClick onNewsClick;
        public newsfragviewholder(@NonNull View itemView,onNewsClick onNewsClick) {
            super(itemView);
            newsimg=itemView.findViewById(R.id.image_itemrview);
            newstxt=itemView.findViewById(R.id.title_itemrview);
            this.onNewsClick=onNewsClick;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNewsClick.onNewsItemSelected(getAdapterPosition(),itemView);
        }
    }
    public interface onNewsClick{
        void onNewsItemSelected(int position,View view);
    }
}
