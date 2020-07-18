package com.minesweeper.restapi.event;

import com.minesweeper.restapi.model.Board;

import java.util.UUID;

public interface UpdateCellEvent {

    public UUID getBoardId();

    public UUID getCellId();

    public void apply(Board board);
}
