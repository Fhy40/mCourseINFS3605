package com.example.mcourse.career_selection;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mcourse.R;
import com.example.mcourse.degree.degree;

import java.util.List;

public class career_adapter extends RecyclerView.Adapter<career_adapter.careerViewHolder> {
    private List<career> careerList;
    private OnCareerListener mOnCareerListener;

    public career_adapter(List<career> careerList, OnCareerListener onCareerListener) {
        this.careerList = careerList;
        this.mOnCareerListener = onCareerListener;
    }

    @Override
    public careerViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.career_list_item, parent, false);

        return new careerViewHolder(itemView, mOnCareerListener);
    }

    @Override
    public void onBindViewHolder(careerViewHolder holder, int position) {
        holder.name.setText(careerList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return careerList.size();
    }
    public class careerViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        public TextView name;
        OnCareerListener onCareerListener;
        private boolean isCareerSelected = false;

        public careerViewHolder(View view, OnCareerListener onCareerListener) {
            super(view);
            name = (TextView) view.findViewById(R.id.career_name);
            this.onCareerListener = onCareerListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onCareerListener.onCareerClick(getAdapterPosition());

            if(!isCareerSelected){
                Log.d("arjun","RUNNING FALSE LOOP");
                name.setBackgroundResource(R.drawable.card_select);
                isCareerSelected = true;
                Log.d("arjun","Item is selected: " + isCareerSelected);
            }else if(isCareerSelected){
                Log.d("arjun","RUNNING TRUE LOOP");
                name.setBackgroundResource(R.drawable.card);
                isCareerSelected = false;
                Log.d("arjun","Item is selected: " + isCareerSelected);
            }

            Log.d("arjun", "onClick: an item was clicked");

        }
    }

    public interface OnCareerListener {
        void onCareerClick(int position);
    }

}
