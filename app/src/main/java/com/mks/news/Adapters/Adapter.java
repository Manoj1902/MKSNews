package com.mks.news.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mks.news.Activities.WebViewActivity;
import com.mks.news.Models.ModelClass;
import com.mks.news.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassArrayList;


    public Adapter(Context context, ArrayList<ModelClass> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item_layout, null, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(context, WebViewActivity.class);
                newIntent.putExtra("url", modelClassArrayList.get(position).getUrl());
                context.startActivity(newIntent);
            }
        });
                holder.mTime.setText("Publish At: "+modelClassArrayList.get(position).getPublishedAt());
                holder.mAuthor.setText("by: "+ modelClassArrayList.get(position).getAuthor());
                holder.mHeading.setText(modelClassArrayList.get(position).getTitle());
                holder.mContent.setText(modelClassArrayList.get(position).getDescription());
                Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mHeading, mContent, mAuthor, mTime;
        CardView cardView;
        ImageView newsImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mHeading = itemView.findViewById(R.id.textMainHeadline);
            mContent = itemView.findViewById(R.id.textMainContent);
            mAuthor = itemView.findViewById(R.id.textAuthor);
            mTime = itemView.findViewById(R.id.textPublishTime);
            cardView = itemView.findViewById(R.id.newsItemCardView);
            newsImage = itemView.findViewById(R.id.imageNewsPhoto);


        }
    }
}
