package com.example.group4;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class user extends AppCompatActivity
{
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://group4-f8035-default-rtdb.firebaseio.com/");
    EditText uid,nm,em,birth,adc,govid,psw;
    Spinner occu;
    Button sub;
    FirebaseAuth usAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        uid=findViewById(R.id.et_reg_uid);
        nm=findViewById(R.id.et_reg_name);
        em=findViewById(R.id.et_reg_email);
        birth=findViewById(R.id.et_reg_dob);
        adc=findViewById(R.id.et_reg_id);
        govid=findViewById(R.id.et_reg_id2);
        psw=findViewById(R.id.et_reg_psw);
        occu=findViewById(R.id.et_reg_occ);
        usAuth=FirebaseAuth.getInstance();
        sub=findViewById(R.id.reg_submit);
        sub.setOnClickListener(view ->
                createuser());
    }
    private void createuser()
    {
        final String userTxt= uid.getText().toString();
        final String namelTxt = nm.getText().toString();
        final String birthTxt = birth.getText().toString();
        final String adharTxt = adc.getText().toString();
        final String govidTxt = govid.getText().toString();
        final String occuTxt = occu.getSelectedItem().toString();
        final String pswTxt = psw.getText().toString();
        final String emailTxt = em.getText().toString();

        if (userTxt.isEmpty()||emailTxt.isEmpty() || pswTxt.isEmpty() || occuTxt.isEmpty() || govidTxt.isEmpty() || adharTxt.isEmpty() || birthTxt.isEmpty() || namelTxt.isEmpty()) {
            Toast.makeText(user.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else
        {
            databaseReference.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(userTxt))
                    {
                        final String getuser=snapshot.child(userTxt).child("pass").getValue(String.class);
                        assert getuser != null;
                        if(getuser.equals(pswTxt))
                        {
                            databaseReference.child("User").child(userTxt).child(govidTxt).child("adhars").setValue(adharTxt);
                            databaseReference.child("User").child(userTxt).child(govidTxt).child("name").setValue(namelTxt);
                            databaseReference.child("User").child(userTxt).child(govidTxt).child("category").setValue(occuTxt);
                            databaseReference.child("User").child(userTxt).child(govidTxt).child("email").setValue(emailTxt);
                            databaseReference.child("User").child(userTxt).child(govidTxt).child("pass").setValue(pswTxt);
                            databaseReference.child("User").child(userTxt).child(govidTxt).child("birth").setValue(birthTxt);
                            Toast.makeText(user.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(user.this,homesitilink.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(user.this, "User already Registered", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(user.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {}
            });
        }
    }
}