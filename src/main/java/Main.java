import command.Command;
import command.ConnectTelecomCommand;
import command.DisconnectTelecomCommand;
import command.MoveTankBackwardCommand;
import command.MoveTankForwardCommand;
import command.ResetMainControlKeyboardCommand;
import invoker.Keyboard;
import invoker.MainController;
import receiver.Tank;
import receiver.Telecom;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author StarL
 */
public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController(new Keyboard());
        Tank tank = new Tank();
        Telecom telecom = new Telecom();
        Command[] totalCommands = new Command[5];
        totalCommands[0] = new MoveTankForwardCommand(tank);
        totalCommands[1] = new MoveTankBackwardCommand(tank);
        totalCommands[2] = new ConnectTelecomCommand(telecom);
        totalCommands[3] = new DisconnectTelecomCommand(telecom);
        totalCommands[4] = new ResetMainControlKeyboardCommand(mainController);
        String commandInstruction = IntStream.range(0, totalCommands.length)
                .mapToObj(i -> String.format("(%d) %s%n", i, totalCommands[i].name()))
                .collect(Collectors.joining());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mainController.showAvailableButtons();
            System.out.println("(1) 快捷鍵設置 (2) Undo (3) Redo (字母) 按下按鍵:");
            char operation = scanner.nextLine().charAt(0);
            switch (operation) {
                case '1':
                    System.out.println("設置巨集指令 (y/n)：");
                    boolean doesSetMarco = scanner.nextLine()
                            .equals("y");
                    if (doesSetMarco) System.out.println("巨集指令開發中~~");
                    else {
                        System.out.println("Button(a~z): ");
                        String input = scanner.nextLine();
                        char button = input.charAt(0);
                        if (input.length() != 1 || button - 'a' < 0 || button - 'a' > 25) {
                            System.out.println("輸入錯誤的按鍵，請重來");
                            continue;
                        }
                        System.out.printf("要將哪一道指令設置到快捷鍵 %c 上:\n", button);
                        System.out.println(commandInstruction);
                        int i = Integer.parseInt(scanner.nextLine());
                        mainController.setShortcut(button, totalCommands[i]);
                    }
                    break;
                case '2':
                    mainController.undo();
                    break;
                case '3':
                    mainController.redo();
                    break;
                default:
                    try {
                        mainController.press(operation);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            System.out.println("=====================================");
        }
    }
}
