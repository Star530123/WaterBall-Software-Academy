/**
 * @author StarL
 */
public abstract class Role extends MapObject {
    private int x;
    private int y;
    private Map map;
    private State state = State.NORMAL;
    private int stateEndurance;
    private int HP;

    public Role(Map map) {
        initializeHP();
        this.map = map;
    }

    protected void action() {
        if (state != State.NORMAL && --stateEndurance == 0) state = State.NORMAL;
        if (doMove()) {
            move();
            return;
        }
        attack();
    }

    protected abstract void initializeHP();

    protected abstract boolean doMove();

    protected abstract void move();

    public abstract void attack();

    private void setState(State state) {
        this.state = state;
    }

    protected void takeDamage(int HP) {
        this.HP -= HP;
        if (HP <= 0) map.removeObject(x, y);
    }

    private void restoreHP(int HP) {
        this.HP += HP;
    }
}
