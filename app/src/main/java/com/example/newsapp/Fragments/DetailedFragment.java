package com.example.newsapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.makeramen.roundedimageview.RoundedImageView;

public class DetailedFragment extends Fragment {
    private String detailedimage;
    private String detailedtitle,detaileddescription;
    RoundedImageView detimg;
    TextView title,description;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.detailedfragment_layout,container,false);
        Bundle b=this.getArguments();
        detailedimage=b.getString("imagetodetailed");
        detailedtitle=b.getString("title");
        detaileddescription=b.getString("desc");
        detimg=view.findViewById(R.id.imgview_detailednews);
        title=view.findViewById(R.id.title_detailed);
        description=view.findViewById(R.id.desc_detailed);
        Glide.with(getContext()).load(detailedimage).fitCenter().centerCrop().into(detimg);
        title.setText(detailedtitle);
        description.setText(detaileddescription);
        return view;
    }
}
