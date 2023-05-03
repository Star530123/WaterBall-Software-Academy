package command;

import receiver.Tank;

/**
 * @author StarL
 */
public class MoveTankForwardCommand implements Command{
    private final Tank tank;

    public MoveTankForwardCommand(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void execute() {
        tank.moveForward();
    }

    @Override
    public void undo() {
        tank.moveBackward();
    }

    @Override
    public String name() {
        return "MoveTankForward";
    }
}
