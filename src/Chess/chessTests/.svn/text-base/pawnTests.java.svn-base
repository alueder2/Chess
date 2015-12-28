package Chess.chessTests;

import Chess.chessLogic.Board;
import Chess.chessLogic.Pawn;
import Chess.chessLogic.Piece;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleclueders on 9/16/15.
 */

public class pawnTests {
    public pawnTests() {
    }

    /**
     * Ensures the pawn can move correctly
     */
    @Test
    public void simpleMove() {
        Board board = new Board();
        Piece whitePawn = board.pieces[0][1];

        whitePawn.move(board, 0, 2);
        assertEquals(whitePawn.getX(), 0);
        assertEquals(whitePawn.getY(), 2);


        Piece shouldBeNull = board.pieces[0][1];
        assertEquals(shouldBeNull, null);

        whitePawn.move(board, 0, 1);
        assertEquals(whitePawn.getY(), 2);
    }

    /**
     * Ensures the pawn can capture correctly
     */

    @Test
    public void simpleCapture() {
        Board board = new Board();
        Piece whitePawn = board.pieces[0][1];

        whitePawn.move(board, 0, 2);
        whitePawn.move(board, 0, 3);
        whitePawn.move(board, 0, 4);
        whitePawn.move(board, 0, 5);
        whitePawn.move(board, 1, 6);

        assert board.pieces[1][6] instanceof Pawn;

        assertEquals(whitePawn.getX(), 1);
        assertEquals(whitePawn.getY(), 6);
    }
}