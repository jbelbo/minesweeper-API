package com.minesweeper.restapi.controller;

import com.minesweeper.restapi.model.Board;
import com.minesweeper.restapi.model.BoardParameters;
import com.minesweeper.restapi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Board createBoard(@RequestBody BoardParameters boardParameters) {
        return boardService.createBoard(boardParameters);
    }

    @PutMapping("/boards/{boardId}/cells/{cellId}")
    public Board updateCell(@PathVariable UUID boardId, @PathVariable UUID cellId) {
        return new Board();
    }
}
