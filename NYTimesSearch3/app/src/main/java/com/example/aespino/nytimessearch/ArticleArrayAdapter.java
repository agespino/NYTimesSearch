package com.example.aespino.nytimessearch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by aespino on 6/20/16.
 */
public class ArticleArrayAdapter extends ArrayAdapter<Article> {
    public ArticleArrayAdapter(Context context, List<Article> articles){
        super(context, android.R.layout.simple_list_item_1, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Article article = this.getItem(position);

        if (convertView == null) {
            LayoutInflater inflater= LayoutInflater.from(getContext());
            convertView =  inflater.inflate(R.layout.item_article_result, parent, false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ivImage);
        imageView.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        tvTitle.setText(article.getHeadline());

        String thumbnail = article.getThumbNail();
        if(!TextUtils.isEmpty(thumbnail)){
            Picasso.with(getContext()).load(thumbnail).into(imageView);
        }
        else{
            Bitmap bMap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.nyt_logo);
            Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 200, 150, true);

            imageView.setImageBitmap(bMapScaled);
        }

        return convertView;
    }
}
