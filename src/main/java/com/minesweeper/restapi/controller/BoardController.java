package com.minesweeper.restapi.controller;

import com.minesweeper.restapi.model.Board;
import com.minesweeper.restapi.model.BoardParameters;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

// ToDo implement methods using persistence or in-memory list
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class BoardController {

    @GetMapping("/boards/{boardId}")
    public Board getBoardById(@PathVariable UUID boardId) {
        return new Board();
    }

    @PostMapping("/boards")
    public Board createBoard(@RequestBody BoardParameters boardParameters) {
        return new Board(boardParameters);
    }

    @PutMapping("/boards/{boardId}/cells/{cellId}")
    public Board updateCell(@PathVariable UUID boardId, @PathVariable UUID cellId) {
        return new Board();
    }
}
