import java.util.List;

/**
 * @author StarL
 */
public class Monster extends Role{
    private final static List<int[]> MOVE_DISTANCES = Direction.moveDistances();
    private int damage = 50;

    public Monster(Map map, int x, int y) {
        super(map, x, y);
    }

    @Override
    public String display() {
        return "M";
    }

    @Override
    protected int fullHP() {
        return 1;
    }

    @Override
    protected boolean doMove() {
        return MOVE_DISTANCES.stream()
                .map(d -> map.getObject(getX() + d[0], getY() + d[1]))
                .noneMatch(o -> o instanceof Character);
    }

    @Override
    protected void move() {
        int index = (int) (Math.random() * 3);
        int size = MOVE_DISTANCES.size();
        for(int i = 0; i < size; i++) {
            int[] move = MOVE_DISTANCES.get((index + i) % size);
            if(moveSuccessfully(this.x + move[0], this.y + move[1])) break;
        }
    }

    @Override
    public void attack() {
        Character character = (Character) MOVE_DISTANCES.stream()
                .map(d -> map.getObject(getX() + d[0], getY() + d[1]))
                .filter(o -> o instanceof Character)
                .findFirst()
                .orElse(null);
        if(character != null) character.takeDamage(damage);
    }
}
