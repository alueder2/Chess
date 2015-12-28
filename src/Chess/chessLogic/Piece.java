package Chess.chessLogic;

import java.util.Stack;

/**
 * Created by aleclueders on 9/16/15.
 */
public abstract class Piece {
    private boolean alive;
    private final int color;
    private int x;
    private int y;

    /**
     * The main constructor for constructing a Piece object. Pieces are set to alive by default/
     * @param alive - whether the piece is alive or not
     * @param color - color of the piece
     * @param x - x position of the piece
     * @param y - y position of the piece
     */

    public Piece(boolean alive, int color, int x, int y) {
        this.alive = alive;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    /**
     * Getter method for the isAlive trait
     * @return - returns whether the piece is alive or not
     */

    public boolean isAlive() {
        return this.alive;
    }

    /**
     * Color getter method
     * @return - returns the piece's color
     */

    public int getColor() {
        return this.color;
    }

    /**
     * X position getter method
     * @return - piece's x position
     */

    public int getX() {
        return this.x;
    }

    /**
     * Y position getter method
     * @return - piece's y position
     */

    public int getY() {
        return this.y;
    }

    /**
     * X position setter method
     * @param x - what to set piece's x to
     */

    public void setX(int x) {
        this.x = x;
    }

    /**
     * Y position setter method
     * @param y - what to set piece's y to
     */

    public void setY(int y) {
        this.y = y;
    }

    /**
     * isAlive setter method
     * @param alive - whether the piece is alive or not
     */

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * The basic move function. Ensures checkmate has not occurred, then (if my king is in check), checks to see
     * if it is checkmate. If it is not, this method will reject any move that does not
     * take my king out of check. If the king is not in check at all, this method will simply check to ensure
     * it is a valid move, and then execute the move, followed by checking to see if the enemy is now in check.
     *
     * @param board
     * @param destX
     * @param destY
     */

    public boolean move(Board board, int destX, int destY) {
        if (board.checkmate)
            return false;

        int myColor = this.getColor();
        Piece theirKing;
        boolean foundAWayOut = false;

        if (myColor == 0)
            theirKing = board.blackKing;
        else
            theirKing = board.whiteKing;

//        if (myKing.isInCheck()) {
//            if (checkForCheckmate(board, myColor, myKing, foundAWayOut))    // checkmate is true
//                return false;
//        }

        if (isValidMove(board, destX, destY) && kingWillBeSafe(board, destX, destY)) {
            executeMove(board, destX, destY);
            checkForTheirCheck(board);
            checkForMyCheck(board);
            checkForCheckmate(board, myColor, theirKing, foundAWayOut);
            return true;
        }
        return false;
    }

    /**
     * Helper for function to round up all allies and see if there is a way out of check
     * @param board
     * @param myColor
     * @param theirKing
     * @param foundAWayOut
     */

    private boolean checkForCheckmate(Board board, int myColor, Piece theirKing, boolean foundAWayOut) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (foundAWayOut) break;
                Piece enemy = board.pieces[i][j];
                if (enemy != null && enemy.getColor() != myColor)
                    foundAWayOut = enemy.getOutOfCheckAttempt(board, theirKing);
            }
            if (foundAWayOut) break;
        }
        if (!foundAWayOut) {
            board.checkmate = true;
            return true;
        }
        return false;
    }

    /**
     * Called when the move has been checked and ensured it is valid. Also captures any
     * pieces along the way
     *
     * @param board
     * @param destX
     * @param destY
     */
    private void executeMove(Board board, int destX, int destY) {
        Piece destPiece = board.pieces[destX][destY];
        if(destPiece != null) {
            this.killPiece(destPiece);
        }

        board.pushMove(this, this.getX(), this.getY(), destX, destY);

        board.pieces[this.getX()][this.getY()] = null;
        this.setX(destX);
        this.setY(destY);
        board.pieces[destX][destY] = this;
    }

    /**
     * Obvious helper method. Removes piece and sets it to dead
     * @param destPiece
     */
    private void killPiece(Piece destPiece) {
        destPiece.setAlive(false);
        destPiece.setX(-1);
        destPiece.setY(-1);
    }

    /**
     * Ensures the move is not off the board, is not a self move, does not run into teammates, and is a valid
     * move for that specific piece
     *
     * @param board
     * @param destX
     * @param destY
     * @return
     */
    public boolean isValidMove(Board board, int destX, int destY) {
        if (destX < 0 || destY < 0 || destX > 7 || destY > 7)
            return false;
        if (destX == this.getX() && destY == this.getY())
            return false;
        if (this.occupiedByAlly(board, destX, destY))
            return false;
        if (this.isValidSpecificMove(board, destX, destY))
            return true;
        return false;
    }

    /**
     * Helper method to check if a square is occupied by an ally
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean occupiedByAlly(Board board, int destX, int destY) {
        Piece destPiece = board.pieces[destX][destY];
        return destPiece != null && this.getColor() == destPiece.getColor();
    }

    /**
     * Abstract methods which are implemented in each respective type
     * of piece
     */

    abstract boolean isValidSpecificMove(Board var1, int var2, int var3);

    abstract void setCheck(boolean var1);

    public abstract boolean isInCheck();

    /**
     * Called after a move is executed. This checks to see if the move that was just executed
     * has put the opponent in check. If it has, then the opponents "inCheck" boolean is
     * set to true
     * @param board
     */

    private void checkForTheirCheck(Board board) {
        Piece theirKing = findTheirKing(board);
        int kingX = theirKing.getX();
        int kingY = theirKing.getY();
        int myColor = this.getColor();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece ally = board.pieces[i][j];
                if (ally != null) {
                    if (ally.getColor() == myColor && ally.isValidSpecificMove(board, kingX, kingY)) {
                        theirKing.setCheck(true);
                        return;
                    }
                }
            }
        }
        theirKing.setCheck(false);
    }

    private void checkForMyCheck(Board board) {
        Piece myKing = findMyKing(board);
        int kingX = myKing.getX();
        int kingY = myKing.getY();
        int myColor = this.getColor();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece enemy = board.pieces[i][j];
                if (enemy != null) {
                    if (enemy.getColor() != myColor && enemy.isValidSpecificMove(board, kingX, kingY)) {
                        myKing.setCheck(true);
                        return;
                    }
                }
            }
        }
        myKing.setCheck(false);
    }

    /**
     * Helper method to find the opponent king
     * @param board
     * @return
     */
    private Piece findTheirKing(Board board) {
        int myColor = this.getColor();
        Piece theirKing = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                theirKing = board.pieces[i][j];
                if (theirKing != null) {
                    if (theirKing.getColor() != myColor && theirKing instanceof King)
                        return theirKing;
                }
            }
        }
        return null;
    }

    /**
     * Helper method to find the ally king
     * @param board
     * @return
     */

    private Piece findMyKing(Board board) {
        int myColor = this.getColor();
        Piece myKing = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                myKing = board.pieces[i][j];
                if (myKing != null) {
                    if (myKing.getColor() == myColor && myKing instanceof King)
                        return myKing;
                }
            }
        }
        return null;
    }

    /**
     * Method to ensure that the move requested will not put my king in check. This method is also
     * used to try and find a way out of checkmate
     * @param board
     * @param destX
     * @param destY
     * @return
     */

    private boolean kingWillBeSafe(Board board, int destX, int destY) {

        // hypothetically move the piece to its requested destination
        int currX = this.getX();
        int currY = this.getY();

        this.setX(destX);
        this.setY(destY);
        board.pieces[currX][currY] = null;
        Piece oldPiece = board.pieces[destX][destY];

        board.pieces[destX][destY] = this;

        Piece myKing = findMyKing(board);
        int kingX = myKing.getX();
        int kingY = myKing.getY();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece enemy = board.pieces[i][j];

                if (enemy != null) {
                    if ((enemy.getColor() != this.getColor()) && enemy.isValidSpecificMove(board, kingX, kingY)) {
                        resetInitialPosition(board, destX, destY, currX, currY, oldPiece);
                        return false;
                    }
                }
            }
        }
        resetInitialPosition(board, destX, destY, currX, currY, oldPiece);
        return true;
    }

    /**
     * Helper to set the piece back to its original position after it has
     * been "hypothetically" moved
     * @param board
     * @param destX
     * @param destY
     * @param currX
     * @param currY
     * @param oldPiece
     */

    private void resetInitialPosition(Board board, int destX, int destY, int currX, int currY, Piece oldPiece) {
        this.setX(currX);   // putting the old piece back where it belongs
        this.setY(currY);
        board.pieces[currX][currY] = this;
        board.pieces[destX][destY] = oldPiece;
    }

    /**
     * Called on every piece when trying to get out of check. Checks to see if there
     * are any moves which will get my king out of check
     * @param board
     * @param myKing
     * @return
     */

    private boolean getOutOfCheckAttempt(Board board, Piece myKing) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.isValidMove(board, i, j)) {
                    if (this.kingWillBeSafe(board, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
