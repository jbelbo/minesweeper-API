package com.minesweeper.restapi.event;

import com.minesweeper.restapi.model.Board;

import java.util.UUID;

public class AddQuestionMarkCellEvent extends BaseUpdateCellEvent {

    public AddQuestionMarkCellEvent(UUID boardId, UUID cellId) {
        super(boardId, cellId);
    }

    @Override
    public UUID getBoardId() {
        return null;
    }

    @Override
    public UUID getCellId() {
        return null;
    }

    @Override
    public void apply(Board board) {
        board.addQuestionMarkToCell(cellId);
    }
}
