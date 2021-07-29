package com.example.application2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;

public class HashMapAdapter extends RecyclerView.Adapter<HashMapAdapter.MainViewHolder> {
    private LinkedHashMap<String, String> mData;
    private String[] mKeys;
    private LayoutInflater mInflater;
    private MyRecyclerViewAdapter.ItemClickListener mClickListener;

    public HashMapAdapter(Context context, LinkedHashMap<String, String> data){
        mData  = data;
        mKeys = mData.keySet().toArray(new String[data.size()]);
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HashMapAdapter.MainViewHolder holder, int position) {
        String name = mData.get(mKeys[position]);
        holder.myTextView.setText(name);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

//    @Override
//    public View getView(int pos, View convertView, ViewGroup parent) {
//        String key = mKeys[pos];
//        String Value = getItem(pos).toString();
//
//        //do your view stuff here
//
//        return convertView;
//    }

    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        MainViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
