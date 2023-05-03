package command;

import receiver.Tank;

/**
 * @author StarL
 */
public class MoveTankBackwardCommand implements Command{
    private final Tank tank;

    public MoveTankBackwardCommand(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void execute() {
        tank.moveBackward();
    }

    @Override
    public void undo() {
        tank.moveForward();
    }

    @Override
    public String name() {
        return "MoveTankBackward";
    }
}
