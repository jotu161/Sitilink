package com.example.group4;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class feedback extends AppCompatActivity
{
    RatingBar rt;
    EditText et;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        b=findViewById(R.id.send);
        rt=findViewById(R.id.ratingBar);
        LayerDrawable star= (LayerDrawable) rt.getProgressDrawable();
        star.getDrawable(2).setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
        et=findViewById(R.id.et_reg_review);
        b.setOnClickListener(view ->
        {
            String reviewTx=et.getText().toString();
            if(reviewTx.isEmpty())
            {
                Toast.makeText(this, "Field can not be empty!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "You Rated : "+String.valueOf(rt.getRating()), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(feedback.this, homesitilink.class);
                startActivity(i);
                finish();
            }
        });
    }
}