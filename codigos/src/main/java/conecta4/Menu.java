package conecta4;

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
                        System.out.println("\n### Estado actual del tablero ###");
                        currentGame.getBoard().printBoard();
                    } else {
                        System.out.println("Primero debes crear un nuevo juego.");
                    }
                    break;
                case 3:
                    if (currentGame != null) {
                        if (currentGame.getFlag()) {
                            System.out.println("El juego ya ha terminado no se puede realizar mas movimientos. ");
                            break;
                        }
                        playMove(currentGame, scanner);
                        int winner = currentGame.getBoard().entregarganador();

                        if (winner != 0) {
                            currentGame.endGame();
                            System.out.println("\n ¡VICTORIA! El jugador " +
                                    (winner == 1 ? currentGame.getPlayer2().getName() : currentGame.getPlayer1().getName() +
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
                    System.out.println("\n¿Estas seguro de que deseas salir? (S/N): ");
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

    public static Game createNewGame(Scanner scanner) {
        System.out.println("\n### Crear Nuevo Juego ###");

        // Configuración del Jugador 1
        System.out.println("--- Configuracion Jugador 1 ---");
        System.out.print("\nIngrese ID del jugador 1: ");
        int player1Id = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer
        System.out.print("\nIngrese nombre del jugador 1: ");
        String player1Name = scanner.nextLine();
        System.out.print("\nIngrese color del jugador 1 (Rojo 0 Amarillo): ");
        String player1Color = scanner.nextLine();

        // Configuración del Jugador 2
        System.out.println("\n--- Configuracion Jugador 2 ---");
        System.out.print("\nIngrese ID del jugador 2: ");
        int player2Id = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer
        System.out.print("\nIngrese nombre del jugador 2: ");
        String player2Name = scanner.nextLine();
        System.out.print("\nIngrese color del jugador 2 (Rojo 0 Amarillo (sin repetir el de jugador 1): ");
        String player2Color = scanner.nextLine();

        // Configuración del número de fichas
        System.out.print("\nIngrese cantidad de fichas por jugador (4-21): ");
        int piecesPerPlayer = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer

        // Crear jugadores y juego
        Player player1 = new Player(player1Id, player1Name, player1Color, 0, 0, 0, piecesPerPlayer);
        Player player2 = new Player(player2Id, player2Name, player2Color, 0, 0, 0, piecesPerPlayer);
        Game game = new Game(player1, player2, new Board(), 1);

        System.out.println("\n### Juego creado exitosamente ###");
        return game;
    }

    public static void playMove(Game currentGame, Scanner scanner) {
        Player currentPlayer = currentGame.getCurrentPlayer();
        System.out.println("\n### Realizar jugada ###");
        System.out.println("Turno de: "+currentPlayer.getName() + " ("+currentPlayer.getColor()+"): ");
        System.out.println("Fichas restantes: "+ currentPlayer.getRemainingPieces());
        System.out.println("Seleccione una columna (0-6): ");

        int column = scanner.nextInt();
        currentGame.realizarmovimiento(currentPlayer, column);

    }
    public static void displayStatistics(Game currentGame) {
        System.out.println("\n### Estaditicas Generales ###");

        Player player1 = currentGame.getPlayer1();
        Player player2 = currentGame.getPlayer2();

        System.out.println(player1.getName() + "("+player1.getColor()+"): ");
        System.out.println("- Victorias: " + player1.getWins());
        System.out.println("- Derrotas: " + player1.getLosses());
        System.out.println("- Empates: " + player1.getDraws());

        System.out.println(player2.getName() + "("+player2.getColor()+"): ");
        System.out.println("- Victorias: " + player2.getWins());
        System.out.println("- Derrotas: " + player2.getLosses());
        System.out.println("- Empates: " + player2.getDraws());
    }
}
