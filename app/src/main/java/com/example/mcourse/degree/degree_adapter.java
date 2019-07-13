package com.example.mcourse.degree;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcourse.R;

import java.util.List;

public class degree_adapter extends RecyclerView.Adapter<degree_adapter.degreeViewHolder> {
    private List<degree> degreeList;
    private OnDegreeListener mOnDegreeListener;

    public degree_adapter(List<degree> degreeList, OnDegreeListener onDegreeListener) {
        this.degreeList = degreeList;
        this.mOnDegreeListener = onDegreeListener;
    }

    @Override
    public degreeViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.degree_list_item, parent, false);

        return new degreeViewHolder(itemView, mOnDegreeListener);
    }

    @Override
    public void onBindViewHolder(degreeViewHolder holder, int position) {
        holder.name.setText(degreeList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return degreeList.size();
    }

    public class degreeViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        public TextView name;
        OnDegreeListener onDegreeListener;
        private boolean isDegreeSelected = false;

        public degreeViewHolder(View view, OnDegreeListener onDegreeListener) {
            super(view);
            name = (TextView) view.findViewById(R.id.degree_name);
            this.onDegreeListener = onDegreeListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onDegreeListener.onDegreeClick(getAdapterPosition());

            if(!isDegreeSelected){
                Log.d("arjun","RUNNING FALSE LOOP");
                name.setBackgroundResource(R.drawable.card_select);
                isDegreeSelected = true;
                Log.d("arjun","Item is selected: " + isDegreeSelected);
            }else if(isDegreeSelected){
                Log.d("arjun","RUNNING TRUE LOOP");
                name.setBackgroundResource(R.drawable.card);
                isDegreeSelected = false;
                Log.d("arjun","Item is selected: " + isDegreeSelected);
            }




            Log.d("arjun", "onClick: an item was clicked");

        }
    }

    public interface OnDegreeListener {
        void onDegreeClick(int position);
    }
}
