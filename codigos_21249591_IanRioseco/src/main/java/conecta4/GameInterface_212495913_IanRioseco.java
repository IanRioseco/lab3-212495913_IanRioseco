package conecta4;

import java.util.List;

public interface GameInterface_212495913_IanRioseco {
    Player_212495913_IanRioseco getPlayer1();
    Player_212495913_IanRioseco getPlayer2();
    int getCurrentTurn();
    void createhistory(int column, String colorpiece);
    List<String> getmovehistory();
    boolean esEmpate();
    void endGame();
    void realizarmovimiento(Player_212495913_IanRioseco player, int column);
    Board_212495913_IanRioseco getBoard();
    Player_212495913_IanRioseco getCurrentPlayer();
    boolean getFlag();
    
}
