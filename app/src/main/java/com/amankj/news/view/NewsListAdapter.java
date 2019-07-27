package com.amankj.news.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.amankj.news.R;
import com.amankj.news.common.Article;
import com.amankj.news.common.DateUtil;
import com.bumptech.glide.Glide;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsItemHolder> {
    private static final String TAG = NewsListAdapter.class.getSimpleName();

    private Context context;
    private List<Article> articleList;

    public NewsListAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public NewsItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");

        View view = LayoutInflater.from(context).inflate(R.layout.news_list_item, parent, false);
        return new NewsItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListAdapter.NewsItemHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder");

        final Article article = articleList.get(position);

        holder.newsListItemText.setText(article.getTitle().trim());
        String publishTime = DateUtil.formatUTCDateToLocal(article.getPublishedAt().trim(),
                DateUtil.YYYY_MM_DD_T_HH_MM_SS_Z, DateUtil.MMM_DD_YYYY_HH_MM_A);
        holder.publishTimeText.setText(publishTime);
        Glide.with(context)
                .load(article.getUrlToImage())
                .into(holder.newsListItemImage);

        holder.newsItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick");
                startNewsWebActivity(article.getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount");

        return articleList.size();
    }

    class NewsItemHolder extends RecyclerView.ViewHolder {
        LinearLayout newsItemLayout;
        TextView newsListItemText;
        ImageView newsListItemImage;
        TextView publishTimeText;

        NewsItemHolder(@NonNull View itemView) {
            super(itemView);

            newsItemLayout = itemView.findViewById(R.id.news_item_layout);
            newsListItemText = itemView.findViewById(R.id.news_list_item_text);
            newsListItemImage = itemView.findViewById(R.id.news_list_item_image);
            publishTimeText = itemView.findViewById(R.id.publish_time_text);
        }
    }

    private void startNewsWebActivity(String url) {
        Log.d(TAG, "startNewsWebActivity");

        Intent intent = new Intent(context, NewsWebViewActivity.class);
        intent.putExtra("url", url);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
