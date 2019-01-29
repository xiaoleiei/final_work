package com.bytedance.android.lesson.restapi.solution;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.bytedance.android.lesson.restapi.solution.model.Message;
import com.bytedance.android.lesson.restapi.solution.widget.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.NumberViewHolder> {

    private static final String TAG = "MyAdapter";

    private static int viewHolderCount;

    private List<Message> mData;

    public MyAdapter(List<Message> message) {
        viewHolderCount = 0;
        mData=message;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        viewHolder.viewPhoto.setImageResource(mData.get(viewHolderCount).getIcon());
        viewHolder.viewDiscription.setText(mData.get(viewHolderCount).getDescription());
        viewHolder.viewName.setText(mData.get(viewHolderCount).getTitle());
        viewHolder.viewTime.setText(mData.get(viewHolderCount).getTime());

        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int i) {
        Message message = mData.get(i);
        NumberViewHolder.updateUI(message);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private static TextView viewTime;
        private static  CircleImageView viewPhoto;
        private static TextView viewName;
        private static TextView viewDiscription;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            viewTime = (TextView) itemView.findViewById(R.id.tv_time);
            viewPhoto = ( CircleImageView) itemView.findViewById(R.id.iv_avatar);
            viewName = (TextView) itemView.findViewById(R.id.tv_title);
            viewDiscription = (TextView) itemView.findViewById(R.id.tv_description);
        }

        public static void updateUI(Message message) {
            viewTime.setText(message.getTime());
            viewName.setText(message.getTitle());
            viewDiscription.setText(message.getDescription());
            viewPhoto.setImageResource(message.getIcon());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
