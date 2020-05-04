package ch.tbz.project.view;

import ch.tbz.project.util.ConsoleReader;

import java.util.logging.Level;
import java.util.logging.LogManager;

public class Main {

  public static void main(String[] args) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);

    boolean isRunning = true;
    while (isRunning) {
      System.out.println("Choose what to manage");

      String menu =
          "[1] Manage Player\n" +
              "[2] Manage Team\n" +
              "[3] Manage Match\n" +
              "[0] Exit\n\n";

      int choice = ConsoleReader.readInteger(menu);
      isRunning = navigateToManager(choice);
    }
  }

  /**
   * Navigates to Manager Menu by choice made
   * And returns boolean if menu should show up again
   *
   * @param choice
   * @return boolean if menu should show up again
   */
  private static boolean navigateToManager(int choice) {
    IManagerMenu managerMenu;
    switch (choice) {
      case 1:
       managerMenu = new PlayerManagerMenu();
        break;
      case 2:
        managerMenu = new TeamManagerMenu();
        break;
      case 3:
        managerMenu = new MatchManagerMenu();
        break;
      case 0:
        return false;
      default:
        System.out.println("Choice invalid");
        return true;
    }
    managerMenu.menu();
    return true;
  }
}
