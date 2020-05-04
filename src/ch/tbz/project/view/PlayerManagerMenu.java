package ch.tbz.project.view;

import ch.tbz.project.hibernate.model.*;
import ch.tbz.project.manager.PlayerManager;
import ch.tbz.project.manager.TeamManager;
import ch.tbz.project.model.Brand;
import ch.tbz.project.model.Color;
import ch.tbz.project.model.Gender;
import ch.tbz.project.model.Position;
import ch.tbz.project.util.ConsoleReader;

import java.util.ArrayList;

public class PlayerManagerMenu implements IManagerMenu {
  PlayerManager playerManager;
  TeamManager teamManager;

  public PlayerManagerMenu() {
    playerManager = new PlayerManager();
    teamManager = new TeamManager();
  }

  /**
   * Display the question with Menu for Player Manager
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
        Player player = inputPlayerData();
        playerManager.createPlayer(player);
        System.out.println("Player was created");
        break;
      case 2:
        if (playerManager.getPlayers().isEmpty()) {
          System.out.println("Sorry, there are no players created yet");
          break;
        }
        if (teamManager.getTeams().isEmpty()) {
          System.out.println("Sorry, there are no teams created yet");
          break;
        }
        Player getPlayer = getPlayerToAdd();
        Team team = getTeamToRegisterPlayer();
        playerManager.addPlayerToTeam(getPlayer, team);
        System.out.println("Player was added into Team");
        break;
      case 0:
        return;
      default:
        System.out.println("Invalid Entry. Option " + choice + " does not exist");
        break;
    }
    menu();
  }

  /**
   * User input to get Player data for creating a Player
   *
   * @return
   */
  private Player inputPlayerData() {
    String queryFirstname = "Whats the first name?";
    String queryLastname = "Whats the last name?";
    String queryAge = "How old is the player?";
    String queryHeight_cm = "How tall is the player (in cm)?";
    String queryWeight_kg = "How much does the player weight (in kg)?";
    String queryGender = "What's the gender of the player?";
    String queryPosition = "In which position should the player play?";

    String firstname = ConsoleReader.readString(queryFirstname);
    String lastname = ConsoleReader.readString(queryLastname);
    int age = ConsoleReader.readInteger(queryAge);
    int height_cm = ConsoleReader.readInteger(queryHeight_cm);
    int weight_kg = ConsoleReader.readInteger(queryWeight_kg);
    Gender gender = ConsoleReader.readGender(queryGender);
    Position position = ConsoleReader.readPosition(queryPosition);
    Boots boots = inputBoots();

    return new Player(firstname, lastname, age, height_cm, weight_kg, gender, position, null, boots, null);
  }

  /**
   * User input to get Boots data for creating a player
   * It queries for the
   *
   * @return new Instance of Boots
   */
  private Boots inputBoots() {
    String queryBrand = "Select a Brand for the boots";
    String queryColor = "Select a Color for the boots";
    String querySize = "Which size are the boots?";

    Brand brand = ConsoleReader.readBrand(queryBrand);
    Color color = ConsoleReader.readColor(queryColor);
    int size = ConsoleReader.readInteger(querySize);

    return new Boots(brand, color, size);
  }

  /**
   * Gets the player from database that gets added into a team
   *
   * @return player
   */
  private Player getPlayerToAdd() {
    ArrayList<Player> players = playerManager.getPlayers();
    Player player;

    while (true) {
      int i = 1;
      for (Player p : players) {
        System.out.println("[" + i + "]" + p.getFirstname() + " " + p.getLastname() +
            " --- " + p.getGender() + " --- " + p.getPosition());
        i++;
      }

      String queryPlayer = "Choose Player to add";

      int index = ConsoleReader.readInteger(queryPlayer);

      try {
        player = players.get(index - 1);
      } catch (IndexOutOfBoundsException arrayex) {
        System.out.println("Invalid index. Player with index " + index + " does not exist");
        continue;
      }
      break;
    }

    return player;
  }

  /**
   * User chooses team from database, where player gets added
   * @return team
   */
  private Team getTeamToRegisterPlayer() {
    ArrayList<Team> teams = teamManager.getTeams();
    Team team;

    while (true) {
      int i = 1;
      for (Team t : teams) {
        System.out.println("[" + i + "]" + t.getTeamname());
        i++;
      }

      String queryTeam = "Choose Team to register the player";

      int index = ConsoleReader.readInteger(queryTeam);

      try {
        team = teams.get(index - 1);
      } catch (IndexOutOfBoundsException arrayex) {
        System.out.println("Invalid index. Team with index " + index + " does not exist");
        continue;
      }
      break;
    }
    return team;
  }


  /**
   * Returns Listed Menu with Options
   *
   * @return menu
   */
  private String optionsMenu() {
    return
        "[1] Create Player\n" +
            "[2] Add Player to Team\n" +
            "[0] Exit\n";
  }
}
