package com.example.assignment3_cmpt276_fall2020.model;

import java.util.Random;

public class Game {
    private Cell[][] grid;
    private int rows, cols, numMinesOverall, numScans, numMinesRevealed;

    public Game(Options options){
        rows = options.getRowCount();
        cols = options.getColCount();
        numMinesOverall = options.getNumMines();
        numScans = 0;
        numMinesRevealed = 0;
        grid = new Cell[rows][cols];
        populateGrid();
    }

    public void populateGrid(){
        int tempMines = numMinesOverall;
        Random rand = new Random();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                grid[i][j] = new Cell(i,j);
            }
        }
        while(tempMines > 0){
            int randRow = rand.nextInt(rows);
            int randCol = rand.nextInt(cols);
            if(!grid[randRow][randCol].isBomb()){
                grid[randRow][randCol].setBomb(true);
                tempMines--;
            }
        }
    }

    public Cell getCell(int row, int col){
        return grid[row][col];
    }

    public int getRows(){
        return rows;
    }
    public int getCols(){
        return cols;
    }

}
