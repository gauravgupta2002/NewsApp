package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    NewsHeadlines headlines;
    TextView txt_title, txt_author, txt_time, txt_details, txt_content;
    ImageView img_news;
    Button burl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_detail_author);
        txt_time = findViewById(R.id.text_detail_time);
        txt_details = findViewById(R.id.text_detail_detail);
        txt_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_detail_news);

        burl = findViewById(R.id.text_detail_url);
        burl.setOnClickListener(this);

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_time.setText(headlines.getPublishedAt());
        txt_details.setText(headlines.getDescription());
        txt_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(headlines.getUrl()));
        startActivity(i);
    }
}