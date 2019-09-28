package chess;

public class Square {
    private String str;
    private int x;
    private int y;


    public Square(String str) {
        this.str = str.toUpperCase();
        this.x = str.charAt(0);
        this.y = str.charAt(1);
    }

    private Square(int x, int y) {
        this(((char) x) + "" + ((char) y));
    }

    public Square down(int step) {
        return new Square(x, y - step);
    }

    public Square up(int step) {
        return new Square(x, y + step);
    }

    public Square left(int step) {
        return new Square(x - step, y);
    }

    public Square right(int step) {
        return new Square(x + step, y);
    }

    public Square symmetricX() {
        return new Square(x, 105 - y);
    }

    public String getStr() {
        return str;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return str.equals(square.str);
    }

    public int hashCode() {
        return str.hashCode();
    }


    public String toString() {
        return str;
    }
}
