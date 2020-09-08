package com.example.doodle.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ${Lengyuedong} on 2020/9/8.
 */

public class NewsContentFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag, container, false);
        return view;
    }

    public void refreash(String title, String content) {

        view.findViewById(R.id.visibility_layout).setVisibility(View.VISIBLE);
        ((TextView) view.findViewById(R.id.news_title)).setText(title);
        ((TextView) view.findViewById(R.id.news_content)).setText(content);
    }
}
