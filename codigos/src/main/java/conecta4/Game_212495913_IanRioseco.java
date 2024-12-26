package conecta4;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase que representa el flujo del juego Conecta4.
 */
/**
 * Clase que representa un juego de tipo Connect4.
 * Implementa {@link GameInterface_212495913_IanRioseco}.
 * Gestiona el tablero, jugadores, turnos, historial de movimientos y estado del juego.
 */
public class Game_212495913_IanRioseco implements GameInterface_212495913_IanRioseco {
    private Board_212495913_IanRioseco board;
    private Player_212495913_IanRioseco player1;
    private Player_212495913_IanRioseco player2;
    private int currentTurn;
    private List<String> moveHistory;
    private boolean flag = false;

    /**
     * Constructor para inicializar el juego con dos jugadores, un tablero y un turno inicial.
     *
     * @param player1 el primer jugador.
     * @param player2 el segundo jugador.
     * @param board el tablero del juego.
     * @param currentTurn el turno inicial del juego (1 para jugador1, 2 para jugador2).
     */
    public Game_212495913_IanRioseco(Player_212495913_IanRioseco player1, Player_212495913_IanRioseco player2, Board_212495913_IanRioseco board, int currentTurn) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board_212495913_IanRioseco();
        this.currentTurn = 1;
        this.moveHistory = new ArrayList<>();
    }

    /**
     * Obtiene el estado del flag del juego.
     *
     * @return true si el juego ha terminado, de lo contrario false.
     */
    public boolean getFlag() {
        return flag;
    }

    /**
     * Obtiene el primer jugador.
     *
     * @return el objeto del primer jugador.
     */
    public Player_212495913_IanRioseco getPlayer1() {
        return player1;
    }

    /**
     * Obtiene el segundo jugador.
     *
     * @return el objeto del segundo jugador.
     */
    public Player_212495913_IanRioseco getPlayer2() {
        return player2;
    }

    /**
     * Obtiene el turno actual.
     *
     * @return 1 si es el turno del primer jugador, 2 si es el del segundo jugador.
     */
    public int getCurrentTurn() {
        return currentTurn;
    }

    /**
     * Crea un historial del movimiento realizado.
     *
     * @param column la columna donde se realizó el movimiento.
     * @param colorpiece el color de la pieza jugada.
     */
    public void createhistory(int column, String colorpiece) {
        moveHistory.add("(" + column + "," + colorpiece + ")");
    }

    /**
     * Obtiene el historial de movimientos realizados en el juego.
     *
     * @return una lista con los movimientos registrados.
     */
    public List<String> getmovehistory() {
        return moveHistory;
    }

    /**
     * Verifica si el juego ha terminado en empate.
     *
     * @return true si es un empate, de lo contrario false.
     */
    public boolean esEmpate() {
        Board_212495913_IanRioseco board = getBoard();
        boolean tablerolleno = !board.canPlay();
        Player_212495913_IanRioseco p1 = getPlayer1();
        Player_212495913_IanRioseco p2 = getPlayer2();
        int pip1 = p1.getRemainingPieces();
        int pip2 = p2.getRemainingPieces();

        if (pip1 == 0 && pip2 == 0) {
            return true;
        }
        return tablerolleno;
    }

    /**
     * Obtiene el jugador que tiene el turno actual.
     *
     * @return el jugador actual.
     */
    public Player_212495913_IanRioseco getCurrentPlayer() {
        return (currentTurn == 1) ? player1 : player2;
    }

    /**
     * Obtiene el estado del tablero actual.
     *
     * @return el objeto del tablero.
     */
    public Board_212495913_IanRioseco getBoard() {
        return board;
    }

    /**
     * Finaliza el juego y actualiza las estadísticas de los jugadores.
     */
    public void endGame() {
        var board = getBoard();
        int winner = board.entregarganador();
        Player_212495913_IanRioseco p1 = getPlayer1();
        Player_212495913_IanRioseco p2 = getPlayer2();

        if (flag) {
            if (winner == 1) {
                p1.updateStatistics(true, false);
                p2.updateStatistics(false, false);
            } else if (winner == 2) {
                p1.updateStatistics(false, false);
                p2.updateStatistics(true, false);
            } else if (esEmpate()) {
                p1.updateStatistics(false, true);
                p2.updateStatistics(false, true);
            }

        } else {
            System.out.println("JUEGO TERMINADO");
        }
    }

    /**
     * Realiza un movimiento en el juego, actualiza el tablero, el historial,
     * y verifica el estado del juego (victoria o empate).
     *
     * @param player el jugador que realiza el movimiento.
     * @param column la columna donde se colocará la pieza.
     */
    public void realizarmovimiento(Player_212495913_IanRioseco player, int column) {
        Board_212495913_IanRioseco board = getBoard();
        boolean tablerolleno = !board.canPlay();
        Player_212495913_IanRioseco p1 = getPlayer1();
        Player_212495913_IanRioseco p2 = getPlayer2();
        int piezasplayer = player.getRemainingPieces();
        String pieceplayer = player.getColor();
        int actualTurn = getCurrentTurn();

        if (flag) {
            System.out.println("Juego finalizado");
            return;
        }

        if (tablerolleno) {
            System.out.println("No se puede realizar movimiento, el tablero está lleno");
            return;
        }

        if (piezasplayer == 0) {
            System.out.println("El jugador no tiene fichas disponibles");
            return;
        }

        if ((actualTurn == 1 && player != player1) || (currentTurn == 2 && player != player2)) {
            System.out.println("No es turno del jugador " + actualTurn);
            return;
        }

        if (column > 6) {
            System.out.println("Columna incorrecta, debe ingresar una columna entre 0-6");
            return;
        }

        board.playPiece(column, pieceplayer);
        System.out.println("Movimiento realizado:");
        board.printBoard();

        player.decreaseRemainingPieces();
        createhistory(column, pieceplayer);
        switchTurn();

        int ganador = board.entregarganador();
        if (ganador != 0) {
            endGame();
            flag = true;
        }

        if (esEmpate()) {
            endGame();
            flag = true;
        }
    }

    /**
     * Cambia el turno al siguiente jugador.
     */
    private void switchTurn() {
        currentTurn = (currentTurn == 1) ? 2 : 1;
    }
}
