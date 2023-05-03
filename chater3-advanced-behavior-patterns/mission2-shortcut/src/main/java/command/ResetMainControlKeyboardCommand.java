package command;

import invoker.Keyboard;
import invoker.MainController;

/**
 * @author StarL
 */
public class ResetMainControlKeyboardCommand implements Command {
    private final Keyboard keyboard;
    private Command[] previousKeyboardButtons;

    public ResetMainControlKeyboardCommand(MainController mainController) {
        this.keyboard = mainController.getKeyboard();
    }

    @Override
    public void execute() {
        previousKeyboardButtons = keyboard.getButtons();
        keyboard.setButtons(keyboard.initializeButtons());
        System.out.println("Reset keyboard successfully!");
    }

    @Override
    public void undo() {
        keyboard.setButtons(previousKeyboardButtons);
        previousKeyboardButtons = keyboard.initializeButtons();
    }

    @Override
    public String name() {
        return "ResetMainControlKeyboard";
    }
}
