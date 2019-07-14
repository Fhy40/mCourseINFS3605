package com.example.mcourse.course_preference;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mcourse.R;

import java.util.List;

public class course_preference_adapter extends RecyclerView.Adapter<course_preference_adapter.coursePreferenceViewHolder> {
    private List<course_preference> coursePreferenceList;
    private OnCoursePreferenceListener mOnCoursePreferenceListener;

    public course_preference_adapter(List<course_preference> coursePreferenceList, OnCoursePreferenceListener onCoursePreferenceListener) {
        this.coursePreferenceList = coursePreferenceList;
        this.mOnCoursePreferenceListener = onCoursePreferenceListener;
    }

    @Override
    public coursePreferenceViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_preference_list_item, parent, false);

        return new coursePreferenceViewHolder(itemView, mOnCoursePreferenceListener);
    }

    @Override
    public void onBindViewHolder(coursePreferenceViewHolder holder, int position) {
        holder.name.setText(coursePreferenceList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return coursePreferenceList.size();
    }

    public class coursePreferenceViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        public TextView name;
        OnCoursePreferenceListener onCoursePreferenceListener;
        private boolean isCoursePreferenceSelected = false;

        public coursePreferenceViewHolder(View view, OnCoursePreferenceListener onCoursePreferenceListener) {
            super(view);
            name = (TextView) view.findViewById(R.id.coursePreference_name);
            this.onCoursePreferenceListener = onCoursePreferenceListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onCoursePreferenceListener.onCoursePreferenceClick(getAdapterPosition());

            if(!isCoursePreferenceSelected){
                Log.d("arjun","RUNNING FALSE LOOP");
                name.setBackgroundResource(R.drawable.card_select);
                isCoursePreferenceSelected = true;
                Log.d("arjun","Item is selected: " + isCoursePreferenceSelected);
            }else if(isCoursePreferenceSelected){
                Log.d("arjun","RUNNING TRUE LOOP");
                name.setBackgroundResource(R.drawable.card);
                isCoursePreferenceSelected = false;
                Log.d("arjun","Item is selected: " + isCoursePreferenceSelected);
            }




            Log.d("arjun", "onClick: an item was clicked");

        }
    }

    public interface OnCoursePreferenceListener {
        void onCoursePreferenceClick(int position);
    }
}
