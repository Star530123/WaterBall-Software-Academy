/**
 * @author StarL
 */
public abstract class Role extends MapObject {
    protected int x;
    protected int y;
    protected Map map;
    private State state = State.NORMAL;
    private int stateEndurance;
    private int HP;

    public Role(Map map, int x, int y) {
        initializeHP();
        this.map = map;
        this.HP = initializeHP();
        this.x = x;
        this.y = y;
    }

    protected void action() {
        if (state != State.NORMAL && --stateEndurance == 0) state = State.NORMAL;
        if (doMove()) {
            move();
            return;
        }
        attack();
    }

    protected abstract int initializeHP();

    protected abstract boolean doMove();

    protected abstract void move();

    public abstract void attack();

    protected void touch(MapObject mapObject) {
        mapObject.touchedBy(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    protected void takeDamage(int HP) {
        this.HP -= HP;
        if (HP <= 0) map.removeObject(x, y);
    }

    private void restoreHP(int HP) {
        this.HP += HP;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
