package com.example.aespino.nytimessearch.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.aespino.nytimessearch.Article;
import com.example.aespino.nytimessearch.R;

import org.parceler.Parcels;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Article article = Parcels.unwrap(getIntent().getParcelableExtra("article"));

        WebView webView = (WebView)findViewById(R.id.wvArticle);

        assert webView != null;
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;

            }
        });
        webView.loadUrl(article.getWebUrl());

    }
}
