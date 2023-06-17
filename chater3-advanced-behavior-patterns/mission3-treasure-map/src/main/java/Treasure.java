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
        System.out.printf("【找到寶藏】角色%s找到寶藏%s%n", role.getClass().getName(), this.getClass().getName());
        role.setState(effect());
    }

    public abstract State effect();

    public abstract double generateProbability();
}
