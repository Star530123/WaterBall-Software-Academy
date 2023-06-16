/**
 * @author StarL
 */
public class SuperStar extends Treasure {
    @Override
    public State effect() {
        return State.INVINCIBLE;
    }

    @Override
    public double generateProbability() {
        return 0.1;
    }
}
