
/**
 * Created by aleclueders on 9/16/15.
 */
package Chess.chessLogic;

import java.util.Stack;

/**
 * The main board class. Keeps track of each of the kings, the array of pieces, and whether or not the game is
 * in checkmate. Each board is made up of a 2D array of piece objects, which are all initialized to new objects.
 * These are then manipulated to make the chess game.
 */

public class Board {
    public Piece[][] pieces;
    public Piece whiteKing;
    public Piece blackKing;
    public boolean checkmate;
    private Stack<Move> moves;

    public Board() {
        pieces = new Piece[8][8];
        moves = new Stack<>();
        checkmate = false;

        for(int i = 0; i < 8; ++i) {
            pieces[i][1] = new Pawn(true, 0, i, 1);
            pieces[i][6] = new Pawn(true, 1, i, 6);
        }

        pieces[0][0] = new Rook(true, 0, 0, 0);
        pieces[1][0] = new Knight(true, 0, 1, 0);
        pieces[2][0] = new Bishop(true, 0, 2, 0);
        pieces[3][0] = new King(true, 0, 3, 0);
        pieces[4][0] = new Queen(true, 0, 4, 0);
        pieces[5][0] = new Bishop(true, 0, 5, 0);
        pieces[6][0] = new Knight(true, 0, 6, 0);
        pieces[7][0] = new Rook(true, 0, 7, 0);
        pieces[0][7] = new Rook(true, 1, 0, 7);
        pieces[1][7] = new Knight(true, 1, 1, 7);
        pieces[2][7] = new Bishop(true, 1, 2, 7);
        pieces[3][7] = new King(true, 1, 3, 7);
        pieces[4][7] = new Queen(true, 1, 4, 7);
        pieces[5][7] = new Bishop(true, 1, 5, 7);
        pieces[6][7] = new Knight(true, 1, 6, 7);
        pieces[7][7] = new Rook(true, 1, 7, 7);
        this.whiteKing = pieces[3][0];
        this.blackKing = pieces[3][7];
    }

    public void pushMove(Piece piece, int srcX, int srcY, int destX, int destY) {
        moves.push(new Move(piece, srcX, srcY, destX, destY));
    }

    public void undo() {
        if (!moves.isEmpty()) {
            Move top =  moves.pop();
            Piece piece = top.piece;
            this.pieces[top.toX][top.toY] = null;
            piece.setX(top.fromX);
            piece.setY(top.fromY);
            this.pieces[top.fromX][top.fromY] = piece;
        }
    }

    public Stack<Move> getMoves() {
        return this.moves;
    }
}
