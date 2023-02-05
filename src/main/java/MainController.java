/**
 * @author StarL
 */
public class MainController {
    private Keyboard keyboard;
    private Tank tank;
    private Telecom telecom;

    public MainController(Keyboard keyboard, Tank tank, Telecom telecom) {
        this.keyboard = keyboard;
        this.tank = tank;
        this.telecom = telecom;
    }

    public void setShortcut(char button, int command) {
        keyboard.setCommand(button, command);
    }

    public Tank getTank() {
        return tank;
    }

    public Telecom getTelecom() {
        return telecom;
    }

    public void press(char button) {
        int command = keyboard.getCommand(button);
        switch (command){
            case 1:
                tank.moveForward();
                return;
            case 2:
                tank.moveBackward();
                return;
            case 3:
                telecom.connect();
                return;
            case 4:
                telecom.disconnect();
                return;
            case 5:
                redo();
                return;
            case 6:
                undo();
                return;
            case 7:
                reset();
                return;
            default:
                throw new IllegalArgumentException("Unexpected command!");
        }
    }

    private void reset() {
        System.out.println("Reset keyboard!");
        keyboard.resetKeyboard();
    }

    private void undo() {
    }

    private void redo() {
    }
}
