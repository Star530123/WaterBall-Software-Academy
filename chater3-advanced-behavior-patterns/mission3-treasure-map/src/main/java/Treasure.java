/**
 * @author StarL
 */
public abstract class Treasure extends MapObject {

    @Override
    public String display() {
        return "x";
    }

    @Override
    public void touchedBy(Role role) {
        role.setState(effect());
    }

    public abstract State effect();

    public abstract double generateProbability();
}
