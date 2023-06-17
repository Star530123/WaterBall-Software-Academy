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
        return direction.getIcon();
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
        int x = this.x + d.getDistance()[0];
        int y = this.y + d.getDistance()[1];
        if(moveSuccessfully(x, y)) this.direction = d;
        else {
            System.out.println("【錯誤】移動失敗，請重新輸入");
            move();
        }
    }

    @Override
    public void attack() {

    }

    @Override
    protected void takeDamage(int HP) {

    }
}
