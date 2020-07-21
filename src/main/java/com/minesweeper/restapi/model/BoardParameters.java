package com.minesweeper.restapi.model;

public class BoardParameters {

    public int numberOfRows;

    public int numberOfColumns;

    public int numberOfMines;

    public String username;

    public BoardParameters(int numberOfColumns, int numberOfRows, int numberOfMines, String username) {
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        this.numberOfMines = numberOfMines;
        this.username = username;
    }
}
