package conecta4;

public class Board {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private String[][] grid;

    public Board() {
        grid = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = "-";
            }
        }
    }

    public boolean canPlay() {
        for (int j = 0; j < COLUMNS; j++) {
            if (grid[0][j].equals("-")) return true;
        }
        return false;
    }

    public boolean playPiece(int column, Piece piece) {
        if (column < 0 || column >= COLUMNS) return false;
        for (int i = ROWS - 1; i >= 0; i--) {
            if (grid[i][column].equals("-")) {
                grid[i][column] = piece.getColor();
                return true;
            }
        }
        return false;
    }

    public String checkVictory() {
        // Implementar lógica para verificar victoria (horizontal, vertical, diagonal).
        return null;
    }

    public void printBoard() {
        for (String[] row : grid) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}


