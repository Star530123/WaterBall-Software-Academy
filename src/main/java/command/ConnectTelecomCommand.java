package command;

import receiver.Telecom;

/**
 * @author StarL
 */
public class ConnectTelecomCommand implements Command{
    private final Telecom telecom;

    public ConnectTelecomCommand(Telecom telecom) {
        this.telecom = telecom;
    }

    @Override
    public void execute() {
        telecom.connect();
    }

    @Override
    public void redo() {
        telecom.disconnect();
    }

    @Override
    public String name() {
        return "ConnectTelecom";
    }
}
