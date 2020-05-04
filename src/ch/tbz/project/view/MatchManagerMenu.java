package ch.tbz.project.view;

import ch.tbz.project.manager.MatchManager;
import ch.tbz.project.util.ConsoleReader;

public class MatchManagerMenu implements IManagerMenu {
  private MatchManager matchManager;

  public MatchManagerMenu() {
    this.matchManager = new MatchManager();
  }

  /**
   * Display the question with Menu for Match Manager
   * Reads User Input for choice made
   */
  @Override
  public void menu() {
    String question = "What do you want to do?";
    String menu = optionsMenu();
    int choice = ConsoleReader.readInteger(question + "\n\n" + menu);
    runOption(choice);
  }

  /**
   * Runs the option with the choice made at the manager menu
   *
   * @param choice Input from User to select option
   */
  private void runOption(int choice) {
    switch (choice) {
      case 1:

        break;
      case 2:
        break;
      case 3:
        break;
      case 4:
        break;
      case 0:
        return;
      default:
    }
  }

  /**
   * Displays the Menu when a match is organized
   * The choice made gets executed
   * If there are no matches, it returns to the previous menu
   */
  private void organizeMatch() {
    String organizeMatchMenu = organizeMatchMenu();
    int choice = ConsoleReader.readInteger(organizeMatchMenu);
    executeChoice(choice);
  }

  private void executeChoice(int choice) {
    switch (choice) {
      case 1:
        organizeMatch();
      case 2:
        organizeMatch();
      case 3:
        organizeMatch();
      case 0:
        return;
      default:
        System.out.println("Choice is invalid");
        organizeMatch();
    }
  }

  private void createMatch(){
    String queryMatchDate = "When should the Match occur?";
    String queryFirstTeam = "Select the First Team to play";
    String querySecondTeam = "Select the Second Team to play";



  }

  /**
   * Returns Listed Menu with Options
   *
   * @return menu
   */
  private String optionsMenu() {
    return
        "[1] Organize Match\n" +
            "[2] List played matches\n" +
            "[3] List matches to play\n" +
            "[4] List all matches\n" +
            "[0] Exit\n";
  }

  private String organizeMatchMenu() {
    return
        "[1] Create a Match\n" +
            "[2] Play Match\n" +
            "[3] Cancel Match\n" +
            "[0] Exit\n";
  }
}
