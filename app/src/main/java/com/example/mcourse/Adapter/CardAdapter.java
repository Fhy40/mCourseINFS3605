package com.example.mcourse.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.example.mcourse.Model.Model;
import com.example.mcourse.R;
import com.huxq17.swipecardsview.BaseCardAdapter;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CardAdapter extends BaseCardAdapter {

    private List<Model> modelList;
    private Context context;

    public CardAdapter(List<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public int getCardLayoutId() {
        return R.layout.card_view;
    }

    @Override
    public void onBindData(int position, View cardview) {
        if(modelList == null || modelList.size() == 0) {
            return;
        }
        ImageView imageView = (ImageView) cardview.findViewById(R.id.imageView);
        Model model = modelList.get(position);
        //Picasso.with(context).load(model.getImage()).into(imageView);
        Glide.with(context).load(model.getResourceIdl()).into(imageView);
    }
}
