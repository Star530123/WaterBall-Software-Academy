import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author StarL
 */
public enum Direction {
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

    public static List<int[]> moveDistances() {
        return Arrays.stream(values())
                .map(d -> d.distance)
                .collect(Collectors.toList());
    }

    public int[] getDistance() {
        return distance;
    }

    public String getIcon() {
        return icon;
    }
}
