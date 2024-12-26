package conecta4;

public interface BoardInterface_212495913_IanRioseco {
    boolean canPlay();
    boolean playPiece(int column, Piece_212495913_IanRioseco piece);
    int checkverticalwin();
    int checkhorizontalwin();
    int checkdiagonalwin();
    int entregarganador();
    void printBoard();
}
