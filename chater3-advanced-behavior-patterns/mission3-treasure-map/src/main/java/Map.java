/**
 * @author StarL
 */
public class Map {
    private MapObject[][] objects;

    public Map(int mapSize) {
        initializeMap(mapSize);
    }

    private void initializeMap(int mapSize){
        this.objects = new MapObject[mapSize][mapSize];
        initializeCharacter(objects);
        initializeObstacle(objects);
        initializeTreasure(objects);
        initializeMonster(objects);
    }

    private void initializeMonster(MapObject[][] objects) {
    }

    private void initializeTreasure(MapObject[][] objects) {
    }

    private void initializeObstacle(MapObject[][] objects) {
    }

    private void initializeCharacter(MapObject[][] objects) {
    }

    public void removeObject(int x, int y) {
        this.objects[x][y] = null;
    }
}
