package conecta4;

import java.util.List;

public interface Gameinterface {
    Player getPlayer1();
    Player getPlayer2();
    int getCurrentTurn();
    boolean getFlag();
    void createHistory();
    List<String> getMoveHistory();
    boolean esEmpate();
    void EndGame();
    void RealizarMovimiento();
    
}
