package com.minesweeper.restapi.model;

import java.util.*;

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

    private void initializeBoard()
    {
        createCells();
        setMines();
        setSurroundingMinesNumber();
    }

    private void createCells() {
        for (int column = 0; column < this.numberOfColumns; column++) {
            for (int row = 0; row < this.numberOfRows; row++) {
                this.cells.add(new Cell(column, row, false));
            }
        }
    }

    // ToDo improve mine setting so the returned collection is ordered
    private void setMines() {
        Collections.shuffle(this.cells);
        this.cells.stream().limit(this.numberOfMines).forEach(cell -> cell.setHasMine(true));
    }

    private void setSurroundingMinesNumber() {
        this.cells.stream()
                .filter(cell-> !cell.getHasMine())
                .forEach(cell -> cell.setNumberOfSurroundingMines(countSurroundingCells(cell)));

    }

    // ToDo avoid casting long to int or limit the size of the board
    private int countSurroundingCells(Cell currentCell) {
        return (int) cells.stream().filter(cell -> currentCell.isAdjacent(cell) && cell.getHasMine()).count();
    }
}
