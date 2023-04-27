package command;

import receiver.Telecom;

/**
 * @author StarL
 */
public class DisconnectTelecomCommand implements Command{
    private final Telecom telecom;

    public DisconnectTelecomCommand(Telecom telecom) {
        this.telecom = telecom;
    }

    @Override
    public void execute() {
        telecom.disconnect();
    }

    @Override
    public void redo() {
        telecom.connect();
    }

    @Override
    public String name() {
        return "DisconnectTelecom";
    }
}
