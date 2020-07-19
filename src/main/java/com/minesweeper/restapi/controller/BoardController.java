package com.minesweeper.restapi.controller;

import com.minesweeper.restapi.event.*;
import com.minesweeper.restapi.model.Board;
import com.minesweeper.restapi.model.BoardParameters;
import com.minesweeper.restapi.model.UpdateCellParameters;
import com.minesweeper.restapi.service.BoardService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.UUID;

// ToDo implement methods using persistence or in-memory list
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/boards/{boardId}")
    public Board getBoardById(@PathVariable UUID boardId) {
        return boardService.getBoardById(boardId);
    }

    @PostMapping("/boards")
    @ResponseStatus(HttpStatus.CREATED)
    public Board createBoard(@RequestBody BoardParameters boardParameters) {
        return boardService.createBoard(boardParameters);
    }

    @PostMapping("/boards/{boardId}/events")
    public Board updateCell(@PathVariable UUID boardId, @RequestBody UpdateCellParameters parameters) throws Exception {
        UpdateCellEvent event;
        switch (parameters.type) {
            case REVEAL -> event = new RevealCellEvent(boardId, parameters.cellId);
            case ADD_FLAG -> event = new AddFlagCellEvent(boardId, parameters.cellId);
            case ADD_QUESTION_MARK -> event = new AddQuestionMarkCellEvent(boardId, parameters.cellId);
            default -> throw new Exception("Invalid event type");
        }

        return boardService.applyUpdateCellEvent(event);
    }
}
