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
            this.map.display();
            if(hasWon()) {
                System.out.println("【獲勝】怪物全部消滅！");
                return;
            }
            if(hasLost()) {
                System.out.println("【落敗】角色血量歸零！");
                return;
            }
            map.getCharacter().action();
            for(MapObject[] row: map.getObjects()) {
                for(MapObject object: row) {
                    if (object instanceof Monster) ((Monster) object).action();
                }
            }
        }
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
        return map.getCharacter().getHP() <= 0;
    }
}
