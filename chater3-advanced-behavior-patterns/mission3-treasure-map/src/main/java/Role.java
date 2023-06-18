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

    protected boolean moveSuccessfully(int newX, int newY) {
        if(map.isOutOfRange(newX, newY)) {
            System.out.println("【錯誤】此移動會超出地圖範圍，請重新輸入");
            return false;
        }
        MapObject mapObject = map.getObjects()[newX][newY];
        if(mapObject != null) touch(mapObject);
        else this.map.moveRole(this, newX, newY);
        return true;
    }

    public abstract void attack();

    protected void touch(MapObject mapObject) {
        System.out.printf("【觸碰】角色%s觸碰到%s%n", this.getClass().getName(), mapObject.getClass().getName());
        mapObject.touchedBy(this);
    }

    public void setState(State state) {
        System.out.printf("【狀態改變】角色%s改變狀態，從%s變更為%s%n",
                this.getClass().getName(),
                this.state.getClass().getName(),
                state.getClass().getName());
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

    public int getHP() {
        return HP;
    }
}
