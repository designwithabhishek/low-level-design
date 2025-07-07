package tictactoe;

public class Player {
    int id;
    String name;

    PlayingPiece piece;

    public Player(int id, String name,PlayingPiece piece) {
        this.id = id;
        this.name = name;
        this.piece=piece;

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlayingPiece getPiece() {
        return piece;
    }
}
