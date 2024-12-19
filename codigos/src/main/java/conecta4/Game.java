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
    private int currentTurn;
    private List<String> moveHistory;
    private boolean flag;


    public Game(Player player1, Player player2, Board board, int currentTurn) {
        this.player1 = this.player1;
        this.player2 = this.player2;
        this.board = new Board();
        this.currentTurn = 1;
        this.moveHistory = new ArrayList<>();

    }

    //getters

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public boolean getFlag() {
        return flag;
    }


    // HISTORY
    //funcion para crear el historial
    public void createhistory(int column, String colorpiece) {
        moveHistory.add("(" + column + "," + colorpiece + ")");
    }
    //funcion para obtener el historial

    public List<String> getMoveHistory() {
        return new ArrayList<>(moveHistory);
    }

    //ES EMPATE
    public boolean esEmpate() {
        Board board = getBoard();
        boolean tablerolleno = !board.canPlay();
        Player p1 = getPlayer1();
        Player p2 = getPlayer2();
        int piezasp1 = p1.getRemainingPieces();
        int piezasp2 = p2.getRemainingPieces();

        if (piezasp1 == 0 && piezasp2 == 0) {
            return true;
        }

        if (tablerolleno) {
            return true;
        }
        return false;
    }





    // ACTUALIZAR ESTADISTICAS

    // GET CURRENT PLAYER
    public Player getCurrentPlayer() {
        return (currentTurn == 1) ? player1 : player2;
    }

    // BOARD GET STATE
    public Board getBoard() {
        return board;
    }

    // END GAME

    // REALIZAR MOVIMIENTO
}
