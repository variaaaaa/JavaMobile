package com.example.rss_viewer;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rss_viewer.databinding.NewsItemBinding;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    TextView title, description, pubDate;

    NewsViewHolder(NewsItemBinding binding) {
        super(binding.getRoot());
        title = binding.title;
        description = binding.description;
        pubDate = binding.pubDate;
    }
}