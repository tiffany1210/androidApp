package com.example.application3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView listView1;
    private ArrayList<Article> articleList;
    private Dao dao;
    private CustomAdapter customAdapter;
    private final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button writebtn = (Button) findViewById(R.id.button_write);
        Button refreshbtn = (Button) findViewById(R.id.button_refresh);

        writebtn.setOnClickListener(this);
        refreshbtn.setOnClickListener(this);
        listView1 = (ListView) findViewById(R.id.custom_listView);

        dao = new Dao(getApplicationContext());

        refreshData();

    }

    private void refreshData() {
        new Thread() {
            public void run() {
                Proxy proxy = new Proxy();
                String jsonData = proxy.getJSON();
                Log.i("test2", jsonData);

                dao.insertJsonData(jsonData);

                handler.post(new Runnable() {
                   public void run() {
                       listView();
                   }
                });
            }
        }.start();
    }
    private void listView() {
        articleList = dao.getArticleList();
        customAdapter = new CustomAdapter(this, R.layout.custom_list_row, articleList);
        listView1.setAdapter(customAdapter);
        listView1.setOnItemClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_refresh:
                refreshData();
                break;
            case R.id.button_write:
                Intent intent = new Intent(this, ArticleWriter.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "You clicked " + customAdapter.getItem(i) + " on row number " +
                i, Toast.LENGTH_LONG).show();
    }
}