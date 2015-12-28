package Chess.chessTests;

import Chess.chessLogic.Board;
import Chess.chessLogic.Piece;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleclueders on 9/23/15.
 */
public class undoTest {

    /**
     * Tests the undo function by moving a piece, undoing the move, and then asserting that the piece
     * is back from where it came
     */

    @Test
    public void undoTest() {
        Board board = new Board();

        Piece whitePawn = board.pieces[4][1];
        whitePawn.move(board, 4, 2);

        assertEquals(whitePawn.getX(), 4);
        assertEquals(whitePawn.getY(), 2);

        board.undo();

        assertEquals(whitePawn.getX(), 4);
        assertEquals(whitePawn.getY(), 1);

        board.undo();   // Empty stack, exception should be handled
    }
}
