package com.example.group4;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class demo extends AppCompatActivity
{
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://group4-f8035-default-rtdb.firebaseio.com/");
    TextView emltxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        emltxt=findViewById(R.id.yreml);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot User: snapshot.child("User").getChildren())
                {
                    final String getemail=User.child("email").getValue(String.class);
                    emltxt.setText(getemail);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}