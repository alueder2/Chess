package Chess.chessTests;

import Chess.chessLogic.Piece;
import Chess.chessLogic.extraPiecesBoard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by aleclueders on 9/17/15.
 */
public class locustTests {

    /**
     * Ensures the locust can move and capture correctly
     */
    @Test
    public void locustTests() {
        extraPiecesBoard board = new extraPiecesBoard();

        Piece whiteLocust = board.pieces[2][0];
        whiteLocust.move(board, 4, 2);
        assertEquals(whiteLocust.getX(), 4);
        assertEquals(whiteLocust.getY(), 2);

        Piece blackPawn = board.pieces[3][6];
        blackPawn.move(board, 3, 5);
        blackPawn.move(board, 3, 4);
        blackPawn.move(board, 3, 3);
        assertEquals(blackPawn.getX(), 3);
        assertEquals(blackPawn.getY(), 3);

        whiteLocust.move(board, 2, 4);
        assertEquals(whiteLocust.getX(), 2);
        assertEquals(whiteLocust.getY(), 4);

        assertEquals(board.pieces[3][3], null);
    }
}
