package com.example.application2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button_simple_list1);
        button2 = (Button) findViewById(R.id.button_simple_list2);
        button3 = (Button) findViewById(R.id.button_custom_list);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.button_simple_list1:
                Intent intentSimpleList1 = new Intent(this, SimpleList1Activity.class);
                startActivity(intentSimpleList1);
                break;
            case R.id.button_simple_list2:
                Intent intentSimpleList2 = new Intent(this, SimpleList2Activity.class);
                startActivity(intentSimpleList2);
                break;
            case R.id.button_custom_list:
                Intent intentCustomList = new Intent(this, CustomActivity.class);
                startActivity(intentCustomList);
                break;
        }
    }


}