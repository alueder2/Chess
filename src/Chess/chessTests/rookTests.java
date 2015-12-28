package Chess.chessTests;

import Chess.chessLogic.Board;
import Chess.chessLogic.Piece;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleclueders on 9/16/15.
 */


public class rookTests {
    public rookTests() {
    }

    /**
     * Ensures the rook can move and capture correctly
     */

    @Test
    public void simpleMoveAndCapture() {
        Board board = new Board();
        Piece whiteRook = board.pieces[0][0];

        whiteRook.move(board, 0, 1);
        assertEquals(whiteRook.getX(), 0);
        assertEquals(whiteRook.getY(), 0);

        Piece whitePawn = board.pieces[0][1];
        whitePawn.move(board, 0, 2);
        whitePawn.move(board, 0, 3);

        whiteRook.move(board, 0, 2);
        assertEquals(whiteRook.getX(), 0);
        assertEquals(whiteRook.getY(), 2);

        whiteRook.move(board, 0, 0);
        assertEquals(whiteRook.getX(), 0);
        assertEquals(whiteRook.getY(), 0);

        whiteRook.move(board, 0, 2);
        whiteRook.move(board, 7, 2);
        assertEquals(whiteRook.getX(), 7);
        assertEquals(whiteRook.getY(), 2);

        whiteRook.move(board, 7, 7);
        assertEquals(whiteRook.getX(), 7);
        assertEquals(whiteRook.getY(), 2);

        whiteRook.move(board, 7, 6);
        assertEquals(whiteRook.getX(), 7);
        assertEquals(whiteRook.getY(), 6);
    }
}