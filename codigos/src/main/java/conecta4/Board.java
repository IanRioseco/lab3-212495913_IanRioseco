package conecta4;


/**
 * Clase que representa el tablero de juego para Connect4.
 * Gestiona el estado del tablero, movimientos y verificación de condiciones de victoria.
 */
public class Board {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private String[][] grid;

    /**
     * Constructor para inicializar el tablero vacío.
     * Llena la cuadrícula con el carácter "-" que representa una celda vacía.
     */
    public Board() {
        grid = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = "-";
            }
        }
    }

    /**
     * Verifica si es posible realizar un movimiento en el tablero.
     *
     * @return true si hay al menos una columna con espacio disponible, de lo contrario false.
     */
    public boolean canPlay() {
        for (int j = 0; j < COLUMNS; j++) {
            if (grid[0][j].equals("-")) return true;
        }
        return false;
    }

    /**
     * Realiza un movimiento colocando una pieza en la columna indicada.
     *
     * @param column el índice de la columna (0-6) donde se desea colocar la pieza.
     * @param piece el color de la pieza representado como un String.
     * @return true si el movimiento fue exitoso, de lo contrario false.
     */
    public boolean playPiece(int column, String piece) {
        String auxpiece = piece.substring(0, 1);
        if (column < 0 || column >= COLUMNS) return false;
        for (int i = ROWS - 1; i >= 0; i--) {
            if (grid[i][column].equals("-")) {
                grid[i][column] = auxpiece;
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si hay un ganador en una alineación vertical.
     *
     * @return 1 si el jugador rojo ("R") ganó, 2 si el jugador amarillo ("Y") ganó, 0 si no hay ganador.
     */
    public int checkverticalwin() {
        for (int col = 0; col < COLUMNS; col++) {
            int count = 0;
            String lastColor = null;
            for (int row = 0; row < ROWS; row++) {
                String currentColor = grid[row][col];
                if (!currentColor.equals("-") && currentColor.equals(lastColor)) {
                    count++;
                    if (count == 4) {
                        return lastColor.equals("R") ? 1 : 2;
                    }
                } else {
                    count = 1;
                    lastColor = currentColor;
                }
            }
        }
        return 0;
    }

    /**
     * Verifica si hay un ganador en una alineación horizontal.
     *
     * @return 1 si el jugador rojo ("R") ganó, 2 si el jugador amarillo ("Y") ganó, 0 si no hay ganador.
     */
    public int checkhorizontalwin() {
        for (int row = 0; row < ROWS; row++) {
            int count = 0;
            String lastColor = null;
            for (int col = 0; col < COLUMNS; col++) {
                String currentColor = grid[row][col];
                if (!currentColor.equals("-") && currentColor.equals(lastColor)) {
                    count++;
                    if (count == 4) {
                        return lastColor.equals("R") ? 1 : 2;
                    }
                } else {
                    count = 1;
                    lastColor = currentColor;
                }
            }
        }
        return 0;
    }

    /**
     * Verifica si hay un ganador en una alineación diagonal.
     *
     * @return 1 si el jugador rojo ("R") ganó, 2 si el jugador amarillo ("Y") ganó, 0 si no hay ganador.
     */
    public int checkdiagonalwin() {
        // Verificar diagonales ascendentes (↗)
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                String currentColor = grid[row][col];
                if (!currentColor.equals("-") &&
                        currentColor.equals(grid[row - 1][col + 1]) &&
                        currentColor.equals(grid[row - 2][col + 2]) &&
                        currentColor.equals(grid[row - 3][col + 3])) {
                    return currentColor.equals("R") ? 1 : 2;
                }
            }
        }

        // Verificar diagonales descendentes (↘)
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                String currentColor = grid[row][col];
                if (!currentColor.equals("-") &&
                        currentColor.equals(grid[row + 1][col + 1]) &&
                        currentColor.equals(grid[row + 2][col + 2]) &&
                        currentColor.equals(grid[row + 3][col + 3])) {
                    return currentColor.equals("R") ? 1 : 2;
                }
            }
        }

        return 0;
    }

    /**
     * Verifica si hay un ganador en el tablero revisando todas las alineaciones posibles.
     *
     * @return 1 si el jugador rojo ("R") ganó, 2 si el jugador amarillo ("Y") ganó, 0 si no hay ganador.
     */
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

    /**
     * Imprime el estado actual del tablero en la consola.
     */
    public void printBoard() {
        for (String[] row : grid) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
