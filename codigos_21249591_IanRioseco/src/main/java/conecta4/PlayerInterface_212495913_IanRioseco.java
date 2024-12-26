package conecta4;

public interface PlayerInterface_212495913_IanRioseco {
    int getId();
    String getName();
    String getColor();
    int getRemainingPieces();
    void decreaseRemainingPieces();
    void updateStatistics(boolean win, boolean lose);
    int getWins();
    int getLosses();
    int getDraws();
}
