package com.minesweeper.restapi.event;

import com.minesweeper.restapi.model.Board;

import java.util.UUID;

public class RevealCellEvent extends BaseUpdateCellEvent {

    public RevealCellEvent(UUID boardId, UUID cellId) {
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
        board.revealCell(this.cellId);
    }
}
