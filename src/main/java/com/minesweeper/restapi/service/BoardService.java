package com.minesweeper.restapi.service;

import com.minesweeper.restapi.model.Board;
import com.minesweeper.restapi.model.BoardParameters;
import com.minesweeper.restapi.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Board createBoard(BoardParameters parameters) {
        return boardRepository.save(new Board(parameters));
    }

    public Board getBoardById(UUID boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new EntityNotFoundException("Board with id " + boardId.toString() + " not found"));
    }
}
