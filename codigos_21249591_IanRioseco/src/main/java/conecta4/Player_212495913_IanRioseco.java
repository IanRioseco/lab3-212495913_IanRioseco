package conecta4;

/**
 * Representa un jugador en el juego.
 * Implementa {@link PlayerInterface_212495913_IanRioseco}.
 * Esta clase contiene información sobre la identidad del jugador, su color,
 * estadísticas del juego y las piezas restantes.
 */
public class Player_212495913_IanRioseco implements PlayerInterface_212495913_IanRioseco {
    private final int id;
    private final String name;
    private final String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    /**
     * Construye un nuevo jugador con los atributos especificados.
     *
     * @param id el identificador único del jugador.
     * @param name el nombre del jugador.
     * @param color el color asociado al jugador.
     * @param wins la cantidad inicial de victorias del jugador.
     * @param losses la cantidad inicial de derrotas del jugador.
     * @param draws la cantidad inicial de empates del jugador.
     * @param remainingPieces la cantidad inicial de piezas disponibles para el jugador.
     */
    public Player_212495913_IanRioseco(int id, String name, String color, int wins, int losses, int draws, int remainingPieces) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.remainingPieces = remainingPieces;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }

    /**
     * Obtiene el identificador único del jugador.
     *
     * @return el ID del jugador.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return el nombre del jugador.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el color asociado al jugador.
     *
     * @return el color del jugador.
     */
    public String getColor() {
        return color;
    }

    /**
     * Obtiene la cantidad de victorias logradas por el jugador.
     *
     * @return la cantidad de victorias.
     */
    public int getWins() {
        return wins;
    }

    /**
     * Obtiene la cantidad de derrotas sufridas por el jugador.
     *
     * @return la cantidad de derrotas.
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Obtiene la cantidad de empates logrados por el jugador.
     *
     * @return la cantidad de empates.
     */
    public int getDraws() {
        return draws;
    }

    /**
     * Obtiene la cantidad de piezas restantes del jugador.
     *
     * @return la cantidad de piezas restantes.
     */
    public int getRemainingPieces() {
        return remainingPieces;
    }

    /**
     * Disminuye en uno la cantidad de piezas restantes, si aún quedan.
     */
    public void decreaseRemainingPieces() {
        if (remainingPieces > 0) remainingPieces--;
    }

    /**
     * Actualiza las estadísticas del jugador según el resultado de un juego.
     *
     * @param isWin true si el jugador ganó el juego, false en caso contrario.
     * @param isDraw true si el juego fue un empate, false en caso contrario.
     */
    public void updateStatistics(boolean isWin, boolean isDraw) {
        if (isWin) wins++;
        else if (isDraw) draws++;
        else losses++;
    }
}
