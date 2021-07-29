package com.example.application2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<ListData> listDataArray = new ArrayList<ListData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        ListData data1 = new ListData("1 부엉이", "1 owl", "owl");
        listDataArray.add(data1);

        ListData data2 = new ListData("2 퍼즐", "2 puzzle", "push");
        listDataArray.add(data2);
        ListData data3 = new ListData("3 고기", "3 rib", "rib");
        listDataArray.add(data3);
        ListData data4 = new ListData("4 오리", "4 ducks", "ducks");
        listDataArray.add(data4);
//        ListData data1 = new ListData("1-헬로키티", "1-hello kitty", "hellokitty.jpg");
//        listDataArray.add(data1);
//        ListData data2 = new ListData("2-올라프", "2-olaf", "img2.png");
//        listDataArray.add(data2);
//        ListData data3 = new ListData("3-라푼젤", "3-rapunzel", "img3.png");
//        listDataArray.add(data3);
//        ListData data4 = new ListData("4-심", "4-simba", "img4.png");
//        listDataArray.add(data4);
//        ListData data5 = new ListData("5-토끼", "5-rabbit", "img5.png");
//        listDataArray.add(data5);
//        ListData data6 = new ListData("6-포키", "6-forky", "img6.png");
//        listDataArray.add(data6);
//        ListData data7 = new ListData("7-엘사", "7-elsa", "img7.png");
//        listDataArray.add(data7);

        ListView listView = (ListView) findViewById(R.id.custom_listView);
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.custom_list_row, listDataArray);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Log.i("TEST", position + "번 캐릭터 선택됨");
        Log.i("TEST", "리스트 내용: " + listDataArray.get(position).getText1());
    }

}