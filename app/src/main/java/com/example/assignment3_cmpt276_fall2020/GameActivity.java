package com.example.assignment3_cmpt276_fall2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment3_cmpt276_fall2020.model.Cell;
import com.example.assignment3_cmpt276_fall2020.model.Game;
import com.example.assignment3_cmpt276_fall2020.model.Options;

public class GameActivity extends AppCompatActivity {

    Button buttons[][];
    Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_game);
        Options options = Options.getInstance();
        TextView overallMines = (TextView) findViewById(R.id.textFoundOverallMines);
        overallMines.setText("" + options.getNumMines());
        buttons = new Button[options.getRowCount()][options.getColCount()];
        game = new Game(options);
        populateButtons();
    }

    private void populateButtons() {
        Options options = Options.getInstance();
        int rows = options.getRowCount();
        int cols = options.getColCount();
        TableLayout table = (TableLayout) findViewById(R.id.tableButtons);
        for(int i = 0; i < rows; i++){
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tableRow);
            for(int j = 0; j < cols; j++){
                final int FINAL_ROW = i;
                final int FINAL_COL = j;
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));
                button.setPadding(0,0,0,0);
                button.setOnClickListener(v -> {
                        gridButtonClicked(FINAL_ROW, FINAL_COL);
                });
                tableRow.addView(button);
                buttons[i][j] = button;
            }
        }
    }

    private void gridButtonClicked(int row, int col) {
        Button button = buttons[row][col];
        lockButtonSizes();
        Cell cellPressed = game.getCell(row, col);

        if(!cellPressed.isRevealed()){
            cellPressed.setRevealed(true);
            if(cellPressed.isBomb()){
                int newWidth = button.getWidth();
                int newHeight = button.getHeight();
                Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mine);
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
                Resources resources = getResources();
                button.setBackground(new BitmapDrawable(resources, scaledBitmap ));
            }
        }

    }

    private void lockButtonSizes() {
        for(int i = 0; i < game.getRows(); i++){
            for(int j = 0; j < game.getCols(); j++){
                Button button = buttons[i][j];

                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);

                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);
            }
        }
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, GameActivity.class);
    }
}
