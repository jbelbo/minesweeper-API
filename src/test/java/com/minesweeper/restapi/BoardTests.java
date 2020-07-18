package com.minesweeper.restapi;

import com.minesweeper.restapi.model.Board;
import com.minesweeper.restapi.model.BoardParameters;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class BoardTests {

    private Board board;

    @BeforeAll
    public static void setUp() {
        //this.board = new Board();
    }

    @ParameterizedTest
    @MethodSource("provideParametersForBoardCreation")
    public void boardConstructor_createWithBoardParameters_returnsNewBoardAccordingToParameters(BoardParameters boardParameters) {
        var board = new Board(boardParameters);

        assertThat(board.getNumberOfColumns() == boardParameters.numberOfColumns);
        assertThat(board.getNumberOfRows() == boardParameters.numberOfRows);
        assertThat(board.getNumberOfMines() == boardParameters.numberOfMines);
    }

    private static Stream<Arguments> provideParametersForBoardCreation() {
        return Stream.of(
                Arguments.of(new BoardParameters(4,3, 2)),
                Arguments.of(new BoardParameters(1,1,1)),
                Arguments.of(new BoardParameters(10,20,30))
        );
    }
}
