package Chess.GUI;

import Chess.chessLogic.Board;
import Chess.chessLogic.Game;
import Chess.chessLogic.Move;
import Chess.chessLogic.Piece;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * The main class for the static Chess.GUI requirement part of Assignment1.1. I use a JFrame to hold the chessboard object,
 * then use JButtons to populate the 2D array (grid) with buttons (chess pieces). I then add an new JLabel made up of
 * a new ImageIcon, which is made up of thumbnails i have imported into Intellij
 */

public class boardGUI implements ActionListener {

    JButton requestedMoveButton = null;     // button that keeps track of current button clicked
    JFrame window;
    JButton[][] tiles;
    JPanel GUI;
    JPanel board;
    Board myLogicBoard;     // must be a global variable to keep track of different buttons clicked

    Piece curr;             // must be a global variable to keep track of different pieces clicked

    JLabel message;         // message that changes based on the state of the game

    JLabel statusText;
    JLabel scoreText;
    JToolBar score;

    int currTurn;

    JButton Restart;    // has to be declared globally to edit it when checkmate is hit

    public boardGUI(Board logicBoard, int whiteScore, int blackScore) {

        initializeBoard(logicBoard);
        final Color lightBlue = new Color(10, 96, 128);    // for the non-white color
        JToolBar menu = new JToolBar();
        initializeMenu(menu, whiteScore, blackScore);
        GUI.add(board);

        initializeButtons(lightBlue);

        board.setVisible(true);
    }

    private void initializeBoard(Board logicBoard) {
        board = new JPanel();
        tiles = new JButton[8][8];
        myLogicBoard = logicBoard;
        board.setSize(800, 800);
        board.setLayout(new GridLayout(8, 8));
        GUI = new JPanel(new BorderLayout(3, 3));
        message = new JLabel("Click start to begin!");
        statusText = new JLabel("");
        statusText.setForeground(Color.RED);
        GUI.setBorder(new EmptyBorder(4, 4, 4, 4));
    }

    /**
     * Called when the "Start" button is pushed. No pieces are drawn on the board until then
     */

    private void drawPieces() {
        tiles[7][0].setIcon(new ImageIcon("resources/whiteRook.png"));
        tiles[7][7].setIcon(new ImageIcon("resources/whiteRook.png"));
        tiles[7][1].setIcon(new ImageIcon("resources/whiteKnight.png"));
        tiles[7][6].setIcon(new ImageIcon("resources/whiteKnight.png"));
        tiles[7][2].setIcon(new ImageIcon("resources/whiteBishop.png"));
        tiles[7][5].setIcon(new ImageIcon("resources/whiteBishop.png"));
        tiles[7][3].setIcon(new ImageIcon("resources/whiteKing.png"));
        tiles[7][4].setIcon(new ImageIcon("resources/whiteQueen.png"));


        tiles[0][0].setIcon(new ImageIcon("resources/blackRook.png"));
        tiles[0][7].setIcon(new ImageIcon("resources/blackRook.png"));
        tiles[0][1].setIcon(new ImageIcon("resources/blackKnight.png"));
        tiles[0][6].setIcon(new ImageIcon("resources/blackKnight.png"));
        tiles[0][2].setIcon(new ImageIcon("resources/blackBishop.png"));
        tiles[0][5].setIcon(new ImageIcon("resources/blackBishop.png"));
        tiles[0][3].setIcon(new ImageIcon("resources/blackKing.png"));
        tiles[0][4].setIcon(new ImageIcon("resources/blackQueen.png"));


        for (int i = 0; i < 8; i++) {
            tiles[6][i].setIcon(new ImageIcon("resources/whitePawn.png"));
            tiles[1][i].setIcon(new ImageIcon("resources/blackPawn.png"));
        }
    }

    /**
     * Instantiates the 2D array of JButtons by creating new JButton objects
     * and making empty icons for each, so that the GUI can be updated
     * as pieces move
     *
     * @param lightBlue
     */

    private void initializeButtons(Color lightBlue) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {

                tiles[x][y] = new JButton();    // create a button for each tile (for later use)
                ImageIcon tempIcon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                tiles[x][y].setIcon(tempIcon);
                tiles[x][y].addActionListener(this);

                if ((x + y) % 2 == 0)
                    fillInColors(tiles[x][y], lightBlue); // blue tiles
                else
                    fillInColors(tiles[x][y], Color.white);  // white tiles

                board.add(tiles[x][y]); // add the square to the JPanel object
            }
        }
    }

    /**
     * Helper method to fill in the squares of the chessboard
     * @param JButton
     * @param color
     */

    private void fillInColors(JButton JButton, Color color) {
        JButton.setBackground(color);
        JButton.setOpaque(true);
        JButton.setBorderPainted(false);
    }

    /**
     * Helper method that simply returns the GUI object
     * @return
     */

    private JComponent getGUI() {
        return GUI;
    }

    /**
     * Creates the window (JFrame) and initialized everything so that the board can be seen
     */

    public void runGUI() {
        window = new JFrame("Chessboard");

        window.setLocationByPlatform(true);
        window.add(this.getGUI());
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        window.setMinimumSize(window.getSize());
        window.pack();
        window.setVisible(true);
    }

    /**
     * Event handler for clicking on a button. Due to the nature of JButton arrays and Swing,
     * the x and y coordinates must be translated. Calls helper methods that either highlight the selected
     * piece, or (if a piece has already been selected) determines if it is a
     * valid move
     */

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        int translateX = -1;
        int translateY = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tiles[i][j] == button) {
                    translateX = j;
                    translateY = 7 - i;
                }
            }
        }

        if (requestedMoveButton == null)
            highlightSelectedPiece(button, translateX, translateY);
        else
            attemptMove(button, translateX, translateY);
    }

    /**
     * Called when the first of the two clicks happens. If there is currently a piece here,
     * this highlights the button and prepares to check the move of the second click
     * @param button - current button
     * @param x - the x position, translated from the calling method
     * @param y - the y position, also translated from the calling method
     */

    private void highlightSelectedPiece(JButton button, int x, int y) {
        curr = myLogicBoard.pieces[x][y];
        if (curr != null && curr.getColor() == currTurn) {
            requestedMoveButton = button;
            requestedMoveButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.ORANGE));
            requestedMoveButton.setBorderPainted(true);
        }
    }

    /**
     * Called when the second of the two clicks happens. If this is a valid move,
     * the logicBoard is updated and the GUI is updated to reflect that change.
     * Otherwise, nothing happens
     * @param button - destination button
     * @param x - destination x (translated)
     * @param y - destination y (translated)
     */

    private void attemptMove(JButton button, int x, int y) {
        statusText.setText("");
        if (curr != null && curr.move(myLogicBoard, x, y)) {
            button.setIcon(requestedMoveButton.getIcon());
            requestedMoveButton.setIcon(null);
            swapTurn();
            checkForCheck();
        }
        else {
            if (myLogicBoard.blackKing.isInCheck() || myLogicBoard.whiteKing.isInCheck())
                statusText.setText("Move does not get king out of check. Try again");
            else
                statusText.setText("Illegal move. Try again");
            statusText.setForeground(Color.RED);
        }

        requestedMoveButton.setBorderPainted(false);
        curr = null;
        requestedMoveButton = null;
    }

    /**
     * Helper method to see if a king is in check after the GUI board has been updated.
     * Also checks for checkmate; if checkmate is true, the game is over
     */

    private void checkForCheck() {
        if (myLogicBoard.blackKing.isInCheck()) {
            if (!checkForCheckmate("BLACK KING HAS BEEN CHECKMATED"))
                statusText.setText("BLACK KING IS IN CHECK");
        }
        else if (myLogicBoard.whiteKing.isInCheck()) {
            if (!checkForCheckmate("WHITE KING HAS BEEN CHECKMATED"))
                statusText.setText("WHITE KING IS IN CHECK");
        }
        else {
            statusText.setText("");
        }
    }

    /**
     * Checks to see if checkmate is valid. If so, the game is over. The current turn is set to -1, preventing
     * anybody from making another move.
     * @param text
     * @return
     */

    private boolean checkForCheckmate(String text) {
        if (myLogicBoard.checkmate) {
            return restart(text);
        }
        return false;
    }

    private boolean restart(String text) {
        updateScores();
        statusText.setText(text);
        Restart.setText("Play Again?");
        message.setText("");
        scoreText.setText("White - " + Game.whiteScore + " Black - " + Game.blackScore);
        currTurn = -1;
        return true;
    }

    /**
     * Helper method to update scores. Called when checkmate is reached and the total score needs to be updated
     */
    private void updateScores() {
        Stack<Move> stack = myLogicBoard.getMoves();
        if (!stack.isEmpty()) {
            Move move = stack.peek();
            Piece piece = move.piece;
            if (piece.getColor() == 0)
                Game.whiteScore++;
            else
                Game.blackScore++;
        }
    }

    /**
     * XOR's the current turn with 1, i.e. toggles the value between 1 and 0. Also calls another helper method
     * to update the state of the turn UI
     */

    private void swapTurn() {
        currTurn ^= 1;
        setTurnText();
    }

    /**
     * Changes the turn UI based on the currTurn variable
     */

    private void setTurnText() {
        if (currTurn == 0)
            message.setText("Current Turn: WHITE");
        else
            message.setText("Current Turn: BLACK");
    }

    /**
     * Event handler for the Restart button. Hides the current window, creates a new GUI board,
     * and then initialized the board, thus starting a new game from scratch
     * @param restart - the button pressed
     */

    private void restartActionListener(JButton restart) {
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                Board newBoard = new Board();
                boardGUI newGUI = new boardGUI(newBoard, Game.whiteScore, Game.blackScore);
                newGUI.runGUI();
            }
        });
    }

    /**
     *  Event handler for the Start button. Puts all of the pieces on the board by calling a helper method,
     *  then initializes the currTurn variable
     * @param start - the button pressed
     */

    private void startActionListener(JButton start) {
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPieces();
                message.setText("Current Turn: WHITE");
                currTurn = 0;
            }
        });
    }

    /**
     * Event handler for the Undo button. Retrieves the Move stack from the Board class, then calls a helper method
     * that peeks the stack and undoes the last move. Finally, the currTurn variable is toggled
     * @param undo
     */

    private void undoActionListener(JButton undo) {
        undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Stack<Move> moveStack = myLogicBoard.getMoves();
                if (!moveStack.isEmpty())
                    translateAndUndo(moveStack);
                currTurn ^= 1;
                setTurnText();
            }
        });
    }

    private void forfeitActionListener(JButton forfeit) {
        forfeit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restart("FORFEIT");
                Restart.setText("Play Again?");
            }
        });
    }

    /**
     * Peeks the stack of Move objects, calls the Board undo method, then updates the UI to reflect the
     * piece going back from where it came
     * @param moveStack
     */

    private void translateAndUndo(Stack<Move> moveStack) {
        Move recent = moveStack.peek();     // get the most recent move before it is popped

        myLogicBoard.undo();

        int fromX = 7 - recent.toY;
        int fromY = recent.toX;

        int toX = 7 - recent.fromY;
        int toY = recent.fromX;

        JButton from = tiles[fromX][fromY];
        JButton to = tiles[toX][toY];

        to.setIcon(from.getIcon());
        from.setIcon(null);
    }

    /**
     * Adds the menu, the score toolbar, initializes the score of the game; initalizes all of the event handlers
     * for the Start, Restart, and Undo buttons, then adds all three to the menu JToolBar
     * @param menu
     * @param whiteScore
     * @param blackScore
     */

    private void initializeMenu(JToolBar menu, int whiteScore, int blackScore) {
        GUI.add(menu, BorderLayout.PAGE_START);

        score = new JToolBar();
        GUI.add(score, BorderLayout.PAGE_END);
        scoreText = new JLabel("White - " + whiteScore + " Black - " + blackScore);
        score.add(scoreText);

        JButton Start = new JButton("Start");
        startActionListener(Start);
        menu.add(Start);

        Restart = new JButton("Restart");
        restartActionListener(Restart);
        menu.add(Restart);

        JButton Undo = new JButton("Undo");
        undoActionListener(Undo);
        menu.add(Undo);

        JButton Forfeit = new JButton("Forfeit");
        forfeitActionListener(Forfeit);
        menu.add(Forfeit);

        menu.addSeparator();
        menu.add(message);

        menu.addSeparator();
        menu.add(statusText);

        menu.setFloatable(false);
    }

}
