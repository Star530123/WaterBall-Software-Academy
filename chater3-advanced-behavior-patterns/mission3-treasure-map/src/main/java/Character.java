import java.util.Arrays;
import java.util.Scanner;

/**
 * @author StarL
 */
public class Character extends Role{
    private Direction direction;
    private final Scanner SCANNER = new Scanner(System.in);

    public Character(Map map, int x, int y) {
        super(map, x, y);
    }

    @Override
    public String display() {
        return direction.icon;
    }

    @Override
    protected int initializeHP() {
        return 300;
    }

    @Override
    protected boolean doMove() {
        System.out.println("【選擇動作】要讓角色移動嗎? (y/n)");
        return SCANNER.next().trim().equalsIgnoreCase("y");
    }

    @Override
    protected void move() {
        System.out.println("【移動】請選擇移動方向(↑←↓→，移動距離為1格)");
        String icon = SCANNER.next().trim();
        Direction d = Direction.findByIcon(icon);
        if(d == null) {
            System.out.println("【錯誤】無此行進方向，請重新輸入");
            move();
            return;
        }
        int x = this.x + d.distance[0];
        int y = this.y + d.distance[1];
        if(x < 0 || y < 0 || x >= map.getObjects().length || y >= map.getObjects()[0].length) {
            System.out.println("【錯誤】已超出地圖範圍，請重新輸入");
            move();
        }
        MapObject mapObject = map.getObjects()[x][y];
        if(mapObject != null) touch(mapObject);
        else this.map.moveRole(this, x, y);
        this.direction = d;
    }

    @Override
    public void attack() {

    }

    @Override
    protected void takeDamage(int HP) {

    }

    private enum Direction {
        UP("↑", new int[]{0, -1}),
        LEFT("←", new int[]{-1, 0}),
        DOWN("↓", new int[]{0, 1}),
        RIGHT("→", new int[]{1, 0});

        private String icon;
        private int[] distance;

        Direction(String icon, int[] distance) {
            this.icon = icon;
            this.distance = distance;
        }

        public static Direction findByIcon(String icon) {
            return Arrays.stream(values())
                    .filter(d -> d.icon.equals(icon))
                    .findFirst()
                    .orElse(null);
        }
    }
}
