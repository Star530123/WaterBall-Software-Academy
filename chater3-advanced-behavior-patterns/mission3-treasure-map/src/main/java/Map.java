import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * @author StarL
 */
public class Map {
    private MapObject[][] objects;
    private final int ROW_SIZE;
    private final int POSITION_SIZE;
    private Set<Integer> usedPositions = new HashSet<>();
    private Character character;

    public Map(int mapSize) {
        this.objects = new MapObject[mapSize][mapSize];
        this.ROW_SIZE = mapSize;
        this.POSITION_SIZE = mapSize * mapSize;
    }

    public void initializeMap() {
        initializeCharacter();
        initializeObstacle();
        initializeTreasure();
        initializeMonster();
    }

    private void initializeMonster() {
        double probability = 0.1 * (1 + Math.random());
        int count = (int) (POSITION_SIZE * probability);
        for (int i = 0; i < count; i++) {
            int[] position = generatePosition();
            this.objects[position[0]][position[1]] = new Monster(this, position[0], position[1]);
        }
    }

    private void initializeTreasure() {
        double probability = 0.2 * (1 + Math.random());
        int count = (int) (POSITION_SIZE * probability);
        for (int i = 0; i < count; i++) {
            int[] position = generatePosition();
            this.objects[position[0]][position[1]] = new DevilFruit(); // TODO 寶藏生成邏輯，現在先固定生成DevilFruit
        }
    }

    private void initializeObstacle() {
        double probability = 0.1 * Math.random();
        int count = (int) (POSITION_SIZE * probability);
        for (int i = 0; i < count; i++) {
            int[] position = generatePosition();
            this.objects[position[0]][position[1]] = new Obstacle();
        }
    }

    private void initializeCharacter() {
        int[] position = generatePosition();
        Character character = new Character(this, position[0], position[1]);
        this.objects[position[0]][position[1]] = character;
        this.character = character;
    }

    private int[] generatePosition() {
        int position;
        do {
            position = (int) (Math.random() * POSITION_SIZE);
        } while (usedPositions.contains(position));
        usedPositions.add(position);
        return new int[]{position / ROW_SIZE, position % ROW_SIZE};
    }

    public void removeObject(int x, int y) {
        this.objects[x][y] = null;
    }

    public void moveRole(Role role, int newX, int newY) {
        System.out.printf("【移動】從(%d,%d)移動到(%d, %d)%n", role.getX(), role.getY(), newX, newY);
        this.objects[role.getX()][role.getY()] = null;
        this.objects[newX][newY] = role;
        role.setX(newX);
        role.setY(newY);
    }

    public MapObject[][] getObjects() {
        return objects;
    }

    public MapObject getObject(int x, int y) {
        if (isOutOfRange(x, y)) return null;
        return objects[x][y];
    }

    public boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= this.objects.length || y >= this.objects.length;
    }

    public Character getCharacter() {
        return character;
    }

    public void display() {
        for (MapObject[] row : this.objects) {
            StringJoiner sj = new StringJoiner(" ", "", "");
            for (MapObject object : row) {
                if (object == null) sj.add("_");
                else sj.add(object.display());
            }
            System.out.println(sj);
        }
    }
}
