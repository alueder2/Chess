package Chess.chessLogic;

/**
 * Created by aleclueders on 9/20/15.
 */
public class Player {
    public int myColor;
    private Piece[] myPieces;
    public String name;

    public Player(Board board, int color) {
        this.myColor = color;
        myPieces = new Piece[16];
        if (myColor == 0)
            this.initWhitePlayer(board);
        else
            this.initBlackPlayer(board);
    }

    private void initWhitePlayer(Board board) {
        for (int i = 0; i < 8; i++) {
            myPieces[i] = board.pieces[i][0];
        }
        for (int i = 0; i < 8; i++) {
            myPieces[i] = board.pieces[i][1];
        }
    }

    private void initBlackPlayer(Board board) {
        for (int i = 0; i < 8; i++) {
            myPieces[i] = board.pieces[i][7];
        }
        for (int i = 0; i < 8; i++) {
            myPieces[i] = board.pieces[i][6];
        }
    }

}
