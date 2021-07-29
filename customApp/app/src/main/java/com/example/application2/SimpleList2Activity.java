package com.example.application2;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application2.databinding.ActivitySimpleList2Binding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SimpleList2Activity extends AppCompatActivity {

    HashMapAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list2);

        LinkedHashMap<String, String> hashMapList = new LinkedHashMap<String, String>(2);
        for (int i = 0; i < 10; i++) {
            hashMapList.put("line1", "첫번째 출력 " + i + "번");
            hashMapList.put("line2", "두번째 출력 " + i + "번");
        }
        // HashMap key
        String[] from = {"line1", "line2"};
        // TextView id 값
        int[] to = {android.R.id.text1, R.id.text2};

        RecyclerView recyclerView = findViewById(R.id.simple_list2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HashMapAdapter(this, hashMapList);
        recyclerView.setAdapter(adapter);
    }

}