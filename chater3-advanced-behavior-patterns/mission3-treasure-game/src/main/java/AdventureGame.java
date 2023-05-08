/**
 * @author StarL
 */
public class AdventureGame {
    private final static int MAP_SIZE = 10;
    private final MapObject[][] maps;

    public AdventureGame() {
        this.maps = initializeMap();
    }

    private MapObject[][] initializeMap(){
        MapObject[][] map = new MapObject[MAP_SIZE][MAP_SIZE];
        initializeCharacter(map);
        initializeObstacle(map);
        initializeTreasure(map);
        initializeMonster(map);
        return map;
    }

    private void initializeMonster(MapObject[][] map) {
    }

    private void initializeTreasure(MapObject[][] map) {
    }

    private void initializeObstacle(MapObject[][] map) {
    }

    private void initializeCharacter(MapObject[][] map) {
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
