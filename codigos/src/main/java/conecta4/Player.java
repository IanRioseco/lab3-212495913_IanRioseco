package conecta4;

public class Player implements PlayerInterface {
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    public Player(int id, String name, String color, int wins, int Losses, int Draws, int remainingPieces) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.remainingPieces = remainingPieces;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }

    // GETTTERS
    public int getId(Player player) {
        return id;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getWins() {
        return wins;
    }

    @Override
    public int getLosses() {
        return losses;
    }

    @Override
    public int getDraws() {
        return draws;
    }

    @Override
    public int getRemainingPieces() {
        return remainingPieces;
    }

    @Override
    public void decrementRemainingPieces() {

    }

    @Override
    public void updateStatistics() {

    }

    public void decreaseRemainingPieces() {
        if (remainingPieces > 0) remainingPieces--;
    }

    public void updateStatistics(boolean isWin, boolean isDraw) {
        if (isWin) wins++;
        else if (isDraw) draws++;
        else losses++;
    }
}
