package com.example.mcourse.friend_request;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mcourse.R;

import java.util.List;


public class friend_requests_adapter  extends RecyclerView.Adapter<friend_requests_adapter.requestsViewHolder>{
    private List<requests> requestList;
    private OnRequestsListener mOnRequestsListener;

    public friend_requests_adapter (List<requests> requestList, OnRequestsListener onRequestsListener) {
        this.requestList = requestList;
        this.mOnRequestsListener = onRequestsListener;
    }

    @Override
    public requestsViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.requests_list_item, parent, false);

        return new requestsViewHolder(itemView, mOnRequestsListener);
    }

    @Override
    public void onBindViewHolder(friend_requests_adapter.requestsViewHolder holder, int position) {
        holder.name.setText(requestList.get(position).getF_name() + " " + requestList.get(position).getL_name());
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public class requestsViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        public TextView name;
        OnRequestsListener onRequestsListener;
        private boolean isRequestsSelected = false;

        public requestsViewHolder(View view, OnRequestsListener onRequestsListener) {
            super(view);
            name = (TextView) view.findViewById(R.id.requests_name);
            this.onRequestsListener = onRequestsListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onRequestsListener.onRequestsClick(getAdapterPosition());

            if(!isRequestsSelected){
                Log.d("arjun","RUNNING FALSE LOOP");
                name.setBackgroundResource(R.drawable.card_select);
                isRequestsSelected = true;
                Log.d("arjun","Item is selected: " + isRequestsSelected);
            }else if(isRequestsSelected){
                Log.d("arjun","RUNNING TRUE LOOP");
                name.setBackgroundResource(R.drawable.card);
                isRequestsSelected = false;
                Log.d("arjun","Item is selected: " + isRequestsSelected);
            }

            Log.d("arjun", "onClick: an item was clicked");

        }
    }

    public interface OnRequestsListener {
        void onRequestsClick(int position);
    }
}
