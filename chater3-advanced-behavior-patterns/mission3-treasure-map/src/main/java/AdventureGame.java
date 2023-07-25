import java.util.Arrays;

/**
 * @author StarL
 */
public class AdventureGame {
    private final Map map;

    public AdventureGame(int mapSize) {
        this.map = new Map(mapSize);
    }

    public void start() {
        System.out.println("【遊戲開始】");
        System.out.println("【地圖初始化】");
        this.map.initializeMap();
        while(true) {
            System.out.println("【新的回合開始】");
            this.map.display();
            map.getCharacter().action();
            if (isGameOver()) break;
            for(MapObject[] row: map.getObjects()) {
                for(MapObject object: row) {
                    if (object instanceof Monster) ((Monster) object).action();
                    if (isGameOver()) break;
                }
            }
        }
    }

    private boolean isGameOver() {
        if(hasWon()) {
            System.out.println("【獲勝】怪物全部消滅！");
            return true;
        }
        if(hasLost()) {
            System.out.println("【落敗】角色血量歸零！");
            return true;
        }
        return false;
    }

    private boolean hasWon() {
        for(MapObject[] row: map.getObjects()) {
            for(MapObject object: row) {
                if (object instanceof Monster) return false;
            }
        }
        return true;
    }

    private boolean hasLost() {
        return map.getCharacter().isDead();
    }
}
