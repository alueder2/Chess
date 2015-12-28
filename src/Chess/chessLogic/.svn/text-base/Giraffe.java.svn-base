/**
 * Created by aleclueders on 9/16/15.
 */
package Chess.chessLogic;

public class Giraffe extends Piece {

    /**
     * The parent constructor for simply constructing a Piece object.
     * @param alive
     * @param color
     * @param x
     * @param y
     */

    public Giraffe(boolean alive, int color, int x, int y) {
        super(alive, color, x, y);
    }

    public void setCheck(boolean check) {
    }

    public boolean isInCheck() {
        return false;
    }

    /**
     * Ensures the move is within the limits of the Giraffe piece, i.e. 4 in one direction, 1 in the other
     */

    public boolean isValidSpecificMove(Board board, int destX, int destY) {
        int myX = this.getX();
        int myY = this.getY();
        if (myX == destX + 1 && (myY == destY + 4 || myY == destY - 4))
            return true;
        if (myX == destX - 1 && (myY == destY + 4 || myY == destY - 4))
            return true;
        if (myX == destX + 4 && (myY == destY + 1 || myY == destY - 1))
            return true;
        if (myX == destX - 4 && (myY == destY + 1 || myY == destY - 1))
            return true;
        return false;
    }
}