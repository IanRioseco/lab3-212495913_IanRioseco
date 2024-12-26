package conecta4;

/**
 * Representa una pieza en el juego.
 * Implementa {@link PieceInterface}.
 * Esta clase almacena el color de la pieza.
 */
public class Piece implements PieceInterface {
    private String color;

    /**
     * Construye una nueva pieza con el color especificado.
     *
     * @param color el color de la pieza.
     */
    public Piece(String color) {
        this.color = color;
    }

    /**
     * Obtiene el color de la pieza.
     *
     * @return el color de la pieza.
     */
    public String getColor() {
        return color;
    }
}

