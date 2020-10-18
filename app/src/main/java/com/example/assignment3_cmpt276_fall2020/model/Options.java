package com.example.assignment3_cmpt276_fall2020.model;

/**
 * Options singleton class used to store the options configurations of the game chosen by the user
 * rowCount and colCount represent the row and column dimensions of the grid chosen by the user
 * numMines represents the number of mines that will be hidden on the grid
 * Options class is Singleton meaning that there will be only one instance of that class shared by
 * other classes.
 */
public class Options {
    private int rowCount, colCount;
    private int numMines;
    private static Options instance;
    private Options(){
        //Private to prevent anyone else from instantiating
    }

    public static Options getInstance(){
        if(instance == null){
            instance = new Options();
        }
        return instance;
    }

    public int getRowCount(){
        return rowCount;
    }
    public int getColCount(){
        return colCount;
    }
    public int getNumMines(){
        return numMines;
    }
    public void setRowCount(int rC){
        rowCount = rC;
    }
    public void setColCount(int cC){
        colCount = cC;
    }
    public void setNumMines(int nM){
        numMines = nM;
    }


}
