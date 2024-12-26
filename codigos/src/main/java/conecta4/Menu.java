package conecta4;

import java.util.Scanner;

/**
 * Clase Menu que implementa el sistema principal de Conecta4.
 * Contiene el menú interactivo que permite gestionar el juego, incluyendo crear juegos,
 * realizar jugadas, visualizar estadísticas y finalizar el programa.
 */
public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game_212495913_IanRioseco currentGame = null; // Variable para mantener el juego actual en ejecución.

        while (true) {
            // Menú principal del juego
            System.out.println("\n### Conecta4 - Menú Principal ###");
            System.out.println("1. Crear nuevo juego");
            System.out.println("2. Visualizar estado actual");
            System.out.println("3. Realizar jugada");
            System.out.println("4. Ver estadísticas generales");
            System.out.println("5. Salir");

            System.out.print("Ingrese su opción: ");
            int option = scanner.nextInt(); // Captura la opción seleccionada por el usuario.
            scanner.nextLine(); // Limpia el buffer.

            switch (option) {
                case 1:
                    // Crear un nuevo juego.
                    currentGame = createNewGame(scanner);
                    break;
                case 2:
                    // Mostrar el estado actual del tablero.
                    if (currentGame != null) {
                        System.out.println("\n### Estado actual del tablero ###");
                        currentGame.getBoard().printBoard();
                    } else {
                        System.out.println("Primero debes crear un nuevo juego.");
                    }
                    break;
                case 3:
                    // Realizar una jugada.
                    if (currentGame != null) {
                        if (currentGame.getFlag()) {
                            System.out.println("El juego ya ha terminado, no se pueden realizar más movimientos.");
                            break;
                        }
                        playMove(currentGame, scanner);

                        // Verificar si hay un ganador después del movimiento.
                        int winner = currentGame.getBoard().entregarganador();
                        if (winner != 0) {
                            currentGame.endGame();
                            System.out.println("\n ¡VICTORIA! El jugador " +
                                    (winner == 1 ? currentGame.getPlayer1().getName() : currentGame.getPlayer2().getName()) +
                                    " ha ganado.");
                            break;
                        }

                        // Verificar si el juego termina en empate.
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
                    // Mostrar estadísticas generales.
                    if (currentGame != null) {
                        displayStatistics(currentGame);
                    } else {
                        System.out.println("Primero debes crear un nuevo juego.");
                    }
                    break;
                case 5:
                    // Salir del programa.
                    System.out.println("\n¿Estás seguro de que deseas salir? (S/N): ");
                    String confirm = scanner.nextLine().toUpperCase();
                    if (confirm.equals("S")) {
                        System.out.println("¡Gracias por jugar Conecta4!");
                        return;
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    /**
     * Método para crear un nuevo juego.
     * Solicita al usuario la configuración de los jugadores y el número de fichas.
     *
     * @param scanner Scanner para capturar la entrada del usuario.
     * @return El juego configurado con los jugadores y el tablero.
     */
    public static Game_212495913_IanRioseco createNewGame(Scanner scanner) {
        System.out.println("\n### Crear Nuevo Juego ###");

        // Configuración del Jugador 1.
        System.out.println("--- Configuración Jugador 1 ---");
        System.out.print("\nIngrese ID del jugador 1: ");
        int player1Id = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer.
        System.out.print("\nIngrese nombre del jugador 1: ");
        String player1Name = scanner.nextLine();
        System.out.print("\nIngrese color del jugador 1 (Rojo o Amarillo): ");
        String player1Color = scanner.nextLine();

        // Configuración del Jugador 2.
        System.out.println("\n--- Configuración Jugador 2 ---");
        System.out.print("\nIngrese ID del jugador 2: ");
        int player2Id = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer.
        System.out.print("\nIngrese nombre del jugador 2: ");
        String player2Name = scanner.nextLine();
        System.out.print("\nIngrese color del jugador 2 (Rojo o Amarillo, sin repetir el del jugador 1): ");
        String player2Color = scanner.nextLine();

        // Configuración del número de fichas.
        System.out.print("\nIngrese cantidad de fichas por jugador (4-21): ");
        int piecesPerPlayer = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer.

        // Crear jugadores y juego.
        Player_212495913_IanRioseco player1 = new Player_212495913_IanRioseco(player1Id, player1Name, player1Color, 0, 0, 0, piecesPerPlayer);
        Player_212495913_IanRioseco player2 = new Player_212495913_IanRioseco(player2Id, player2Name, player2Color, 0, 0, 0, piecesPerPlayer);
        Game_212495913_IanRioseco game = new Game_212495913_IanRioseco(player1, player2, new Board_212495913_IanRioseco(), 1);

        System.out.println("\n### Juego creado exitosamente ###");
        return game;
    }

    /**
     * Método para realizar una jugada.
     * Solicita al jugador actual que seleccione una columna y procesa su movimiento.
     *
     * @param currentGame Juego actual.
     * @param scanner     Scanner para capturar la entrada del usuario.
     */
    public static void playMove(Game_212495913_IanRioseco currentGame, Scanner scanner) {
        Player_212495913_IanRioseco currentPlayer = currentGame.getCurrentPlayer();
        System.out.println("\n### Realizar jugada ###");
        System.out.println("Turno de: " + currentPlayer.getName() + " (" + currentPlayer.getColor() + "): ");
        System.out.println("Fichas restantes: " + currentPlayer.getRemainingPieces());
        System.out.print("Seleccione una columna (0-6): ");

        int column = scanner.nextInt();
        currentGame.realizarmovimiento(currentPlayer, column);
    }

    /**
     * Método para mostrar las estadísticas de ambos jugadores.
     *
     * @param currentGame Juego actual.
     */
    public static void displayStatistics(Game_212495913_IanRioseco currentGame) {
        System.out.println("\n### Estadísticas Generales ###");

        Player_212495913_IanRioseco player1 = currentGame.getPlayer1();
        Player_212495913_IanRioseco player2 = currentGame.getPlayer2();

        System.out.println(player1.getName() + " (" + player1.getColor() + "): ");
        System.out.println("- Victorias: " + player1.getWins());
        System.out.println("- Derrotas: " + player1.getLosses());
        System.out.println("- Empates: " + player1.getDraws());

        System.out.println(player2.getName() + " (" + player2.getColor() + "): ");
        System.out.println("- Victorias: " + player2.getWins());
        System.out.println("- Derrotas: " + player2.getLosses());
        System.out.println("- Empates: " + player2.getDraws());
    }
}
