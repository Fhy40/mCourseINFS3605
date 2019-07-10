package com.example.mcourse.degree;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mcourse.R;

import java.util.List;

public class degree_adapter extends RecyclerView.Adapter<degree_adapter.degreeViewHolder> {
    private List<degree> degreeList;

    public degree_adapter(List<degree> beerList) {
        this.degreeList = beerList;
    }

    @Override
    public degreeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.degree_list_item, parent, false);

        return new degreeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(degreeViewHolder holder, int position) {
        holder.name.setText(degreeList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return degreeList.size();
    }

    public class degreeViewHolder extends RecyclerView.ViewHolder {
        public TextView name;


        public degreeViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.degree_name);

        }
    }

    AdapterView.OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
