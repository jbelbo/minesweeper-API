package com.minesweeper.restapi;

import com.minesweeper.restapi.model.Board;
import com.minesweeper.restapi.model.BoardParameters;
import com.minesweeper.restapi.model.BoardStatus;
import com.minesweeper.restapi.model.Cell;
import org.junit.jupiter.api.BeforeAll;
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

    @ParameterizedTest
    @MethodSource("provideParametersForBoardCreation")
    public void revealCell_cellHasMine_returnsBoardWithStatusLost(BoardParameters boardParameters) {
        var board = new Board(boardParameters);
        var cellWithMine = board.getCells().stream()
                .filter(Cell::hasMine).findFirst();

        board.revealCell(cellWithMine.get().getId());

        assertThat(BoardStatus.LOST == board.getStatus());
    }

    @ParameterizedTest
    @MethodSource("provideParametersForBoardCreation")
    public void revealCell_allCellsWithoutMinesRevealed_returnsBoardWithStatusWon(BoardParameters boardParameters) {
        var board = new Board(boardParameters);

        board.getCells().forEach(cell -> {
            if (!cell.hasMine()) {
                board.revealCell(cell.getId());
            }
        });

        assertThat(BoardStatus.WON == board.getStatus());
    }

    private static Stream<Arguments> provideParametersForBoardCreation() {
        return Stream.of(
                Arguments.of(new BoardParameters(8,8, 15, "User")),
                Arguments.of(new BoardParameters(4,3, 2, "User")),
                Arguments.of(new BoardParameters(1,1,1, "User")),
                Arguments.of(new BoardParameters(10,20,30, "User"))
        );
    }
}
