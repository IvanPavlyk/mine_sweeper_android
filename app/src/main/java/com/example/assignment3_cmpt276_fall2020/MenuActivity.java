package com.example.assignment3_cmpt276_fall2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button optionsButton = (Button) findViewById(R.id.buttonOptions);
        optionsButton.setOnClickListener(v -> {
            Intent intent = OptionsActivity.makeIntent(MenuActivity.this);
            startActivity(intent);
        });

        Button helpButton = (Button) findViewById(R.id.buttonHelp);
        helpButton.setOnClickListener(v -> {
            Intent intent = HelpActivity.makeIntent(MenuActivity.this);
            startActivity(intent);
        });

        Button gameButton = (Button) findViewById(R.id.buttonPlayGame);
        gameButton.setOnClickListener(v -> {
            Intent intent = GameActivity.makeIntent(MenuActivity.this);
            startActivity(intent);
        });
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, MenuActivity.class);
    }
}
