package conecta4;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el flujo del juego Conecta4.
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private List<String> moveHistory;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.moveHistory = new ArrayList<>();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean makeMove(int column) {
        if (!board.canPlay()) return false;

        Piece piece = new Piece(currentPlayer.getColor());
        boolean success = board.playPiece(column, piece);
        if (success) {
            currentPlayer.decreaseRemainingPieces();
            moveHistory.add(currentPlayer.getName() + " played at column " + column);
            switchTurn();
        }
        return success;
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void printBoard() {
        board.printBoard();
    }

    public boolean isDraw() {
        return !board.canPlay();
    }

    public Player getWinner() {
        // Usar lógica para determinar ganador
        return null;
    }

    public void endGame() {
        // Actualizar estadísticas y terminar juego.
    }
}
