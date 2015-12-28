package Chess.chessTests;

import Chess.chessLogic.Board;
import Chess.chessLogic.Piece;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleclueders on 9/17/15.
 */
public class checkmateTests {

    /**
     * Primitive test to ensure that checkmate is working correctly. Moves pieces to checkmate and asserts that
     * checkmate is true
     */

    @Test
    public void checkmateTest() {
        Board board = new Board();

        Piece blackKing = board.pieces[4][7];
        Piece leftBlackPawn = board.pieces[3][6];
        Piece rightBlackPawn = board.pieces[5][6];

        Piece whiteQueen = board.pieces[3][0];
        Piece whiteBishop = board.pieces[5][0];
        Piece whitePawn = board.pieces[4][1];

        whitePawn.move(board, 4, 2);
        leftBlackPawn.move(board, 3, 5);
        rightBlackPawn.move(board, 5, 5);

        whiteQueen.move(board, 7, 4);
        whiteBishop.move(board, 1, 4);

        assertEquals(blackKing.isInCheck(), true);
        leftBlackPawn.move(board, 3, 4);

        assertEquals(board.checkmate, true);

    }

}
