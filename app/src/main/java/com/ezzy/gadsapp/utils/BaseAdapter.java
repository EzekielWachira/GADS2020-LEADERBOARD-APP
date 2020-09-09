package com.ezzy.gadsapp.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ezzy.gadsapp.R;
import com.ezzy.gadsapp.models.Learner;
import com.ezzy.gadsapp.models.Skill;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.ViewHolder>{

    private Context mContext;
    private Object object;
    private List<Learner> learnerList;
    private List<Skill> skillList;
    private List<Object> items;
    private Picasso.Builder builder;
//    private int layout;
//    private int layoutType;

//    public BaseAdapter(Context context){
//        this.mContext = context;
//    }
//
//    public BaseAdapter(Context mContext, int layout, int layoutType) {
//        this(mContext);
//        this.layout = layout;
//        this.layoutType = layoutType;
//    }


    public BaseAdapter(Context mContext, Object object, List<Learner> learnerList) {
        this.mContext = mContext;
        this.object = object;
        this.learnerList = learnerList;
    }

    public BaseAdapter(Context mContext, List<Skill> skillList, Object object) {
        this.mContext = mContext;
        this.skillList = skillList;
        this.object = object;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.gads_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        items = new ArrayList<>();
        if (object == Learner.class){
            holder.nameTextView.setText(learnerList.get(position).getName());
            holder.descriptionTextView.setText(learnerList.get(position).getHours());
            builder = new Picasso.Builder(mContext);
            builder.downloader(new OkHttp3Downloader(mContext));
            builder.build().load(learnerList.get(position).getBadge_url())
                    .placeholder(R.drawable.learner)
                    .into(holder.badgeImageView);
        }
        if (object == Skill.class){
            holder.nameTextView.setText(skillList.get(position).getName());
            holder.descriptionTextView.setText(skillList.get(position).getSkills());
            builder= new Picasso.Builder(mContext);
            builder.downloader(new OkHttp3Downloader(mContext));
            builder.build().load(skillList.get(position).getBadge_url())
                    .placeholder(R.drawable.skill)
                    .into(holder.badgeImageView);
        }
    }

    @Override
    public int getItemCount() {
        int i = 0;
        if (object == Learner.class){
            i = learnerList.size();
        }
        if (object == Skill.class){
            i = skillList.size();
        }
        return i;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

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
