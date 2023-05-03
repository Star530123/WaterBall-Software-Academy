package invoker;

import command.Command;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author StarL
 */
public class MainController {
    private final Keyboard keyboard;
    private final Stack<Character> undoStack = new Stack<>();
    private final Stack<Character> redoStack = new Stack<>();

    public MainController(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void setShortcut(char button, Command command) {
        keyboard.setCommand(button, command);
    }

    public void press(char button) {
        keyboard.execute(button);
        undoStack.push(button);
        redoStack.clear();
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
        if(undoStack.empty()) {
            System.out.println("There is no undo command.");
            return;
        }
        char button = undoStack.pop();
        keyboard.undo(button);
        redoStack.push(button);
    }

    public void redo() {
        if(redoStack.empty()) {
            System.out.println("There is no redo command.");
            return;
        }
        char button = redoStack.pop();
        keyboard.execute(button);
        undoStack.push(button);
    }
}
