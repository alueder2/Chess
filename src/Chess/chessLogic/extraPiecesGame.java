package Chess.chessLogic;

import Chess.GUI.extraPiecesBoardGUI;

/**
 * Created by aleclueders on 9/24/15.
 */
public class extraPiecesGame {
    public static int whiteScore = 0;
    public static int blackScore = 0;
    public static void main(String[] args) {
        extraPiecesBoard mainBoard = new extraPiecesBoard();
        extraPiecesBoardGUI gui = new extraPiecesBoardGUI(mainBoard, whiteScore, blackScore);
        gui.runGUI();
    }
}
