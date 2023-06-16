/**
 * @author StarL
 */
public class DokodemoDoor extends Treasure{
    @Override
    public State effect() {
        return State.TELEPORT;
    }

    @Override
    public double generateProbability() {
        return 0.1;
    }
}
