package com.example.retro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.core.SyncTree;

import me.ibrahimsn.particle.ParticleView;

public class HomeActivity extends AppCompatActivity {

    private Button btn;



    private ParticleView particleView;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth=FirebaseAuth.getInstance();
        checkuser();
        btn = findViewById(R.id.loginbtn);
        Button sbtn = findViewById(R.id.signupbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMain2ActivityTwo();
            }
        });
        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,signup.class);
                startActivity(intent);
            }
        });

        particleView = findViewById(R.id.particleView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        particleView.resume();
    }

    @Override
    protected void  onPause() {
        super.onPause();
        particleView.pause();
    }
 void checkuser(){
        if(firebaseAuth.getCurrentUser()!=null){
            Intent intent = new Intent(HomeActivity.this,Main2Activity.class);
            startActivity(intent);
        }
 }
   private void moveToMain2ActivityTwo(){
        String email=((EditText)findViewById(R.id.emailEditText)).getText().toString();
        String pass=((EditText)findViewById(R.id.passwordEditText)).getText().toString();
        if(!email.isEmpty() && !pass.isEmpty()){
            firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_SHORT).show();
                        checkuser();

                    }
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(),"Please enter valid details",Toast.LENGTH_SHORT).show();
        }

    }


    //not used in activity_main
    public void fade(View view) {
    }
}