package com.example.assignment3_cmpt276_fall2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * MainActivity class represents the Welcome Screen that contains two animations of the title and
 * of the image in the middle, on the skip button skips the animations and advances to the MainMenu
 * screen. After first execution of the screen and advancement to the next screen this activity is
 * finished.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.imageViewMine);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade);
        imageView.startAnimation(animation);
        TextView textAppName = (TextView) findViewById(R.id.textAppName);
        textAppName.animate().rotationBy(720).setDuration(5000).start();
        Button btn = (Button) findViewById(R.id.buttonSkip);
        btn.setOnClickListener(v -> {
            //Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            Intent intent = MenuActivity.makeIntent(MainActivity.this);
            startActivity(intent);
            finish();
        });
    }
}
