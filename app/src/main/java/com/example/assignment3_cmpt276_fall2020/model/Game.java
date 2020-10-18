package com.example.assignment3_cmpt276_fall2020.model;

import java.util.Random;

/**
 * Game class represents game logic of the Mine Searcher game, in particular, represents model of the game grid
 * which contains mines that user needs to find.
 * grid attribute is a 2 dimensional array of Cell objects that represents the game grid
 * rows and cols represent the number of rows and columns that grid has
 * numMinesOverall represent how many mines are hidden on the grid initially
 * numScans represents the number of scans user has made during this Game
 * numMinesRevealed represents the number of mines user revealed so far.
 */
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

    public int getInfoMines(int row, int col){
        int numMines = 0;
        for(int i = row; i >= 0; i--){
            if(!grid[i][col].isRevealed() && grid[i][col].isBomb())
                numMines++;
        }
        for(int i = row + 1; i < rows; i++){
            if(!grid[i][col].isRevealed() && grid[i][col].isBomb())
                numMines++;
        }
        for(int i = col - 1; i >= 0; i--){
            if(!grid[row][i].isRevealed() && grid[row][i].isBomb())
                numMines++;
        }
        for(int i = col + 1; i < cols; i++){
            if(!grid[row][i].isRevealed() && grid[row][i].isBomb())
                numMines++;
        }
        return numMines;
    }


    public int getNumScans() {
        return numScans;
    }

    public void setNumScans(int numScans) {
        this.numScans = numScans;
    }

    public int getNumMinesRevealed() {
        return numMinesRevealed;
    }

    public void setNumMinesRevealed(int numMinesRevealed) {
        this.numMinesRevealed = numMinesRevealed;
    }

    public int getNumMinesOverall(){
        return numMinesOverall;
    }
}
