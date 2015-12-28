package Chess.chessLogic;

/**
 * Created by aleclueders on 9/17/15.
 */

/**
 * A hopper piece that only captures by hopping diagonally over opponents
 */
public class Locust extends Piece {

    public Locust(boolean alive, int color, int x, int y) {
        super(alive, color, x, y);
    }

    public void setCheck(boolean check) {
    }

    public boolean isInCheck() {
        return false;
    }

    /**
     * Ensures the Locust moves correctly. It must hop two spaces diagonally in any direction
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    boolean isValidSpecificMove(Board board, int destX, int destY) {
        int myX = this.getX();
        int myY = this.getY();

        if (destX == myX - 2 && destY == myY + 2)
            return upLeft(board, destX, destY);
        if (destX == myX + 2 && destY == myY + 2)
            return upRight(board, destX, destY);
        if (destX == myX - 2 && destY == myY - 2)
            return downLeft(board, destX, destY);
        if (destX == myX + 2 && destY == myY - 2)
            return downRight(board, destX, destY);
        return false;

    }

    /**
     * Scenario for an up and left move
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean upLeft(Board board, int destX, int destY) {
        int myX = this.getX();
        int myY = this.getY();

        Piece enemy = board.pieces[myX - 1][myY + 1];
        if (enemy != null) {
            enemy.setAlive(false);
            enemy.setX(-1);
            enemy.setY(-1);
        }
        return true;
    }

    /**
     * Scenario for an up and right move
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean upRight(Board board, int destX, int destY) {
        int myX = this.getX();
        int myY = this.getY();

        Piece enemy = board.pieces[myX + 1][myY + 1];
        if (enemy != null) {
            enemy.setAlive(false);
            enemy.setX(-1);
            enemy.setY(-1);
        }
        return true;
    }

    /**
     * Scenario for an down and left move
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean downLeft(Board board, int destX, int destY) {
        int myX = this.getX();
        int myY = this.getY();

        Piece enemy = board.pieces[myX - 1][myY - 1];
        if (enemy != null) {
            enemy.setAlive(false);
            enemy.setX(-1);
            enemy.setY(-1);
        }
        return true;
    }

    /**
     * Scenario for an down and right move
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean downRight(Board board, int destX, int destY) {
        int myX = this.getX();
        int myY = this.getY();

        Piece enemy = board.pieces[myX + 1][myY + 1];
        if (enemy != null) {
            enemy.setAlive(false);
            enemy.setX(-1);
            enemy.setY(-1);
        }
        return true;
    }
}
