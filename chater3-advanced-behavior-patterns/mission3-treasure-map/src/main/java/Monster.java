/**
 * @author StarL
 */
public class Monster extends Role{
    public Monster(Map map, int x, int y) {
        super(map, x, y);
    }

    @Override
    public String display() {
        return "M";
    }

    @Override
    protected int initializeHP() {
        return 1;
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
}
