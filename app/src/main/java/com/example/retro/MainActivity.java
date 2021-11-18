package com.example.retro;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import me.ibrahimsn.particle.ParticleView;

public class MainActivity extends AppCompatActivity {

    //private ParticleView particleView;

    ProgressBar splashProgress;

    private static int SPLASH_TIME_OUT = 2000;

  //  Button bt_click_me;

  /*  public void fade(View view){
        ImageView imageView = (ImageView) findViewById(R.id.logo1);
        imageView.animate().alpha(0).setDuration(2000);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashProgress = findViewById(R.id.splashProgress);
        playProgress();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent (MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);



    }

    private void playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 100)
                .setDuration(2000)
                .start();
    }
}