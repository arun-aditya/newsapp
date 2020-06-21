package com.example.newsapp.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.entity.exploreitem;

import java.util.List;

public class explorerecycler extends RecyclerView.Adapter<explorerecycler.exploreviewholder> {
    public List<exploreitem> mdata_exploreritem;
    Context context;
    onNoteClick monnoteclick;

    public explorerecycler(List<exploreitem> mdata_exploreritem, Context context,onNoteClick onNoteClick) {
        this.mdata_exploreritem = mdata_exploreritem;
        this.context = context;
        this.monnoteclick=onNoteClick;
    }

    @NonNull
    @Override
    public exploreviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new exploreviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.explorepagerviewitem,parent,false),monnoteclick);
    }

    @Override
    public void onBindViewHolder(@NonNull exploreviewholder holder, int position) {
        holder.ig.setImageResource(mdata_exploreritem.get(position).getIma());
        holder.tx.setText(mdata_exploreritem.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mdata_exploreritem.size();
    }

    class exploreviewholder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        ImageView ig;
        TextView tx;
        onNoteClick onNoteClick;

        public exploreviewholder(@NonNull View itemView,onNoteClick onNoteClick) {
            super(itemView);
            ig = itemView.findViewById(R.id.image_exploreitem);
            tx = itemView.findViewById(R.id.text_exploreitem);
            this.onNoteClick=onNoteClick;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteClick.onNoteItemSelected(getAdapterPosition(),itemView);
        }
    }
    public interface onNoteClick{
        void onNoteItemSelected(int position,View view);
    }
}
