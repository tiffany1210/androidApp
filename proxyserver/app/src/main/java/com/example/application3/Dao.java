package com.example.application3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dao {
    private Context context;
    private SQLiteDatabase database;

    @SuppressLint("WrongConstant")
    public Dao(Context context) {
        this.context = context;
        //SQLite reset
        database = context.openOrCreateDatabase("LocalDATA.db", SQLiteDatabase.CREATE_IF_NECESSARY,
                null);
        try {
            String sql = "CREATE TABLE IF NOT EXISTS Articles(ID integer primary key autoincrement," +
                    "       ArticleNumber integer UNIQUE not null," +
                    "       Title text not null," +
                    "       WriterName text not null," +
                    "       WriterId text not null," +
                    "       Content text not null," +
                    "       WriteDate text not null," +
                    "       ImgName text UNIQUE not null);";
            database.execSQL(sql);
        } catch (Exception e) {
            Log.e("test", "CREATE TABLE FAILED! - " + e);
            e.printStackTrace();
        }
    }

    public void insertJsonData(String jsonData) {
        int articleNumber;
        String title;
        String writer;
        String id;
        String content;
        String writeDate;
        String imgName;
        try {
            JSONArray jArr = new JSONArray(jsonData);
            for (int i = 0; i < jArr.length(); ++i) {
                JSONObject jObj = jArr.getJSONObject(i);

                articleNumber = jObj.getInt("ArticleNumber");
                title = jObj.getString("Title");
                writer = jObj.getString("Writer");
                id = jObj.getString("Id");
                content = jObj.getString("Content");
                writeDate = jObj.getString("WriteDate");
                imgName = jObj.getString("ImgName");

                Log.i("test", "ArticleNumber: " + articleNumber + " Title:" + title);

                String sql = "INSERT INTO Articles(ArticleNumber, Title, WriterName, WriterID, Content, WriteDate, ImgName)"
                        +" VALUES(" + articleNumber + ", '" + title + "', '" + writer + "', '" + id + "', '"
                        + content + "', '" + writeDate + "', '" + imgName + "');";
                try {
                    database.execSQL(sql);
                } catch (SQLException e) {
                    Log.e("test", "DB ERROR! - " + e);
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            Log.e("test", "JSON ERROR! - " + e);
            e.printStackTrace();
        }
    }

    public ArrayList<Article> getArticleList() {
        ArrayList<Article> articleList = new ArrayList<Article>();
        int articleNumber;
        String title;
        String writer;
        String id;
        String content;
        String writeDate;
        String imgName;

        String sql = "SELECT * FROM Articles;";
        Cursor cursor = database.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            articleNumber = cursor.getInt(1);
            title = cursor.getString(2);
            writer = cursor.getString(3);
            id = cursor.getString(4);
            content = cursor.getString(5);
            writeDate = cursor.getString(6);
            imgName = cursor.getString(7);
            articleList.add(new Article(articleNumber, title, writer, id, content, writeDate, imgName));
        }
        cursor.close();

        return articleList;
    }

    /**
     * JSON????????? ?????? ????????? ??????????????????.
     * ??? ???????????? ????????? ????????????.
     * ArticleNumber - ????????? ??????X ??????
     * Title - ????????? ?????????
     * Writer - ?????????
     * Id - ?????????ID
     * Content - ?????????
     * WriteDate - ?????????
     * ImgName - ?????????
     */
    public String getJsonTestData() {

        StringBuilder sb = new StringBuilder();
        sb.append("");

        sb.append("[");

        sb.append("  {");
        sb.append("     'ArticleNumber':'1',");
        sb.append("     'Title':'????????????',");
        sb.append("     'Writer':'??????1',");
        sb.append("     'Id':'123456',");
        sb.append("     'Content':'happy birthday~',");
        sb.append("     'WriteDate':'2021-07-28 10:00',");
        sb.append("     'ImgName':'birthday.png'");
        sb.append("  },");
        sb.append("  {");
        sb.append("     'ArticleNumber':'2',");
        sb.append("     'Title':'?????? ?????? 3000??????',");
        sb.append("     'Writer':'????????? ??????',");
        sb.append("     'Id':'234567',");
        sb.append("     'Content':'????????????????????????. ?????????????????? ??????????????? ?????? 3000???????????? 30??? ?????? ???????????????????????????.',");
        sb.append("     'WriteDate':'2021-07-28 11:30',");
        sb.append("     'ImgName':'bank.png'");
        sb.append("  },");
        sb.append("  {");
        sb.append("     'ArticleNumber':'3',");
        sb.append("     'Title':'MAC ?????? ?????? ?????? ??????',");
        sb.append("     'Writer':'??????',");
        sb.append("     'Id':'345678',");
        sb.append("     'Content':'Macbook Pro ??????? Mac Mini ??????? iPad ???????',");
        sb.append("     'WriteDate':'2021-07-28 13:30',");
        sb.append("     'ImgName':'mac.png'");
        sb.append("  },");
        sb.append("  {");
        sb.append("     'ArticleNumber':'4',");
        sb.append("     'Title':'?????? ?????? ?????????',");
        sb.append("     'Writer':'Olaf',");
        sb.append("     'Id':'456789',");
        sb.append("     'Content':'I like warm hugs!!',");
        sb.append("     'WriteDate':'2021-07-28 14:00',");
        sb.append("     'ImgName':'olaf.png'");
        sb.append("  }");

        sb.append("]");

        return sb.toString();
    }
}
