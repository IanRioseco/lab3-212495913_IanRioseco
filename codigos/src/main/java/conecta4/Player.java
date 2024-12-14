package conecta4;

public class Player {
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    public Player(int id, String name, String color, int remainingPieces, int i, int i1, int piecesPerPlayer) {
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

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getRemainingPieces() {
        return remainingPieces;
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
