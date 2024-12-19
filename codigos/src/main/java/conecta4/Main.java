package conecta4;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear jugadores con fichas suficientes
        Player player1 = new Player(1, "Juan", "R",0,0,0,21); // Jugador 1
        Player player2 = new Player(2, "María", "Y",0,0,0, 21); // Jugador 2
        Board board = new Board();
        int currentturn = 1;

        // Crear un juego nuevo
        Game game = new Game(player1, player2, board, currentturn);

        // Verificar si el juego está en empate al inicio
        System.out.println("¿Es empate?"); // Debería ser false al inicio
    }
}