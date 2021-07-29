package com.example.application3;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Article> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<Article> articleData;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Article> listData) {
        super(context, resource, listData);
        this.context = context;
        this.layoutResourceId = resource;
        this.articleData = listData;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflator = ((Activity) context).getLayoutInflater();
            row = inflator.inflate(layoutResourceId, parent, false);
        }
        TextView tvTitle = (TextView) row.findViewById(R.id.custom_text1);
        TextView tvContent = (TextView) row.findViewById(R.id.custom_text2);

        tvTitle.setText(articleData.get(position).getTitle());
        tvContent.setText(articleData.get(position).getContent());
//        ImageView imageView = (ImageView) row.findViewById(R.id.custom_img);
//
//        try {
//            InputStream is = context.getAssets().open(articleData.get(position).getImgName());
//            Drawable d= Drawable.createFromStream(is, null);
//            imageView.setImageDrawable(d);
//        } catch (IOException e) {
//            Log.e("Error", "Error: " + e);
//        }
        return row;
    }
}
