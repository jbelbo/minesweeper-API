package com.minesweeper.restapi.repository;

import com.minesweeper.restapi.model.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BoardRepository extends CrudRepository<Board, UUID> {

    public List<Board> findByUsername(String username);
}
