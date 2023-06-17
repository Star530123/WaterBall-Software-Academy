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

    public void moveRole(Role role, int newX, int newY) {
        this.objects[role.getX()][role.getY()] = null;
        this.objects[newX][newY] = role;
        role.setX(newX);
        role.setY(newY);
    }

    public MapObject[][] getObjects() {
        return objects;
    }
}
