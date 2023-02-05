/**
 * @author StarL
 */
public class Keyboard {
    private int[] buttons = new int[26];

    public void setCommand(char button, int command) {
        buttons[convert(button)] = command;
    }

    public int getCommand(char button) {
        return buttons[convert(button)];
    }

    public void resetKeyboard() {
        buttons = new int[26];
    }

    private int convert(char button) {
        int index = button - 'a';
        if (index < 0 || index >= 26) throw new IllegalArgumentException("Unexpected button! Please press button again.");
        return index;
    }
}
