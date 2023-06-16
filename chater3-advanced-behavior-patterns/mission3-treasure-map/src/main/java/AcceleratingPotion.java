/**
 * @author StarL
 */
public class AcceleratingPotion extends Treasure{
    @Override
    public State effect() {
        return State.ACCELERATED;
    }

    @Override
    public double generateProbability() {
        return 0.2;
    }
}
