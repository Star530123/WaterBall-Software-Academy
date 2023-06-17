/**
 * @author StarL
 */
public class Monster extends Role{
    public Monster(Map map) {
        super(map);
    }

    @Override
    public String display() {
        return "M";
    }

    @Override
    protected void initializeHP() {

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
