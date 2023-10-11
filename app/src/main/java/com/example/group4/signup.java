package com.example.group4;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
public class signup extends AppCompatActivity
{
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://group4-f8035-default-rtdb.firebaseio.com/");
    EditText email,mob,pass,cpass,userid;
    Button submit;
    CheckBox terms;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        userid = findViewById(R.id.et_reg_uid);
        email = findViewById(R.id.et_reg_email);
        mob = findViewById(R.id.et_reg_mob);
        pass = findViewById(R.id.et_reg_psw);
        cpass = findViewById(R.id.et_reg_pswconf);
        terms = findViewById(R.id.reg_terms);
        mAuth = FirebaseAuth.getInstance();
        submit = findViewById(R.id.reg_submit);
        submit.setOnClickListener(v ->
                createUser());
    }
    private void createUser()
    {
        String us=userid.getText().toString();
        String mn=mob.getText().toString();
        String eml=email.getText().toString();
        String psw=pass.getText().toString();
        String cpsw=cpass.getText().toString();
        if(TextUtils.isEmpty(us)||TextUtils.isEmpty(eml)||TextUtils.isEmpty(psw)||TextUtils.isEmpty(mn)||TextUtils.isEmpty(cpsw))
        {
            Toast.makeText(this, "Fields can not be empty!!", Toast.LENGTH_SHORT).show();
        }
        else if(!psw.matches(cpsw))
        {
            Toast.makeText(signup.this,"Password are not matching",Toast.LENGTH_SHORT).show();
        }
        else
        {
            databaseReference.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot)
                {
                    if(snapshot.hasChild(us))
                    {
                        Toast.makeText(signup.this,"User is already registered",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        databaseReference.child("User").child(us).child("email").setValue(eml);
                        databaseReference.child("User").child(us).child("Phone").setValue(mn);
                        databaseReference.child("User").child(us).child("pass").setValue(psw);
                        Toast.makeText(signup.this,"User registered successfully",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(signup.this,login.class);
                        startActivity(i);
                        finish();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {}
            });
        }
    }

}