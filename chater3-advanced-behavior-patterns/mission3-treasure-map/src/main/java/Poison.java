/**
 * @author StarL
 */
public class Poison extends Treasure{
    @Override
    public State effect() {
        return State.POISONED;
    }

    @Override
    public double generateProbability() {
        return 0.25;
    }
}
