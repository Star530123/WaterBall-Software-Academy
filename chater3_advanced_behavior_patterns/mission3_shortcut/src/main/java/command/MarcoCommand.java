package command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author StarL
 */
public class MarcoCommand implements Command {
    private final List<Command> commands;

    public MarcoCommand(Command[] totalCommands, String[] rawCommands) {
        this.commands = Arrays.stream(rawCommands)
                .map(Integer::valueOf)
                .filter(i -> i >= 0 && i < totalCommands.length)
                .map(i -> totalCommands[i])
                .collect(Collectors.toList());
        if (this.commands.size() != rawCommands.length) throw new IllegalArgumentException("You typed unsupported commands.");
    }

    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }

    @Override
    public void undo() {
        commands.forEach(Command::undo);
    }

    @Override
    public String name() {
        return "Marco";
    }
}
