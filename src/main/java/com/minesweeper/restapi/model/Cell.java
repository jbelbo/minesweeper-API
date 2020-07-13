package com.minesweeper.restapi.model;

import java.awt.*;
import java.util.UUID;

public class Cell {

    private UUID id;

    private Point position = new Point();

    private int numberOfSurroundingMines;

    private Boolean isHidden;

    private Boolean hasMine;

    private Boolean hasFlag;

    private Boolean hasQuestionMark;

    private Board board;

    public Cell() {}

    public Cell(int x, int y, Boolean hasMine) {
        this.id = UUID.randomUUID();
        this.position.x = x;
        this.position.y = y;
        this.isHidden = true;
        this.hasMine = hasMine;
        this.hasFlag = false;
        this.hasQuestionMark = false;
    }

    public UUID getId() {
        return id;
    }

    public Point getPosition() {
        return position;
    }

    public int getNumberOfSurroundingMines() {
        return numberOfSurroundingMines;
    }

    public void setNumberOfSurroundingMines(int numberOfSurroundingMines) {
        this.numberOfSurroundingMines = numberOfSurroundingMines;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public Boolean getHasMine() {
        return hasMine;
    }

    public void setHasMine(Boolean hasMine) {
        this.hasMine = hasMine;
    }

    public Boolean getHasFlag() {
        return hasFlag;
    }

    public void setHasFlag(Boolean hasFlag) {
        this.hasFlag = hasFlag;
    }

    public Boolean getHasQuestionMark() {
        return hasQuestionMark;
    }

    public void setHasQuestionMark(Boolean hasQuestionMark) {
        this.hasQuestionMark = hasQuestionMark;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
