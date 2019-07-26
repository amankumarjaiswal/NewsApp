package com.amankj.news.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.amankj.news.R;
import com.amankj.news.common.Article;

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

        Article article = articleList.get(position);

        holder.newsListItemText.setText(article.getTitle().trim());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount");

        return articleList.size();
    }

    class NewsItemHolder extends RecyclerView.ViewHolder {
        TextView newsListItemText;

        NewsItemHolder(@NonNull View itemView) {
            super(itemView);

            newsListItemText = itemView.findViewById(R.id.news_list_item_text);
        }
    }
}
