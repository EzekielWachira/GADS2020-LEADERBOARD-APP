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
import com.ezzy.gadsapp.models.Skill;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.ViewHolder> {

    private List<Skill> skillList;
    private Context mContext;

    public SkillsAdapter(List<Skill> skillList, Context mContext) {
        this.skillList = skillList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.gads_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTextView.setText(skillList.get(position).getName());
        holder.skillsTextView.setText(skillList.get(position).getSkills());
        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.downloader(new OkHttp3Downloader(mContext));
        builder.build().load(skillList.get(position).getBadge_url())
                .placeholder(R.drawable.skill)
                .into(holder.badgeImageView);
    }

    @Override
    public int getItemCount() {
        return skillList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameTextView, skillsTextView;
        ImageView badgeImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            skillsTextView = itemView.findViewById(R.id.descTextView);
            badgeImageView = itemView.findViewById(R.id.badge);
        }
    }
}
