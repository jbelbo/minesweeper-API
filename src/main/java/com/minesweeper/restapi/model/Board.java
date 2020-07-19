package com.minesweeper.restapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Board {
    @Id
    private UUID id;

    private int numberOfRows;

    private int numberOfColumns;

    private int numberOfMines;

    private BoardStatus status;

    private Date createdAt;

    private Date finishedAt;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cell> cells = new ArrayList<>();

    public Board() {}

    public Board(BoardParameters parameters) {
        this.id = UUID.randomUUID();
        this.numberOfRows = parameters.numberOfRows;
        this.numberOfColumns = parameters.numberOfColumns;
        this.numberOfMines = parameters.numberOfMines;
        this.status = BoardStatus.PLAYING;
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

    public BoardStatus getStatus() {
        return status;
    }

    public void setStatus(BoardStatus status) {
        this.status = status;
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

    public void addCell(Cell cell) {
        this.cells.add(cell);
        cell.setBoard(this);
    }

    public void removeCell(Cell cell) {
        this.cells.remove(cell);
        cell.setBoard(null);
    }

    // ToDo check if the responsibility of revealing a cell belongs to the Board
    public void revealCell(UUID cellId) {
        var cell = getCellById(cellId);
        uncoverCell(cell);
    }

    public void flagCell(UUID cellId) {
        var cell = getCellById(cellId);

        if (!cell.hasFlag()) {
            cell.setFlag(true);
        }
    }

    public void addQuestionMarkToCell(UUID cellId) {
        var cell = getCellById(cellId);

        if (!cell.hasQuestionMark()) {
            cell.setQuestionMark(true);
        }
    }

    private List<Cell> getNeighborCells(Cell cell) {
        return this.cells.stream().filter(cell::isAdjacent).collect(Collectors.toList());
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
                var cell = new Cell(column, row, false);
                cell.setBoard(this);
                this.cells.add(cell);
            }
        }
    }

    // ToDo improve mine setting so the returned collection is ordered

    private void setMines() {
        Collections.shuffle(this.cells);
        this.cells.stream().limit(this.numberOfMines).forEach(cell -> cell.setMine(true));
    }

    private void setSurroundingMinesNumber() {
        this.cells.stream()
                .filter(cell-> !cell.hasMine())
                .forEach(cell -> cell.setNumberOfSurroundingMines(countSurroundingMines(cell)));
    }

    // ToDo avoid casting long to int or limit the size of the board
    private int countSurroundingMines(Cell currentCell) {
        return (int) cells.stream().filter(cell -> currentCell.isAdjacent(cell) && cell.hasMine()).count();
    }

    private Cell getCellById(UUID cellId) {
        return this.getCells().stream()
                .filter(cell -> cell.getId().equals(cellId))
                .findFirst().orElseThrow();
    }

    private void uncoverCell(Cell cell) {
        if (cell.hasMine()) {
            markBoardAs(BoardStatus.LOST);
            return;
        }
        if (!cell.isHidden()) {
            return;
        }

        cell.setHidden(false);
        if (!areThereStillCellsToReveal()) {
            markBoardAs(BoardStatus.WON);
            return;
        }

        if (0 == cell.getNumberOfSurroundingMines()) {
            List<Cell> neighborCells = getNeighborCells(cell);
            neighborCells.stream()
                    .filter(neighborCell -> 0 == neighborCell.getNumberOfSurroundingMines())
                    .forEach(this::uncoverCell);
        }
    }

    private void markBoardAs(BoardStatus status) {
        this.setStatus(status);
        if (status.equals(BoardStatus.WON) || status.equals(BoardStatus.LOST)) {
            this.setFinishedAt(new Date());
            revealAllCells();
        }
    }

    // ToDo reveal only hidden cells
    private void revealAllCells() {
        this.cells.forEach(cell -> cell.setHidden(false));
    }

    private Boolean areThereStillCellsToReveal() {
        long count = this.cells.stream()
                .filter(cell -> cell.isHidden() && !cell.hasMine())
                .count();

        return count != 0;
    }
}
