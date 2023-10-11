package com.example.group4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class map extends AppCompatActivity {
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        i=findViewById(R.id.imageview);
        i.setImageResource(R.drawable.surat_city_map);
    }
}