package Chess.chessTests;

import Chess.chessLogic.Board;
import Chess.chessLogic.Piece;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleclueders on 9/16/15.
 */

public class kingTests {

    /**
     * Ensures the King moves correctly
     */

    @Test
    public void moveTest() {
        Board board = new Board();

        Piece whitePawn = board.pieces[4][1];
        whitePawn.move(board, 4, 2);

        Piece whiteKing = board.pieces[4][0];
        whiteKing.move(board, 4, 1);

        assertEquals(whiteKing.getX(), 4);
        assertEquals(whiteKing.getY(), 1);
    }
}
