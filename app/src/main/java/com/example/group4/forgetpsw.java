package com.example.group4;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
public class forgetpsw extends AppCompatActivity
{
    Button forgetpsw;
    EditText textemail;
    private String email;
    FirebaseAuth emAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpsw);
        emAuth=FirebaseAuth.getInstance();
        textemail=findViewById(R.id.et_reg_email);
        forgetpsw=findViewById(R.id.reg_submit);
        forgetpsw.setOnClickListener(view -> validateData());
    }
    private void validateData()
    {
        email=textemail.getText().toString();
        if(email.isEmpty())
        {
            textemail.setError("Required");
        }
        else
        {
            forgetpassword();
        }
    }
    private void forgetpassword()
    {
        emAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
            if(task.isSuccessful())
            {
                Toast.makeText(forgetpsw.this, "Check your Email", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(forgetpsw.this,login.class));
                finish();
            }else
            {
                Toast.makeText(forgetpsw.this, "Error!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}