import java.util.Scanner;

/**
 * @author StarL
 */
public class Main {
  public static void main(String[] args) {
    MainController mainController = new MainController(new Keyboard(), new Tank(), new Telecom());
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("(1) 快捷鍵設置 (2) Undo (3) Redo (字母) 按下按鍵:");
      char operation = scanner.nextLine().charAt(0);
      switch (operation) {
        case '1':
          System.out.println("設置巨集指令 (y/n)：");
          boolean doesSetMarco = scanner.nextLine().equals("y");
          if (doesSetMarco) System.out.println("巨集指令開發中~~");
          else {
            System.out.println("Button(a~z): ");
            String input = scanner.nextLine();
            char button = input.charAt(0);
            if (input.length() != 1 || !(button - 'a' >= 0 && button - 'a' <= 25))
              throw new IllegalArgumentException("輸入錯誤的按鍵，請重來");
            System.out.printf("要將哪一道指令設置到快捷鍵 %c 上:\n", button);
            System.out.println(
                "(1) MoveTankForward\n"
                    + "(2) MoveTankBackward\n"
                    + "(3) ConnectTelecom\n"
                    + "(4) DisconnectTelecom\n"
                    + "(5) ResetMainControlKeyboard");
            int command = Integer.parseInt(scanner.nextLine());
            mainController.setShortcut(button, command);
          }
          break;
        default:
            mainController.press(operation);
            break;
      }
    }
  }
}
