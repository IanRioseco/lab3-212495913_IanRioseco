package conecta4;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Piece redpiece = new Piece("r");
        Piece yellowpiece = new Piece("y");

        board.playPiece(3, redpiece);
        board.playPiece(0, yellowpiece);
        board.playPiece(0, redpiece);
        board.playPiece(0, yellowpiece);
        board.playPiece(0, redpiece);
        board.playPiece(1, yellowpiece);
        board.playPiece(1, redpiece);
        board.playPiece(2, yellowpiece);
        board.playPiece(1, redpiece);
        board.playPiece(4, yellowpiece);
        board.playPiece(2, redpiece);
        board.playPiece(3, yellowpiece);

        board.printBoard();

        int winner = board.checkdiagonalwin();
        if (winner != 0) {
            System.out.println(winner);
        } else {
            System.out.println("no hay ganador aun");
        }

        int winnnner = board.entregarganador();
        if (winnnner != 0) {
            System.out.println(winnnner);
        } else {
            System.out.println("no hay ganador aunnn");
        }

    }
}