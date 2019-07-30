package com.example.mcourse.year;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.mcourse.R;

import java.util.LinkedList;

public class YearAdapter extends BaseAdapter  {
    private LinkedList<Year> mData;
    private Context mContext;






    public YearAdapter(LinkedList<Year> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return getCount() == 0 ? null : mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_item,null);

        final Button t2_c3 = (Button) view.findViewById(R.id.t2_c3);
        final Button t2_c2 = (Button) view.findViewById(R.id.t2_c2);
        final Button t2_c1 = (Button) view.findViewById(R.id.t2_c1);

        final Button t3_c3 = (Button) view.findViewById(R.id.t3_c3);
        final Button t3_c2 = (Button) view.findViewById(R.id.t3_c2);
        final Button t3_c1 = (Button) view.findViewById(R.id.t3_c1);

        final Button t1_c3 = (Button) view.findViewById(R.id.t1_c3);
        final Button t1_c2 = (Button) view.findViewById(R.id.t1_c2);
        final Button t1_c1 = (Button) view.findViewById(R.id.t1_c1);

        final Button t1 = (Button) view.findViewById(R.id.t1);
        final Button t2 = (Button) view.findViewById(R.id.t2);
        final Button t3 = (Button) view.findViewById(R.id.t3);
        t1.setText(mData.get(i).getTerm_1());
        t2.setText(mData.get(i).getTerm_2());
        t3.setText(mData.get(i).getTerm_3());


        if (i == 0) {
            view.setBackgroundResource(R.drawable.year_5);
        } else if (i == 1) {
            view.setBackgroundResource(R.drawable.year_4);
        } else if (i == 2) {
            view.setBackgroundResource(R.drawable.year_3);
        } else if (i == 3) {
            view.setBackgroundResource(R.drawable.year_2);
        } else if (i == 4) {
            view.setBackgroundResource(R.drawable.year_1);
        }

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t3_c3.getVisibility() == View.VISIBLE) {
                    t3_c3.setVisibility(View.GONE);
                    t3_c2.setVisibility(View.GONE);
                    t3_c1.setVisibility(View.GONE);
                } else if (t3_c3.getVisibility() == View.GONE) {
                    t3_c3.setVisibility(View.VISIBLE);
                    t3_c2.setVisibility(View.VISIBLE);
                    t3_c1.setVisibility(View.VISIBLE);
                }
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t1_c3.getVisibility() == View.VISIBLE) {
                    t1_c3.setVisibility(View.GONE);
                    t1_c2.setVisibility(View.GONE);
                    t1_c1.setVisibility(View.GONE);
                } else if (t1_c3.getVisibility() == View.GONE) {
                    t1_c3.setVisibility(View.VISIBLE);
                    t1_c2.setVisibility(View.VISIBLE);
                    t1_c1.setVisibility(View.VISIBLE);
                }
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t2_c3.getVisibility() == View.VISIBLE) {
                    t2_c3.setVisibility(View.GONE);
                    t2_c2.setVisibility(View.GONE);
                    t2_c1.setVisibility(View.GONE);
                } else if (t2_c3.getVisibility() == View.GONE) {
                    t2_c3.setVisibility(View.VISIBLE);
                    t2_c2.setVisibility(View.VISIBLE);
                    t2_c1.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;


    }






}