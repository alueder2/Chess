package Chess.chessTests;

import Chess.chessLogic.Board;
import Chess.chessLogic.Knight;
import Chess.chessLogic.Piece;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleclueders on 9/16/15.
 */

public class knightTests {

    /**
     * Tests basic functionality of the knight by both moving and capturing pieces
     */

    @Test
    public void moveAndCapture() {
        Board board = new Board();

        Piece whiteKnight = board.pieces[1][0];

        whiteKnight.move(board, 2, 2);
        assertEquals(whiteKnight.getX(), 2);
        assertEquals(whiteKnight.getY(), 2);

        whiteKnight.move(board, 2, 4);
        assertEquals(whiteKnight.getX(), 2);
        assertEquals(whiteKnight.getY(), 2);

        whiteKnight.move(board, 3, 4);
        assertEquals(whiteKnight.getX(), 3);
        assertEquals(whiteKnight.getY(), 4);

        whiteKnight.move(board, 4, 6);
        assertEquals(whiteKnight.getX(), 4);
        assertEquals(whiteKnight.getY(), 6);

        Piece shouldBeWhiteKnight = board.pieces[4][6];

        assert shouldBeWhiteKnight instanceof Knight;

        assertEquals(shouldBeWhiteKnight.getColor(), 0);
    }
}