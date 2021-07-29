package com.example.application2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ListData> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<ListData> listData;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<ListData> listData) {
        super(context, resource, listData);
        this.context = context;
        this.layoutResourceId = resource;
        this.listData = listData;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflator = ((Activity) context).getLayoutInflater();
            row = inflator.inflate(layoutResourceId, parent, false);
        }
        TextView tvText1 = (TextView) row.findViewById(R.id.custom_text1);
        TextView tvText2 = (TextView) row.findViewById(R.id.custom_text2);

        tvText1.setText(listData.get(position).getText1());
        tvText2.setText(listData.get(position).getText2());
        ImageView imageView = (ImageView) row.findViewById(R.id.custom_img);

        try {
//            InputStream is = context.getAssets().open(listData.get(position).getImgName());
//            Drawable d= Drawable.createFromStream(is, null);
            String imgNm = listData.get(position).getImgName();
            String uri = "@drawable/";

            int imageResource = context.getResources().getIdentifier(uri + imgNm, null, context.getPackageName());
            Drawable res = context.getResources().getDrawable(imageResource);
            imageView.setImageDrawable(res);
        } catch (Exception e) {
            Log.e("Error", "Error: " + e);
        }
        return row;
    }

}
