package com.example.retro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.contentcapture.DataRemovalRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    Button sign;
    FirebaseAuth firebaseAuth;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firebaseAuth=FirebaseAuth.getInstance();
        db= FirebaseDatabase.getInstance().getReference();
        sign=findViewById(R.id.signupbtn2);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createuser();
            }
        });
    }
    void addPntoDb(){
        String email=((EditText)findViewById(R.id.emailEditText2)).getText().toString();
        String pn=((EditText)findViewById(R.id.phno)).getText().toString();
        String uid=firebaseAuth.getUid().toString();
        db.child("Users").child(uid).child("email").setValue(email);
        db.child("Users").child(uid).child("pn").setValue(pn).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
            }
        });
    }
    void createuser(){
        String email=((EditText)findViewById(R.id.emailEditText2)).getText().toString();
        String pass=((EditText)findViewById(R.id.passwordEditText2)).getText().toString();
        String pn=((EditText)findViewById(R.id.phno)).getText().toString();
        if(!email.isEmpty() && !pass.isEmpty()){
            firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext()," Registered successful",Toast.LENGTH_SHORT).show();
                        addPntoDb();
                    }
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(),"Please enter valid details",Toast.LENGTH_SHORT).show();
        }

    }
}
