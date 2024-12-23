package conecta4;

import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game currentGame = null;

        while (true) {
            System.out.println("\n### Conecta4 - Menú Principal ###");
            System.out.println("1. Crear nuevo juego");
            System.out.println("2. Visualizar estado actual");
            System.out.println("3. Realizar jugada");
            System.out.println("4. Ver estadísticas generales");
            System.out.println("5. Salir");

            System.out.print("Ingrese su opcion: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (option) {
                case 1:
                    currentGame = createNewGame(scanner);
                    break;
                case 2:
                    if (currentGame != null) {
                        System.out.println("\n### Estado actual del tablero ###)");
                        currentGame.getBoard().printBoard();
                    } else {
                        System.out.println("Primero debes crear un nuevo juego.");
                    }
                    break;
                case 3:
                    if (currentGame != null) {
                        playMove(currentGame, scanner);
                        int winner = currentGame.getBoard().entregarganador();

                        if (winner != 0) {
                            currentGame.endGame();
                            System.out.println("\n ¡VICTORIA! El jugador " +
                                    (winner == 1 ? currentGame.getPlayer1().getName() : currentGame.getPlayer2().getName() +
                                            " ha ganado"));
                            break;
                        }
                        if (currentGame.esEmpate()) {
                            currentGame.endGame();
                            System.out.println("\nEl juego ha terminado en empate.");
                            break;
                        }
                    } else {
                        System.out.println("Primero debes crear un nuevo juego.");
                    }
                    break;
                case 4:
                    if (currentGame != null) {
                        displayStatistics(currentGame);
                    } else {
                        System.out.println("Primero debes crear un nuevo juego.");
                    }
                    break;
                case 5:
                    System.out.println("¿Estas seguro de que deseas salir? (S/N): ");
                    String confirm = scanner.nextLine().toUpperCase();
                    if (confirm.equals("S")) {
                        System.out.println("¡Gracias por jugar Conecta4!");
                        return;
                    }
                    break;
                default:
                    System.out.println("Opcion no válida. Intenta de nuevo.");
            }
        }
    }

    private static Game createNewGame(Scanner scanner) {
        System.out.println("\n### Crear Nuevo Juego ###");

        // Configuración del Jugador 1
        System.out.println("--- Configuracion Jugador 1 ---");
        System.out.print("Ingrese ID del jugador 1: ");
        int player1Id = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer
        System.out.print("Ingrese nombre del jugador 1: ");
        String player1Name = scanner.nextLine();
        System.out.print("Ingrese color del jugador 1 (Ej: Rojo --> R): ");
        String player1Color = scanner.nextLine();

        // Configuración del Jugador 2
        System.out.println("--- Configuracion Jugador 2 ---");
        System.out.print("Ingrese ID del jugador 2: ");
        int player2Id = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer
        System.out.print("Ingrese nombre del jugador 2: ");
        String player2Name = scanner.nextLine();
        System.out.print("Ingrese color del jugador 2 (Ej: Amarillo): ");
        String player2Color = scanner.nextLine();

        // Configuración del número de fichas
        System.out.print("Ingrese cantidad de fichas por jugador (4-21): ");
        int piecesPerPlayer = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer

        // Crear jugadores y juego
        Player player1 = new Player(player1Id, player1Name, player1Color, 0, 0, 0, piecesPerPlayer);
        Player player2 = new Player(player2Id, player2Name, player2Color, 0, 0, 0, piecesPerPlayer);
        Game game = new Game(player1, player2, new Board(), 1);

        System.out.println("\n### Juego creado exitosamente ###");
        return game;
        
    }

    private static void playMove(Game currentGame, Scanner scanner) {
        Player currentPlayer = currentGame.getCurrentPlayer();
        Player p1 = currentGame.getPlayer1();
        String color= "";
        if (currentPlayer == p1 ) {
            color = "Rojo";
        } else {
            color = "Amarillo";
        }
        System.out.println("\n### Realizar jugada ###");
        System.out.println("Turno de: "+currentPlayer.getName() + " ("+color+"): ");
        System.out.println("Fichas restantes: "+ currentPlayer.getRemainingPieces());
        System.out.println("Seleccione una columna (0-6): ");

        int column = scanner.nextInt();
        currentGame.realizarmovimiento(currentPlayer, column);

    }
    private static void displayStatistics(Game currentGame) {
        System.out.println("\n### Estaditicas Generales ###");

        Player player1 = currentGame.getPlayer1();
        Player player2 = currentGame.getPlayer2();

        System.out.println(player1.getName() + "(ROJO): ");
        System.out.println("- Victorias: " + player1.getWins());
        System.out.println("- Derrotas: " + player1.getLosses());
        System.out.println("- Empates: " + player1.getDraws());

        System.out.println(player2.getName() + "(AMARILLO): ");
        System.out.println("- Victorias: " + player2.getWins());
        System.out.println("- Derrotas: " + player2.getLosses());
        System.out.println("- Empates: " + player2.getDraws());
    }
}
