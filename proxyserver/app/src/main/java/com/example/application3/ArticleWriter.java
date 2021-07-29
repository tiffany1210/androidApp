package com.example.application3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ArticleWriter extends AppCompatActivity implements View.OnClickListener {

    private EditText etWriter;
    private EditText etTitle;
    private EditText etContent;
    private ImageButton imageButton;
    private Button uploadButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_writer);

        etWriter = (EditText) findViewById(R.id.edit_writer);
        etTitle = (EditText) findViewById(R.id.edit_title);
        etContent = (EditText) findViewById(R.id.edit_content);
        imageButton = (ImageButton) findViewById(R.id.edit_image);
        imageButton.setOnClickListener(this);

        uploadButton = (Button) findViewById(R.id.edit_button);
        uploadButton.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data ) {
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_button:
                new Thread() {
                    public void run() {
                        String DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.KOREA).format(new Date());
                        Article article = new Article(
                                0,
                                etTitle.getText().toString(),
                                etWriter.getText().toString(),
                                "1234567",
                                etContent.getText().toString(),
                                DATE,
                                "olaf.png");
                        ProxyUP proxyUP = new ProxyUP();
                        proxyUP.uploadArticle(article, "sample");
                    }
                }.start();
                break;
        }
    }

}