package conecta4;

public interface PlayerInterface {
    int getId();
    String getName();
    String getColor();
    int getRemainingPieces();
    void decrementRemainingPieces();
    void updateStatistics();
    int getWins();
    int getLosses();
    int getDraws();
}
