package com.minesweeper.restapi.repository;

import com.minesweeper.restapi.model.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BoardRepository extends CrudRepository<Board, UUID> {
}
