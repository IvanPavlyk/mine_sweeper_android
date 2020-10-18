package com.example.assignment3_cmpt276_fall2020.model;

public class Cell {
    private int row, col;
    private boolean isBomb;
    private boolean isRevealed, isPressed;

    public Cell(int r, int c){
        row = r;
        col = c;
        isRevealed = false;
        isPressed = false;
        isBomb = false;
    }


    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }
}
