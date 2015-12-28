/**
 * Created by aleclueders on 9/16/15.
 */

package Chess.chessLogic;

public class King extends Piece {
    private boolean inCheck = false;

    /**
     * The parent constructor for simply constructing a Piece object.
     * @param alive
     * @param color
     * @param x
     * @param y
     */

    public King(boolean alive, int color, int x, int y) {
        super(alive, color, x, y);
    }

    /**
     * Method to set whether the king is in check or not
     * @param check
     */

    public void setCheck(boolean check) {
        this.inCheck = check;
    }

    /**
     * Getter method to see if king is in check
     * @return
     */

    public boolean isInCheck() {
        return this.inCheck;
    }

    /**
     * Ensures the king can only move one space around himself
     */

    public boolean isValidSpecificMove(Board board, int destX, int destY) {
        double dist = Math.sqrt(Math.pow(Math.abs(this.getX() - destX), 2) + Math.pow(Math.abs(this.getY() - destY), 2));
        return (dist <= (double)Math.sqrt(2));
    }
}