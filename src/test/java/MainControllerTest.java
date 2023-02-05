import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


/**
 * @author StarL
 */
class MainControllerTest {

    @Test
    public void givenMainControllerWhenSetTankMoveForwardInButtonThenPressButtonShouldExecuteCommandTankMoveForward() {
        Tank tank = mock(Tank.class);
        MainController mainController = new MainController(new Keyboard(), tank, new Telecom());
        mainController.setShortcut('a', 1);
        mainController.press('a');
        verify(mainController.getTank(), times(1)).moveForward();
    }

    @Test
    public void givenMainControllerWhenSetTankMoveBackwardInButtonThenPressButtonShouldExecuteCommandTankMoveBackward() {
        Tank tank = mock(Tank.class);
        MainController mainController = new MainController(new Keyboard(), tank, new Telecom());
        mainController.setShortcut('a', 2);
        mainController.press('a');
        verify(mainController.getTank(), times(1)).moveBackward();
    }

    @Test
    public void givenMainControllerWhenSetTelecomConnectInButtonThenPressButtonShouldExecuteCommandTelecomConnect() {
        Telecom telecom = mock(Telecom.class);
        MainController mainController = new MainController(new Keyboard(), new Tank(), telecom);
        mainController.setShortcut('a', 3);
        mainController.press('a');
        verify(mainController.getTelecom(), times(1)).connect();
    }

    @Test
    public void givenMainControllerWhenSetTelecomDisconnectInButtonThenPressButtonShouldExecuteCommandTelecomDisconnect() {
        Telecom telecom = mock(Telecom.class);
        MainController mainController = new MainController(new Keyboard(), new Tank(), telecom);
        mainController.setShortcut('a', 3);
        mainController.setShortcut('b', 4);
        mainController.press('a');
        mainController.press('b');
        verify(mainController.getTelecom(), times(1)).connect();
        verify(mainController.getTelecom(), times(1)).disconnect();
    }

    @Test
    public void givenMainControllerWhenSetCommandAndResetThenPressButtonShouldThrowException() {
        Tank tank = mock(Tank.class);
        MainController mainController = new MainController(new Keyboard(), tank, new Telecom());
        mainController.setShortcut('a', 1);
        mainController.setShortcut('r',7);
        mainController.press('r');
        Assertions.assertThrows(IllegalArgumentException.class, () -> mainController.press('a'));
    }
}