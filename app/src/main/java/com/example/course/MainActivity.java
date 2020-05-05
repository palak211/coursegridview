package com.example.course;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    GridView simpleListView;
    String[] courseNames =
            {"Djanjo", "Mobile App", " Learn Php", "C language","Java","Java Script","Html","Python"};
    int[] courseImages =
            {R.drawable.django, R.drawable.mobile, R.drawable.phpp,
                    R.drawable.clangc,R.drawable.javaj,R.drawable.js,
                    R.drawable.htmll,R.drawable.python};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleListView = (GridView) findViewById(R.id.grid1);

        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 1; i < courseNames.length; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", courseNames[i]);
            hashMap.put("image", courseImages[i] + "");
            arrayList.add(hashMap);
        }
        String[] from = {"name", "image"};
        int[] to = {R.id.tv1, R.id.imageView};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.layout, from, to);
        simpleListView.setAdapter(simpleAdapter);
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(getApplicationContext(),courseNames[i], Toast.LENGTH_LONG).show();
            }
        });


    }
}

