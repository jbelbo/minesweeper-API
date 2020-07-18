package com.minesweeper.restapi.event;

import com.minesweeper.restapi.model.Board;

import java.util.UUID;

public class AddFlagCellEvent extends BaseUpdateCellEvent {
    public AddFlagCellEvent(UUID boardId, UUID cellId) {
        super(boardId, cellId);
    }

    @Override
    public UUID getBoardId() {
        return boardId;
    }

    @Override
    public UUID getCellId() {
        return cellId;
    }

    @Override
    public void apply(Board board) {
        board.flagCell(cellId);
    }
}
