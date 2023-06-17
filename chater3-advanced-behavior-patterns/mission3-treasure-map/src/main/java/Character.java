/**
 * @author StarL
 */
public class Character extends Role{
    private Direction direction;

    public Character(Map map) {
        super(map);
    }

    @Override
    public String display() {
        return direction.icon;
    }

    @Override
    protected int initializeHP() {

    }

    @Override
    protected boolean doMove() {
        return false;
    }

    @Override
    protected void move() {

    }

    @Override
    public void attack() {

    }

    @Override
    protected void takeDamage(int HP) {

    }

    private enum Direction {
        UP("↑"),
        LEFT("←"),
        DOWN("↓"),
        RIGHT("→");

        private String icon;

        Direction(String icon) {
            this.icon = icon;
        }
    }
}
