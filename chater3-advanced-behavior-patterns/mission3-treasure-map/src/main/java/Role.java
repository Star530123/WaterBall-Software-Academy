/**
 * @author StarL
 */
public abstract class Role extends MapObject {
    protected int x;
    protected int y;
    protected Map map;
    protected State state = State.NORMAL;
    protected int stateEndurance;
    protected int HP;

    public Role(Map map, int x, int y) {
        fullHP();
        this.map = map;
        this.HP = fullHP();
        this.x = x;
        this.y = y;
    }

    protected void action() {
        beforeAction();
        if (isDead()) return;
        if (this.state != State.ORDERLESS)
            chooseAction();
        else
            moveRestrictively();
        afterAction();
    }

    private void moveRestrictively() {
//        TODO
        System.out.println("每回合隨機取得以下其中一種效果：1. 只能進行上下移動 2. 只能進行左右移動（角色只能移動，不能選擇做其他操作）");
    }

    public boolean isDead() {
        return this.HP <= 0;
    }

    private void beforeAction() {
        if (this.state == State.HEALING) {
            restoreHP(30);
            if (HP >= fullHP()) {
                this.HP = fullHP();
                setState(State.NORMAL);
            }
        }
        if (this.state == State.POISONED) takeDamage(15);
        this.stateEndurance--;
        if (stateEndurance == 0) {
            switch (this.state) {
                case STOCKPILE:
                    setState(State.ERUPTING);
                    break;
                case ERUPTING:
                    setState(State.TELEPORT);
                    break;
                case TELEPORT:
                    moveRandomly();
                default:
                    setState(State.NORMAL);
                    break;
            }
        }
    }

    private void moveRandomly() {
//        TODO
        System.out.println("一回合後角色的位置將被隨機移動至任一空地");
    }

    private void chooseAction() {
        if (doMove()) {
            move();
            return;
        }
        if (this.state == State.ERUPTING)
            attackGlobally();
        else attack();
    }

    private void attackGlobally() {
//        TODO
        System.out.println("角色的攻擊範圍擴充至「全地圖」，且攻擊行為變成「全場攻擊」：每一次攻擊時都會攻擊到地圖中所有其餘角色，且攻擊力為50。三回合過後取得瞬身狀態。");
    }

    private void afterAction() {
        if (this.state == State.ACCELERATED) chooseAction();
    }

    protected abstract int fullHP();

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
        if(state == State.NORMAL) this.stateEndurance = -1;
    }

    protected void takeDamage(int HP) {
        if (this.state == State.INVINCIBLE) return;
        this.HP -= HP;
        if (HP <= 0) map.removeObject(x, y);
        if (this.state == State.ACCELERATED || this.state == State.STOCKPILE) setState(State.NORMAL);
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
