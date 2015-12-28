package Chess.chessTests;

import Chess.chessLogic.Board;
import Chess.chessLogic.Piece;
import Chess.chessLogic.Queen;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleclueders on 9/16/15.
 */

public class queenTests {

    /**
     * Ensures the queen can move and capture correctly
     */

    @Test
    public void moveAndCapture() {
        Board board = new Board();

        Piece whitePawn = board.pieces[3][1];
        whitePawn.move(board, 3, 2);

        Piece whiteQueen = board.pieces[3][0];
        whiteQueen.move(board, 3, 1);

        assertEquals(whiteQueen.getX(), 3);
        assertEquals(whiteQueen.getY(), 1);

        whiteQueen.move(board, 7, 5);
        assertEquals(whiteQueen.getX(), 7);
        assertEquals(whiteQueen.getY(), 5);

        whiteQueen.move(board, 6, 6);
        assertEquals(whiteQueen.getX(), 6);
        assertEquals(whiteQueen.getY(), 6);

        Piece shouldBeQueen = board.pieces[6][6];

        assert shouldBeQueen instanceof Queen;

        whiteQueen.move(board, 4, 4);
        assertEquals(whiteQueen.getX(), 4);
        assertEquals(whiteQueen.getY(), 4);
    }
}
