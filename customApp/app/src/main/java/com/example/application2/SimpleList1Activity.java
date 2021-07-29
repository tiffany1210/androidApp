package com.example.application2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SimpleList1Activity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list1);

        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("Data 1");
        arrayList1.add("Data 2");
        arrayList1.add("Data 3");
        arrayList1.add("Data 4");
        arrayList1.add("Data 5");
        arrayList1.add("Data 6");

        RecyclerView recyclerView = findViewById(R.id.simple_list2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, arrayList1);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " +
                position, Toast.LENGTH_LONG).show();
    }

}