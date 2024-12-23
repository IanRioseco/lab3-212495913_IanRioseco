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
    private boolean flag = false;


    public Game(Player player1, Player player2, Board board, int currentTurn) {
        this.player1 = player1;
        this.player2 = player2;
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
        int pip1 = p1.getRemainingPieces();
        int pip2 = p2.getRemainingPieces();

        if (pip1 == 0 && pip2 == 0) {
            return true;
        }

        return tablerolleno;
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
    public void endGame() {
        Board board = getBoard();
        int winner = board.entregarganador();
        Player p1 = getPlayer1();
        Player p2 = getPlayer2();

        if (flag) {
            if (winner == 1) {
                p1.updateStatistics(true,false);
                p2.updateStatistics(false,false);
                System.out.println();
            } else if (winner == 2) {
                p1.updateStatistics(false,false);
                p2.updateStatistics(true,false);
            } else if (esEmpate()) {
                p1.updateStatistics(false,true);
                p2.updateStatistics(false,true);
            }
        }
    }

    // REALIZAR MOVIMIENTO
    public void realizarmovimiento(Player player, int column) {
        // DEFINICION DE VARIABLES
        Board board = getBoard();
        boolean tablerolleno = !board.canPlay();
        Player p1 = getPlayer1();
        Player p2 = getPlayer2();
        int piezasp1 = p1.getRemainingPieces();
        int id1 = p1.getId();
        int id2 = p2.getId();
        int piezasp2 = p2.getRemainingPieces();
        int piezasplayer = player.getRemainingPieces();
        String pieceplayer = player.getColor();
        int idplayer = player.getId();
        int actualTurn = getCurrentTurn();
        Player playeraux = player;

        // COMPROBACIONES

        if (flag) {
            System.out.println("Juego finalizado");
        }

        if (tablerolleno) {
            System.out.println("No se puede realizar movimieno el tablero esta lleno");
        }

        if (piezasplayer == 0 ) {
            System.out.println("El jugador no tiene fichas disponibles");
        }

        if ((actualTurn == 1 && player != player1)) {
            System.out.println("no es turno del jugador " + actualTurn);
        } else if (currentTurn == 2 && player != player2) {
            System.out.println("no es turno del jugador " + actualTurn);

        }

        if (column > 6) {
            System.out.println("Columna incorrecta, Debe ingresar una columna entre 0-6 ");
        }

        board.playPiece(column, pieceplayer);
        System.out.println("Movimiento realizado:");
        board.printBoard();

        if (idplayer == id1) {
            playeraux = p1;
        } else {
            playeraux = p2;
        }

        playeraux.decreaseRemainingPieces();
        createhistory(column,pieceplayer);
        switchTurn();

        //VERIFICACION DE VICTORIA
        int ganador = board.entregarganador();
        if (ganador != 0) {
            endGame();
            flag = true;
        }
        // VERIFICACION DE EMPATE
        if (esEmpate()) {
            endGame();
            flag = true;
        }
    }
    private void switchTurn() {
        currentTurn = (currentTurn == 1) ? 2 : 1;
    }
}

