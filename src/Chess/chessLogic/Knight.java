

/**
 * Created by aleclueders on 9/16/15.
 */
package Chess.chessLogic;

public class Knight extends Piece {
    /**
     * The parent constructor for simply constructing a Piece object.
     * @param alive
     * @param color
     * @param x
     * @param y
     */

    public Knight(boolean alive, int color, int x, int y) {

    super(alive, color, x, y);
}

    public void setCheck(boolean check) {
    }

    public boolean isInCheck() {
        return false;
    }


    /**
     * Ensures the move is within the limits of the Knight piece, i.e. 2 squares in one direction and 1 square
     * in another
     */

    public boolean isValidSpecificMove(Board board, int destX, int destY) {
        int myX = this.getX();
        int myY = this.getY();
        if (myX == destX + 1 && (myY == destY + 2 || myY == destY - 2))
            return true;
        if (myX == destX - 1 && (myY == destY + 2 || myY == destY - 2))
            return true;
        if (myX == destX + 2 && (myY == destY + 1 || myY == destY - 1))
            return true;
        if (myX == destX - 2 && (myY == destY + 1 || myY == destY - 1))
            return true;
        return false;
    }
}