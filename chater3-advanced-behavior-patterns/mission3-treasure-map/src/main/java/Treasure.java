/**
 * @author StarL
 */
public abstract class Treasure extends MapObject {

    @Override
    public String display() {
        return "x";
    }

    public abstract State effect();

    public abstract double generateProbability();
}
