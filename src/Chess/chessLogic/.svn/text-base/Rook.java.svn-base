
/**
 * Created by aleclueders on 9/16/15.
 */
package Chess.chessLogic;

public class Rook extends Piece {
    public Rook(boolean alive, int color, int x, int y) {
        super(alive, color, x, y);
    }

    public boolean isValidSpecificMove(Board board, int destX, int destY) { //
        return this.findDirection(board, destX, destY); //
    }

    public void setCheck(boolean check) {
    }

    public boolean isInCheck() {
        return false;
    }

    /**
     * Checks to see if the move requested is one of the rook's possible moves, i.e. a straight line move
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean findDirection(Board board, int destX, int destY) {
        int myX = this.getX();
        int myY = this.getY();
        if (myX == destX && myY < destY)
            return checkUp(board, destX, destY);
        if (myX == destX && myY > destY)
            return checkDown(board, destX, destY);
        if (myX < destX && myY == destY)
            return checkRight(board, destX, destY);
        if (myX > destX && myY == destY)
            return checkLeft(board, destX, destY);
        return false;
    }

    /**
     * Scenario for the case in which the rook is moving up
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean checkUp(Board board, int destX, int destY) {
        for(int i = this.getY() + 1; i < destY; ++i) {
            Piece checkPiece = board.pieces[this.getX()][i];
            if(checkPiece != null) {
                return false;
            }
        }

        return true;
    }

    /**
     * Scenario for the case in which the rook is moving down
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean checkDown(Board board, int destX, int destY) {
        for(int i = this.getY() - 1; i > destY; --i) {
            Piece checkPiece = board.pieces[this.getX()][i];
            if(checkPiece != null) {
                return false;
            }
        }

        return true;
    }

    /**
     * Scenario for the case in which the rook is moving right
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean checkRight(Board board, int destX, int destY) {
        for(int i = this.getX() + 1; i < destX; ++i) {
            Piece checkPiece = board.pieces[i][this.getY()];
            if(checkPiece != null) {
                return false;
            }
        }

        return true;
    }

    /**
     * Scenario for the case in which the rook is moving left
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean checkLeft(Board board, int destX, int destY) {
        for(int i = this.getX() - 1; i > destX; --i) {
            Piece checkPiece = board.pieces[i][this.getY()];
            if(checkPiece != null) {
                return false;
            }
        }

        return true;
    }
}
