package com.example.group4;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class headeract extends AppCompatActivity
{
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://group4-f8035-default-rtdb.firebaseio.com/");
    TextView emltxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.header);
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
    /*public DatabaseReference getDatabaseReference() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                for(DataSnapshot User: snapshot.child("User").getChildren())
                {
                    final String getemail=User.child("email").getValue(String.class);
                    //emltxt.setText(getemail);
                    Toast.makeText(headeract.this,getemail, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
        return databaseReference;
    }*/
}
