/**
 * @author StarL
 */
public class Character extends Role{
    private Direction direction;

    @Override
    public String display() {
        return direction.icon;
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
