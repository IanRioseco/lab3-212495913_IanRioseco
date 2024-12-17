package conecta4;


public class Board {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private String[][] grid;


    // FUNCION BOARD
    public Board() {
        grid = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = "-";
            }
        }
    }

    // FUNCION SEPUEDEJUAGAR
    public boolean canPlay() {
        for (int j = 0; j < COLUMNS; j++) {
            if (grid[0][j].equals("-")) return true;
        }
        return false;
    }

    // FUNCION PLAYPIECE
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

    // FUNCION VICTORIA VERTICAL
    public int checkverticalwin() {
        for (int col = 0; col < COLUMNS; col++) {
            int count = 0;
            String lastColor = null;
            for (int row = 0; row < ROWS; row++) {
                String currentColor = grid[row][col];
                if (!currentColor.equals("-") && currentColor.equals(lastColor)) {
                    count++;
                    if (count == 4){
                        if (lastColor.equals("r")) return 1;
                        else return 2;
                    }
                } else {
                    count = 1;
                    lastColor = currentColor;
                }
            }
        }
        return 0;
    }

    // FUNCION VICTORIA HORIZONTAL
    public int checkhorizontalwin() {
        for (int row = 0; row < ROWS; row++) {
            int count = 0;
            String lastColor = null;
            for (int col = 0; col < COLUMNS; col++) {
                String currentColor = grid[row][col];
                if (!currentColor.equals("-") && currentColor.equals(lastColor)) {
                    count++;
                    if (count == 4){
                        if (lastColor.equals("r")) return 1;
                        else return 2;
                    }
                } else {
                    count = 1;
                    lastColor = currentColor;
                }
            }
        }
        return 0;
    }

    // FUNCION VICTORIA DIAGONAL
    public int checkdiagonalwin() {
        // Verificar diagonales ascendentes (↗)
        for (int row = 3; row < ROWS; row++) { // Comenzar en la cuarta fila
            for (int col = 0; col < COLUMNS - 3; col++) { // Evitar columnas fuera de rango
                String currentColor = grid[row][col];
                if (!currentColor.equals("-") &&
                        currentColor.equals(grid[row - 1][col + 1]) &&
                        currentColor.equals(grid[row - 2][col + 2]) &&
                        currentColor.equals(grid[row - 3][col + 3])) {
                    return currentColor.equals("r") ? 1 : 2; // Considera el color correcto
                }
            }
        }

        // Verificar diagonales descendentes (↘)
        for (int row = 0; row < ROWS - 3; row++) { // Evitar filas fuera de rango
            for (int col = 0; col < COLUMNS - 3; col++) { // Evitar columnas fuera de rango
                String currentColor = grid[row][col];
                if (!currentColor.equals("-") &&
                        currentColor.equals(grid[row + 1][col + 1]) &&
                        currentColor.equals(grid[row + 2][col + 2]) &&
                        currentColor.equals(grid[row + 3][col + 3])) {
                    return currentColor.equals("r") ? 1 : 2; // Considera el color correcto
                }
            }
        }

        return 0; // No hay ganador
    }

    // FUNCION PARA VERIFICAR GANADOR
    public int entregarganador() {
        int verticalwinner = checkverticalwin();
        if (verticalwinner != 0) {
            return verticalwinner;
        }
        int horizontalwinner = checkhorizontalwin();
        if (horizontalwinner != 0) {
            return horizontalwinner;
        }
        int diagonalwinner = checkdiagonalwin();
        if (diagonalwinner != 0) {
            return diagonalwinner;
        }
        return 0;
    }


    // FUNCION PARA MOSTRAR EL TABLERO
    public void printBoard() {
        for (String[] row : grid) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}



