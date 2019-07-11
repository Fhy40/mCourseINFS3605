package com.example.mcourse.degree;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mcourse.MainActivity;
import com.example.mcourse.R;
import com.example.mcourse.degree_selection;

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
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Log.d("temp", "current selection is " + this.getClass().getName());

            }
        });
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
        Log.d("arjun", "current selection is " + onItemClickListener.toString());
    }
}
