
/**
 * Created by aleclueders on 9/16/15.
 */
package Chess.chessLogic;

public class Pawn extends Piece {
    public boolean hasMoved;
    public Pawn(boolean alive, int color, int x, int y) {
        super(alive, color, x, y);
    }

    /**
     * Since a pawn can only move north or south, this ensures that white only goes north and black only goes south
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    public boolean isValidSpecificMove(Board board, int destX, int destY) {
        Piece destPiece = board.pieces[destX][destY];
        int myColor = this.getColor();
        if (myColor == 0 && whiteMove(destX, destY, destPiece)) {
            hasMoved = true;
            return true;
        }
        else if (myColor == 1 && blackMove(destX, destY, destPiece)) {
            hasMoved = true;
            return true;
        }
        return false;
    }

    public void setCheck(boolean check) {
    }

    public boolean isInCheck() {
        return false;
    }

    /**
     * Takes care of a white piece moving
     * @param destX
     * @param destY
     * @param destPiece
     * @return
     */

    private boolean whiteMove(int destX, int destY, Piece destPiece) {
        if (destPiece != null)
            return isWhiteCapture(destX, destY);
        return (destX == this.getX() && (destY == this.getY() + 1 || (destY == this.getY() + 2 && !hasMoved)));
    }

    /**
     * Takes care of a black piece moving
     * @param destX
     * @param destY
     * @param destPiece
     * @return
     */

    private boolean blackMove(int destX, int destY, Piece destPiece) {
        if (destPiece != null)
            return isBlackCapture(destX, destY);
        return (destX == this.getX() && (destY == this.getY() - 1 || (destY == this.getY() - 2 && !hasMoved)));
    }

    /**
     * Ensures that the white capture is diagonal and up
     * @param destX
     * @param destY
     * @return
     */

    private boolean isWhiteCapture(int destX, int destY) {
        return (destY == this.getY() + 1 && (destX == this.getX() - 1 || destX == this.getX() + 1));
    }

    /**
     * Ensures that the black capture is diagonal and down
     * @param destX
     * @param destY
     * @return
     */

    private boolean isBlackCapture(int destX, int destY) {
        return (destY == this.getY() - 1 && (destX == this.getX() - 1 || destX == this.getX() + 1));
    }
}
