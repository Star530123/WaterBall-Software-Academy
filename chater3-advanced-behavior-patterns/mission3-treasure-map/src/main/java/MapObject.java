/**
 * @author StarL
 */
public abstract class MapObject {
    protected int x;
    protected int y;

    public abstract String display();

    public void touchedBy(Role role) {
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
