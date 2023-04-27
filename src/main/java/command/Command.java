package command;

/**
 * @author StarL
 */
public interface Command {
    void execute();

    void redo();

    String name();
}
