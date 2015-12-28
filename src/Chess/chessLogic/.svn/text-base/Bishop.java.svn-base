/**
 * Created by aleclueders on 9/16/15.
 */
package Chess.chessLogic;

public class Bishop extends Piece {
    public Bishop(boolean alive, int color, int x, int y) {
        super(alive, color, x, y);
    }

    public void setCheck(boolean check) {
    }

    public boolean isInCheck() {
        return false;
    }

    /**
     * Ensures that the move requested is a diagonal move
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    public boolean isValidSpecificMove(Board board, int destX, int destY) {
        return Math.abs(destX - this.getX()) == Math.abs(destY - this.getY())?this.findDirection(board, destX, destY):false;
    }

    /**
     * Checks whether or not the requested move is within the Bishop's capabilities
     * @param board
     * @param destX
     * @param destY
     * @return
     */
    private boolean findDirection(Board board, int destX, int destY) {
        int myX = this.getX();
        int myY = this.getY();

        if (myX < destX && myY < destY && Math.abs(myX - destX) == Math.abs(myY - destY))
            return upAndRight(board, destX, destY);
        if (myX < destX && myY > destY && Math.abs(myX - destX) == Math.abs(myY - destY))
            return downAndRight(board, destX, destY);
        if (myX > destX && myY < destY && Math.abs(myX - destX) == Math.abs(myY - destY))
            return upAndLeft(board, destX, destY);
        if (myX > destX && myY > destY && Math.abs(myX - destX) == Math.abs(myY - destY))
            return downAndLeft(board, destX, destY);
        return false;
    }

    /**
     * Checks the up and right scenario
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean upAndRight(Board board, int destX, int destY) {
        int j = 1;

        for(int i = this.getX() + 1; i < destX; ++i) {
            Piece checkPiece = board.pieces[i][this.getY() + j];
            if(checkPiece != null) {
                return false;
            }

            ++j;
        }

        return true;
    }

    /**
     * Checks the down and right scenario
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean downAndRight(Board board, int destX, int destY) {
        byte j = 1;

        for(int i = this.getX() + 1; i < destX; ++i) {
            Piece checkPiece = board.pieces[i][this.getY() - j];
            if(checkPiece != null) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks the up and left scenario
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean upAndLeft(Board board, int destX, int destY) {
        for(int i = 1; i < Math.abs(destX - this.getX()); ++i) {
            Piece checkPiece = board.pieces[this.getX() - i][this.getY() + i];
            if(checkPiece != null) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks the down and left scenario
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean downAndLeft(Board board, int destX, int destY) {
        for(int i = 1; i < Math.abs(destX - this.getX()); ++i) {
            Piece checkPiece = board.pieces[this.getX() - i][this.getY() - i];
            if(checkPiece != null) {
                return false;
            }
        }

        return true;
    }
}
