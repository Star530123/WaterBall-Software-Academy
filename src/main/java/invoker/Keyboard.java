package invoker;

import command.Command;

/**
 * @author StarL
 */
public class Keyboard {
    private Command[] buttons;

    public Keyboard(){
        buttons = initializeButtons();
    }

    public void setCommand(char button, Command command) {
        buttons[convert(button)] = command;
    }

    public Command getCommand(char button) {
        return buttons[convert(button)];
    }

    public Command[] initializeButtons() {
        return new Command[26];
    }

    public Command[] getButtons() {
        return buttons;
    }

    public void setButtons(Command[] buttons) {
        this.buttons = buttons;
    }

    private int convert(char button) {
        int index = button - 'a';
        if (index < 0 || index >= 26) throw new IllegalArgumentException("Unexpected button! Please press button again.");
        return index;
    }
}
