package com.example.group4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ticket extends AppCompatActivity {
    Button gen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        gen=findViewById(R.id.generate);
        gen.setOnClickListener(view ->
        {
            Intent i= new Intent(ticket.this,upipay.class);
            startActivity(i);
        });
    }
}