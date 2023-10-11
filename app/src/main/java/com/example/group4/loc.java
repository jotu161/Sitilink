package com.example.group4;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loc extends AppCompatActivity
{
    EditText etSource,etdestination;
    Button btTrack;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc);
        etSource=findViewById(R.id.et_source);
        etdestination=findViewById(R.id.et_destination);
        btTrack=findViewById(R.id.bt_track);

        btTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sSource=etSource.getText().toString().trim();
                String sDestination=etdestination.getText().toString().trim();

                if(sSource.equals("") && sDestination.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter both location",Toast.LENGTH_SHORT).show();
                }
                else{
                    DisplayTrack(sSource,sDestination);
                }
            }

            private void DisplayTrack(String sSource, String sDestination)
            {
                //If the device does not have a map installed, the redirect it to play store
                try{
                    //When google map is installed, Initialize uri
                    Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/" +sDestination);
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                catch (ActivityNotFoundException e){
                    //when google map is not installes Initialize uri
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}