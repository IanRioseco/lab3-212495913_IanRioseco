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
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentTurn = 1;
        this.moveHistory = new ArrayList<>();

    }
    //getters

    //funcion para crear el historial
    public void createhistory(int column, String colorpiece) {
        moveHistory.add("(" + column + "," + colorpiece + ")");
    }
    //funcion para obtener el historial

    public List<String> getMoveHistory() {
        return new ArrayList<>(moveHistory);
    }

    //ES EMPATE

    // ACTUALIZAR ESTADISTICAS

    // GET CURRENT PLAYER
    public Player getPlayer1() {
        return (currentTurn == 1) ? player1 : player2;
    }

    // BOARD GET STATE
    public Board getBoard() {
        return board;
    }

    // END GAME

    // REALIZAR MOVIMIENTO
}
