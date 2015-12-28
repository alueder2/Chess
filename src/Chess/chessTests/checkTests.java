package Chess.chessTests;

import Chess.chessLogic.Board;
import Chess.chessLogic.Piece;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleclueders on 9/16/15.
 */

public class checkTests {

    /**
     * Tests check functionality by putting the king in check, then moving the piece away so that the
     * king is no longer in check
     */
    @Test
    public void simpleCheckTest() {
        Board board = new Board();

        Piece blackKing = board.pieces[4][7];
        assertEquals(blackKing.isInCheck(), false);

        Piece blackPawn = board.pieces[4][6];   // bring the black pawn out
        blackPawn.move(board, 4, 5);
        blackPawn.move(board, 4, 4);
        blackPawn.move(board, 4, 3);

        Piece whitePawn = board.pieces[7][1];   // get the white pawn out of the way
        whitePawn.move(board, 7, 2);
        whitePawn.move(board, 7, 3);

        Piece whiteRook = board.pieces[7][0];   // capture the black pawn, put the king in check
        whiteRook.move(board, 7, 2);
        whiteRook.move(board, 4, 2);
        whiteRook.move(board, 4, 3);

        assertEquals(blackKing.isInCheck(), true);

        whiteRook.move(board, 6, 3);    // move away so that the king is no longer in check

        assertEquals(blackKing.isInCheck(), false);
    }
}
