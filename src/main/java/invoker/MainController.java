package invoker;

import command.Command;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author StarL
 */
public class MainController {
    private final Keyboard keyboard;

    public MainController(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void setShortcut(char button, Command command) {
        keyboard.setCommand(button, command);
    }

    public void press(char button) {
        Command command = keyboard.getCommand(button);
        if (command == null) throw new IllegalArgumentException("Non-provided button");
        command.execute();
    }

    public void showAvailableButtons() {
        Command[] buttons = keyboard.getButtons();
        String instruction = IntStream.range(0, buttons.length)
                .filter(i -> buttons[i] != null)
                .mapToObj(i -> String.format("%s: %s%n", (char)('a' + i), buttons[i].name()))
                .collect(Collectors.joining());
        System.out.print(instruction);
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void undo() {
//        TODO
    }

    public void redo() {
//        TODO
    }
}
