package com.minesweeper.restapi.model;

import com.minesweeper.restapi.event.UpdateCellEventType;

import java.util.UUID;

public class UpdateCellParameters {
    public UUID cellId;

    public UpdateCellEventType type;
}
