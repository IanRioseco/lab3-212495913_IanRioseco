package conecta4;

import java.util.List;

public interface GameInterface {
    Player getPlayer1();
    Player getPlayer2();
    int getCurrentTurn();
    void createhistory(int column, String colorpiece);
    List<String> getmovehistory();
    boolean esEmpate();
    void endGame();
    void realizarmovimiento(Player player, int column);
    Board getBoard();
    Player getCurrentPlayer();
    boolean getFlag();
    
}
