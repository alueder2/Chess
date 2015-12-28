/**
 * Created by aleclueders on 9/16/15.
 */
package Chess.chessTests;

        import Chess.chessLogic.Board;
        import Chess.chessLogic.Piece;
        import org.junit.Test;

        import static org.junit.Assert.assertEquals;

public class bishopTests {

    /**
     * Tests basic bishop move and capture functionality
     */

    @Test
    public void moveAndCapture() {
        Board board = new Board();

        Piece whitePawn = board.pieces[3][1];
        whitePawn.move(board, 3, 2);

        Piece whiteBishop = board.pieces[2][0];
        whiteBishop.move(board, 6, 4);

        assertEquals(whiteBishop.getX(), 6);
        assertEquals(whiteBishop.getY(), 4);

        whiteBishop.move(board, 2, 0);
        assertEquals(whiteBishop.getX(), 2);
        assertEquals(whiteBishop.getY(), 0);

        whiteBishop.move(board, 6, 4);
        whiteBishop.move(board, 4, 6);
        assertEquals(whiteBishop.getX(), 4);
        assertEquals(whiteBishop.getY(), 6);
    }
}