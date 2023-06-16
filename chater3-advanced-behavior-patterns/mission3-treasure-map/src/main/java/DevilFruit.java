/**
 * @author StarL
 */
public class DevilFruit extends Treasure{
    @Override
    public State effect() {
        return State.ORDERLESS;
    }

    @Override
    public double generateProbability() {
        return 0.1;
    }
}
