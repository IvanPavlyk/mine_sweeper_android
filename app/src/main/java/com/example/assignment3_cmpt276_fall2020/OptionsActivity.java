package com.example.assignment3_cmpt276_fall2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.assignment3_cmpt276_fall2020.model.Options;

/**
 * OptionsActivity class represents the options screen that saves the game state between executions
 * of the app through SharedPreferences. Contains two radio groups, one representing the board size
 * of the game and the other representing the number of mines hidden on the game board.
 */
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
            button.setOnClickListener(v -> {
                String message = button.getText().toString();
                String[] numbers = message.replaceAll("^\\D+","").split("\\D+");
                Options options = Options.getInstance();
                options.setRowCount(Integer.parseInt(numbers[0]));
                options.setColCount(Integer.parseInt(numbers[1]));
                saveRowsAndCols(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
            });

            radioGroupBoardSize.addView(button);

            String message = button.getText().toString();
            String[] numbers = message.replaceAll("^\\D+","").split("\\D+");
            int rowCount = Integer.parseInt(numbers[0]);
            int colCount = Integer.parseInt(numbers[1]);
            if(rowCount == getRowsSaved(this) && colCount == getColsSaved(this)){
                button.setChecked(true);
            }
        }
        for(int i = 0; i < num_mines.length;i++){
            RadioButton button = new RadioButton(this);
            button.setText(num_mines[i] + "");
            button.setTextColor(Color.parseColor("#ffffff"));
            button.setOnClickListener(v -> {
                String message = button.getText().toString();
                Options options = Options.getInstance();
                options.setNumMines(Integer.parseInt(message));
                saveNumMines(Integer.parseInt(message));
            });

            radioGroupNumMines.addView(button);
            String message = button.getText().toString();
            int numMines = Integer.parseInt(message);
            if(numMines == getNumMinesSaved(this)){
                button.setChecked(true);
            }

        }
    }

    private void saveNumMines(int numMines) {
        SharedPreferences prefs = this.getSharedPreferences("numMinesPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("NumMines", numMines);
        editor.apply();
    }

    private void saveRowsAndCols(int row, int col) {
        SharedPreferences prefs = this.getSharedPreferences("rowsColsPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Rows", row);
        editor.putInt("Cols", col);
        editor.apply();
    }

    static public int getNumMinesSaved(Context context){
        SharedPreferences prefs = context.getSharedPreferences("numMinesPrefs", MODE_PRIVATE);
        int defaultValue = context.getResources().getInteger(R.integer.default_num_mines);
        return prefs.getInt("NumMines", defaultValue);
    }

    static public int getRowsSaved(Context context){
        SharedPreferences prefs = context.getSharedPreferences("rowsColsPrefs", MODE_PRIVATE);
        int defaultValue = context.getResources().getInteger(R.integer.default_rows);
        return prefs.getInt("Rows", defaultValue);
    }
    static public int getColsSaved(Context context){
        SharedPreferences prefs = context.getSharedPreferences("rowsColsPrefs", MODE_PRIVATE);
        int defaultValue = context.getResources().getInteger(R.integer.default_cols);
        return prefs.getInt("Cols", defaultValue);
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, OptionsActivity.class);
    }
}
