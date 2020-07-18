package com.minesweeper.restapi.event;

import java.util.UUID;

public abstract class BaseUpdateCellEvent implements UpdateCellEvent {

    public UUID boardId;

    public UUID cellId;

    public BaseUpdateCellEvent(UUID boardId, UUID cellId) {
        this.boardId = boardId;
        this.cellId = cellId;
    };
}
