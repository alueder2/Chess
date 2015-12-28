
/**
 * Created by aleclueders on 9/16/15.
 */
package Chess.chessLogic;

public class Queen extends Piece {
    public Queen(boolean alive, int color, int x, int y) {
        super(alive, color, x, y);
    }

    public boolean isValidSpecificMove(Board board, int destX, int destY) {
        return this.findDirection(board, destX, destY);
    }

    public void setCheck(boolean check) {
    }

    public boolean isInCheck() {
        return false;
    }

    /**
     * Checks to ensure that the move requested is one of the queen's possible moves, i.e. it is straight
     * in any direction, or diagonal in any direction
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
     * Scenario to check and make sure there are no pieces in the way for the up case
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
     * Scenario to check and make sure there are no pieces in the way for the down case
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
     * Scenario to check and make sure there are no pieces in the way for the right case
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
     * Scenario to check and make sure there are no pieces in the way for the left case
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

    /**
     * Scenario to check and make sure there are no pieces in the way for the up and right case
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
     * Scenario to check and make sure there are no pieces in the way for the down and right case
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean downAndRight(Board board, int destX, int destY) {
        int j = 1;

        for(int i = this.getX() + 1; i < destX; ++i) {
            Piece checkPiece = board.pieces[i][this.getY() - j];
            if(checkPiece != null) {
                return false;
            }

            ++j;
        }

        return true;
    }

    /**
     * Scenario to check and make sure there are no pieces in the way for the up and left case
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
     * Scenario to check and make sure there are no pieces in the way for the down and left case
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