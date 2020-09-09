package com.ezzy.gadsapp.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ezzy.gadsapp.LearningLeadersFragment;
import com.ezzy.gadsapp.R;
import com.ezzy.gadsapp.models.Learner;
import com.ezzy.gadsapp.models.Skill;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<Learner> learnerList;
//    private List<Skill> skillList;
    private Context mContext;

    public RecyclerViewAdapter(List<Learner> learnerList, Context mContext) {
        this.learnerList = learnerList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.gads_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTextView.setText(learnerList.get(position).getName());
        holder.descriptionTextView.setText(learnerList.get(position).getHours());
        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.downloader(new OkHttp3Downloader(mContext));
        builder.build().load(learnerList.get(position).getBadge_url())
                .placeholder(R.drawable.learner)
                .into(holder.badgeImageView);
    }

    @Override
    public int getItemCount() {
        return learnerList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView, descriptionTextView;
        ImageView badgeImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descTextView);
            badgeImageView = itemView.findViewById(R.id.badge);
        }
    }
}
