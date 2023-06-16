/**
 * @author StarL
 */
public class KingsRock extends Treasure{
    @Override
    public State effect() {
        return State.STOCKPILE;
    }

    @Override
    public double generateProbability() {
        return 0.1;
    }
}
