package com.example.group4;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity
{
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://group4-f8035-default-rtdb.firebaseio.com/");
    EditText password,userid;
    TextView registerNowBtn,forgpsw;
    Button reg_submit;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userid=findViewById(R.id.et_reg_uid);
        password = findViewById(R.id.et_reg_psw);
        registerNowBtn = findViewById(R.id.registerNowBtn);
        forgpsw=findViewById(R.id.forpsw);
        mAuth=FirebaseAuth.getInstance();
        reg_submit = findViewById(R.id.reg_submit);
        reg_submit.setOnClickListener(v ->
                loginuser());
        registerNowBtn.setOnClickListener(view ->
                startActivity(new Intent(login.this,signup.class)));
        forgpsw.setOnClickListener(view ->
                startActivity(new Intent(login.this,forgetpsw.class)));
    }
    private void loginuser()
    {
        String us=userid.getText().toString();
        String psw=password.getText().toString();
        if(TextUtils.isEmpty(us))
        {
            userid.setError("userid can not be Empty");
            userid.requestFocus();
        }
        else if(TextUtils.isEmpty(psw))
        {
            password.setError("Password can not be empty");
            password.requestFocus();
        }
        else
        {
            databaseReference.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.hasChild(us))
                    {
                        final String getpassword=snapshot.child(us).child("pass").getValue(String.class);
                        assert getpassword != null;
                        if(getpassword.equals(psw))
                        {
                            Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login.this,homesitilink.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(login.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(login.this, "Error!!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}