package com.example.mcourse.friends;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mcourse.R;
import com.example.mcourse.friend_request.friend_requests_adapter;

import java.util.List;

public class friends_adapter extends RecyclerView.Adapter<friends_adapter.friendsViewHolder>{
    private List<friend> friendList;
    private OnFriendListener mOnFriendListener;

    public friends_adapter (List<friend> friendList, friends_adapter.OnFriendListener onFriendListener) {
        this.friendList = friendList;
        this.mOnFriendListener = onFriendListener;
    }
    @Override
    public friendsViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friends_list_item, parent, false);

        return new friends_adapter.friendsViewHolder(itemView, mOnFriendListener);
    }

    @Override
    public void onBindViewHolder(friends_adapter.friendsViewHolder holder, int position) {
        holder.name.setText(friendList.get(position).getF_name() + " " + friendList.get(position).getL_name());
        holder.degree.setText(friendList.get(position).getDegree());
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    public class friendsViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        public TextView name;
        public TextView degree;
        OnFriendListener onFriendListener;
        private boolean isFriendSelected = false;

        public friendsViewHolder(View view, OnFriendListener onFriendListener) {
            super(view);
            name = (TextView) view.findViewById(R.id.friend_name);
            degree = (TextView) view.findViewById(R.id.cur_degree_textview);
            this.onFriendListener = onFriendListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onFriendListener.onFriendClick(getAdapterPosition());

            if(!isFriendSelected){
                Log.d("arjun","RUNNING FALSE LOOP");
                name.setBackgroundResource(R.drawable.card_select);
                isFriendSelected = true;
                Log.d("arjun","Item is selected: " + isFriendSelected);
            }else if(isFriendSelected){
                Log.d("arjun","RUNNING TRUE LOOP");
                name.setBackgroundResource(R.drawable.card);
                isFriendSelected = false;
                Log.d("arjun","Item is selected: " + isFriendSelected);
            }

            Log.d("arjun", "onClick: an item was clicked");

        }
    }

    public interface OnFriendListener {
        void onFriendClick(int position);
    }

}
