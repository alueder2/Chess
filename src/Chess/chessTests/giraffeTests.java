package Chess.chessTests;

import Chess.chessLogic.Giraffe;
import Chess.chessLogic.Piece;
import Chess.chessLogic.extraPiecesBoard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aleclueders on 9/17/15.
 */
public class giraffeTests {

    /**
     * Ensures the functionality and moving is correct
     */
    @Test
    public void simpleGiraffeTest() {

        extraPiecesBoard board = new extraPiecesBoard();
        Piece whiteGiraffe = board.pieces[0][0];
        assert(whiteGiraffe instanceof Giraffe);

        whiteGiraffe.move(board, 1, 4);
        assertEquals(whiteGiraffe.getX(), 1);
        assertEquals(whiteGiraffe.getY(), 4);
    }
}
