package Chess.chessTests;

import Chess.chessLogic.Board;
import Chess.chessLogic.King;
import Chess.chessLogic.Piece;
import Chess.chessLogic.Rook;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleclueders on 9/16/15.
 */

public class boardTests {

    /**
     * Simply tests that after the board is populated, the pieces are non-null and in the correct place
     */
    @Test
    public void populateBoard() {
        Board board = new Board();
        Piece whiteRook = board.pieces[0][0];
        Piece blackKing = board.pieces[4][7];

        assert whiteRook instanceof Rook;

        assertEquals(whiteRook.getColor(), 0);

        assert blackKing instanceof King;

        assertEquals(blackKing.getColor(), 1);
    }
}