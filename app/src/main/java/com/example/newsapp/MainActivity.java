package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.newsapp.Models.NewsApiResponse;
import com.example.newsapp.Models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listner,"general",null);
    }

    private final OnFetchDataListner<NewsApiResponse> listner = new OnFetchDataListner<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            showNews(list);

        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this,list);
        recyclerView.setAdapter(adapter);
    }


}