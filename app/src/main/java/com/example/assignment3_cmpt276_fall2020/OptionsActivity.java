package com.example.assignment3_cmpt276_fall2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        createRadioButtons();
    }

    private void createRadioButtons() {
        RadioGroup radioGroupBoardSize = (RadioGroup) findViewById(R.id.radioGroupBoardSize);
        RadioGroup radioGroupNumMines = (RadioGroup) findViewById(R.id.radioGroupNumMines);
        String[] board_sizes = getResources().getStringArray(R.array.board_sizes);
        int[] num_mines = getResources().getIntArray(R.array.num_mines);
        for(int i = 0; i < board_sizes.length;i++){
            RadioButton button = new RadioButton(this);
            button.setText(board_sizes[i]);
            button.setTextColor(Color.parseColor("#ffffff"));
            radioGroupBoardSize.addView(button);
        }
        for(int i = 0; i < num_mines.length;i++){
            RadioButton button = new RadioButton(this);
            button.setText(num_mines[i] + "");
            button.setTextColor(Color.parseColor("#ffffff"));
            radioGroupNumMines.addView(button);
        }
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, OptionsActivity.class);
    }
}
