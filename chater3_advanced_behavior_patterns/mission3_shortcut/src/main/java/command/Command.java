package command;

/**
 * @author StarL
 */
public interface Command {
    void execute();

    void undo();

    String name();
}
