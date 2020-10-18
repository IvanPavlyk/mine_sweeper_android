package com.example.assignment3_cmpt276_fall2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.assignment3_cmpt276_fall2020.model.Options;

import java.util.Timer;
import java.util.TimerTask;

/**
 * MenuActivity class represents Main menu screen from where user can go to the game screen,
 * options screen and to the help screen. All of those actions are bind to the corresponding
 * button presses.
 */
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
        Options options = Options.getInstance();
        options.setRowCount(OptionsActivity.getRowsSaved(this));
        options.setColCount(OptionsActivity.getColsSaved(this));
        options.setNumMines(OptionsActivity.getNumMinesSaved(this));
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, MenuActivity.class);
    }
}
