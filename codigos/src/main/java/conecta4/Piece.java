package conecta4;

public class Piece implements Pieceinterface {
    private String color;

    public Piece (String color) {
        this.color = color;
    }

    //OBTENER COLOR
    public String getColor() {
        return color;
    }
}
