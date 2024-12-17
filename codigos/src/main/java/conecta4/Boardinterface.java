package conecta4;

public interface Boardinterface {
    boolean canPlay();
    boolean playPiece(int column, Piece piece);
    int checkverticalwin();
    int checkhorizontalwin();
    int checkdiagonalwin();
    int entregarganador();
    void printBoard();
}
