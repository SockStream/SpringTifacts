package output;

public class Tile {
	private int x;
    private int y;
    private String background;
    private String character;

    // Constructeur
    public Tile(int x, int y, String background, String character) {
        this.x = x;
        this.y = y;
        this.background = background;
        this.character = character;
    }

    // Getters et setters
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public String getBackground() { return background; }
    public void setBackground(String background) { this.background = background; }

    public String getCharacter() { return character; }
    public void setCharacter(String character) { this.character = character; }
}
