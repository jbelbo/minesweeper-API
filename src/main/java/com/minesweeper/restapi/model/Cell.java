package com.minesweeper.restapi.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.*;
import java.util.UUID;

@Entity
public class Cell {
    @Id
    private UUID id;

    private Point position = new Point();

    private int numberOfSurroundingMines;

    private Boolean isHidden;

    private Boolean hasMine;

    private Boolean hasFlag;

    private Boolean hasQuestionMark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
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

    @JsonGetter("isHidden")
    public Boolean isHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public Boolean hasMine() {
        return hasMine;
    }

    public void setMine(Boolean hasMine) {
        this.hasMine = hasMine;
    }

    @JsonGetter
    public Boolean hasFlag() {
        return hasFlag;
    }

    public void setFlag(Boolean hasFlag) {
        this.hasFlag = hasFlag;
    }

    @JsonGetter
    public Boolean hasQuestionMark() {
        return hasQuestionMark;
    }

    public void setQuestionMark(Boolean hasQuestionMark) {
        this.hasQuestionMark = hasQuestionMark;
    }

    @JsonIgnore
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Boolean isAdjacent(Cell cell) {
        return cell != this &&
                Math.abs(this.position.getX() - cell.position.getX()) <= 1 &&
                Math.abs(this.position.getY() - cell.position.getY()) <= 1;
    }
}
