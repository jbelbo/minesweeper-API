package com.minesweeper.restapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Board {

    private UUID id;

    private int numberOfRows;

    private int numberOfColumns;

    private int numberOfMines;

    private Date createdAt;

    private Date finishedAt;

    private List<Cell> cells = new ArrayList<>();

    public Board() {}

    public Board(BoardParameters parameters) {
        this.id = UUID.randomUUID();
        this.numberOfRows = parameters.numberOfRows;
        this.numberOfColumns = parameters.numberOfColumns;
        this.numberOfMines = parameters.numberOfMines;
        this.createdAt = new Date();
        this.initializeBoard();
    }

    private void initializeBoard() {

    }

    public UUID getId() {
        return id;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }


    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
    }

    public List<Cell> getCells() {
        return cells;
    }
}
