package com.example.doodle.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Lengyuedong} on 2020/9/8.
 */

public class NewsTitleFragment extends Fragment {
    boolean isTwo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.news_title_frag, container, false);
        RecyclerView recyclerView = inflate.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter newsAdapter = new NewsAdapter(getNews());
        recyclerView.setAdapter(newsAdapter);
        return inflate;
    }

    private List<News> getNews() {
        List<News> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            News news = new News("tgis is tile " + i, "{this is contenty sn " + i);
            list.add(news);
        }
        return list;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null) {
            isTwo = true;
        } else {
            isTwo = false;
        }
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewholder> {
        List<News> myNewsList;

        public NewsAdapter(List<News> myNewsList) {
            this.myNewsList = myNewsList;
        }

        @NonNull
        @Override
        public NewsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,
                    parent, false);
            final NewsViewholder viewHolder = new NewsViewholder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = myNewsList.get(viewHolder.getAdapterPosition());
                    if (isTwo) {
                        NewsContentFragment newsContentFragment = (NewsContentFragment)
                                getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refreash(news.getTitle(), news.getContent());
                    } else {
                        NewsContentActivity.actionStart(getActivity(), news.getTitle(), news
                                .getContent());
                    }
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull NewsViewholder holder, int position) {
            holder.textView.setText(myNewsList.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return myNewsList.size();
        }

        class NewsViewholder extends RecyclerView.ViewHolder {
            TextView textView;

            public NewsViewholder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.news_title);
            }
        }
    }
}
