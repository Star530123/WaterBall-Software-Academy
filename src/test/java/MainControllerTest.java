import command.ConnectTelecomCommand;
import command.DisconnectTelecomCommand;
import command.MoveTankBackwardCommand;
import command.MoveTankForwardCommand;
import command.ResetMainControlKeyboardCommand;
import invoker.Keyboard;
import invoker.MainController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import receiver.Tank;
import receiver.Telecom;

import static org.mockito.Mockito.*;


/**
 * @author StarL
 */
class MainControllerTest {

    @Test
    public void givenMainControllerWhenSetTankMoveForwardInButtonThenPressButtonShouldExecuteCommandTankMoveForward() {
        Tank tank = mock(Tank.class);
        MoveTankForwardCommand moveTankForwardCommand = new MoveTankForwardCommand(tank);
        MainController mainController = new MainController(new Keyboard());
        mainController.setShortcut('a', moveTankForwardCommand);
        mainController.press('a');
        verify(tank, times(1)).moveForward();
    }

    @Test
    public void givenMainControllerWhenSetTankMoveBackwardInButtonThenPressButtonShouldExecuteCommandTankMoveBackward() {
        Tank tank = mock(Tank.class);
        MoveTankBackwardCommand moveTankBackwardCommand = new MoveTankBackwardCommand(tank);
        MainController mainController = new MainController(new Keyboard());
        mainController.setShortcut('a', moveTankBackwardCommand);
        mainController.press('a');
        verify(tank, times(1)).moveBackward();
    }

    @Test
    public void givenMainControllerWhenSetTelecomConnectInButtonThenPressButtonShouldExecuteCommandTelecomConnect() {
        Telecom telecom = mock(Telecom.class);
        ConnectTelecomCommand connectTelecomCommand = new ConnectTelecomCommand(telecom);
        MainController mainController = new MainController(new Keyboard());
        mainController.setShortcut('a', connectTelecomCommand);
        mainController.press('a');
        verify(telecom, times(1)).connect();
    }

    @Test
    public void givenMainControllerWhenSetTelecomDisconnectInButtonThenPressButtonShouldExecuteCommandTelecomDisconnect() {
        Telecom telecom = mock(Telecom.class);
        ConnectTelecomCommand connectTelecomCommand = new ConnectTelecomCommand(telecom);
        DisconnectTelecomCommand disconnectTelecomCommand = new DisconnectTelecomCommand(telecom);
        MainController mainController = new MainController(new Keyboard());
        mainController.setShortcut('a', connectTelecomCommand);
        mainController.setShortcut('b', disconnectTelecomCommand);
        mainController.press('a');
        mainController.press('b');
        verify(telecom, times(1)).connect();
        verify(telecom, times(1)).disconnect();
    }

    @Test
    public void givenMainControllerWhenSetCommandAndResetThenPressButtonShouldThrowException() {
        Tank tank = mock(Tank.class);
        MoveTankForwardCommand moveTankForwardCommand = new MoveTankForwardCommand(tank);
        MainController mainController = new MainController(new Keyboard());
        ResetMainControlKeyboardCommand resetMainControlKeyboardCommand = new ResetMainControlKeyboardCommand(mainController);
        mainController.setShortcut('a', moveTankForwardCommand);
        mainController.setShortcut('r',resetMainControlKeyboardCommand);
        mainController.press('r');
        Assertions.assertThrows(IllegalArgumentException.class, () -> mainController.press('a'));
    }
}