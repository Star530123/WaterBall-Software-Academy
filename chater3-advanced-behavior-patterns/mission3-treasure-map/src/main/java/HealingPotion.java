/**
 * @author StarL
 */
public class HealingPotion extends Treasure{
    @Override
    public State effect() {
        return State.HEALING;
    }

    @Override
    public double generateProbability() {
        return 0.15;
    }
}
