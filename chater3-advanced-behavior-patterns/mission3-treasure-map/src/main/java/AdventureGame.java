/**
 * @author StarL
 */
public class AdventureGame {
    private final static int MAP_SIZE = 10;
    private final Map map;

    public AdventureGame() {
        this.map = new Map(MAP_SIZE);
    }


    public void start() {

    }

    private boolean hasWon() {
        return true;
    }

    private boolean hasLost() {
        return true;
    }
}
