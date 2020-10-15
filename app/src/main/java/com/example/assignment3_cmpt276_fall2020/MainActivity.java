package com.example.assignment3_cmpt276_fall2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.imageViewMine);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade);
        imageView.startAnimation(animation);
        Button btn = (Button) findViewById(R.id.buttonSkip);
        btn.setOnClickListener(v -> {
            //Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            Intent intent = MenuActivity.makeIntent(MainActivity.this);
            startActivity(intent);
            finish();
        });
        /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);*/
    }
}
