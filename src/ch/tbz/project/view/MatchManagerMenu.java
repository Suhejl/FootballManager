package ch.tbz.project.view;

import ch.tbz.project.hibernate.model.FootballMatch;
import ch.tbz.project.hibernate.model.Team;
import ch.tbz.project.manager.MatchManager;
import ch.tbz.project.manager.TeamManager;
import ch.tbz.project.model.MatchState;
import ch.tbz.project.util.ConsoleReader;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MatchManagerMenu implements IManagerMenu {
  private MatchManager matchManager;
  private TeamManager teamManager;

  public MatchManagerMenu() {
    this.matchManager = new MatchManager();
    this.teamManager = new TeamManager();
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
        organizeMatch();
        menu();
        break;
      case 2:
        displayPlayedMatches();
        menu();
        break;
      case 3:
        displayMatchesToPlay();
        menu();
        break;
      case 4:
        displayCancelledMatches();
        menu();
        break;
      case 5:
        displayAllMatches();
        menu();
        break;
      case 0:
        return;
      default:
        System.out.println("Invalid input");
        menu();
        break;
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

  /**
   * Executes the choice made in organizing the match
   * @param choice choice made in previous method
   */
  private void executeChoice(int choice) {
    switch (choice) {
      case 1:
        createMatch();
        organizeMatch();
        break;
      case 2:
        playMatch();
        organizeMatch();
        break;
      case 3:
        cancelMatch();
        organizeMatch();
        break;
      case 0:
        break;
      default:
        System.out.println("Choice is invalid");
        organizeMatch();
        break;
    }
  }

  /**
   * Asks the user for match data to create a match
   * If there are less than 2 teams, a match can't be created
   * If the matchDate overlaps with the training of the selected team, the match can't be created
   *
   * */
  private void createMatch() {
    if (teamManager.getTeams().size() < 2) {
      System.out.println("Sorry, but there are not enough teams to create a match");
      return;
    }

    String queryMatchDate = "When should the Match occur?";

    LocalDateTime matchDate = ConsoleReader.readLocalDateTime(queryMatchDate);
    ArrayList<Team> teams = teamManager.getTeams();
    Team firstTeam;
    Team secondTeam;
    while (true) {
      if (ConsoleReader.readInteger("Enter a number 0 or below if you want to leave now") < 1) organizeMatch();

      firstTeam = selectTeam(teams, matchDate, "Choose First Team to add to the match");
      secondTeam = selectTeam(teams, matchDate, "Choose Second Team to add to the match");

      if (firstTeam.getTeam_ID() == secondTeam.getTeam_ID()) {
        System.out.println("Please select two different Teams");
        continue;
      }

      break;
    }

    FootballMatch match = new FootballMatch(firstTeam, secondTeam, 0, 0, matchDate, MatchState.TO_PLAY);
    matchManager.createMatch(match);
    System.out.println("Match created successfully");
  }

  /**
   * Selects a team with a query to the User to create a match. It checks the team's training sessions, if it overlaps with the matchDate.
   * If so, user has to select different team.
   * @param teams all the teams in the database
   * @param matchDate matchDate
   * @param queryChooseTeam the question asked or the query to the user
   * @return selected team
   */
  private Team selectTeam(ArrayList<Team> teams, LocalDateTime matchDate, String queryChooseTeam) {
    Team firstTeam;
    while (true) {
      if (ConsoleReader.readInteger("Enter a number 0 or below if you want to leave now") < 1) organizeMatch();
      displayTeams();

      int indexFirstTeam = ConsoleReader.readInteger(queryChooseTeam);

      try {
        firstTeam = teams.get(indexFirstTeam - 1);
      } catch (IndexOutOfBoundsException inex) {
        System.out.println("Invalid index. Team with index " + indexFirstTeam + " does not exist");
        continue;
      }

      LocalTime firstTeamTrainingStart = firstTeam.getID_TrainingPlan().getTrainingStart().toLocalTime().minusMinutes(15);
      LocalTime firstTeamTrainingEnd = firstTeam.getID_TrainingPlan().getTrainingEnd().toLocalTime().plusMinutes(15);

      if (matchDate.toLocalTime().isAfter(firstTeamTrainingStart) && matchDate.toLocalTime().isBefore(firstTeamTrainingEnd)) {
        System.out.println("The team can't be selected, since the match date clashes with its training");
        continue;
      }

      break;
    }
    return firstTeam;

  }

  /**
   * Collects the user input and data to play a match
   * The score for the teams needs to be between 0 and 100, to be realistic
   * MatchStatus gets updated from TO_PLAY to PLAYED
   */
  private void playMatch() {
    if(noMatchesToPlay()) return;;

    List<FootballMatch> matchesToPlay = matchManager.getMatchesToPlay();

    FootballMatch match = selectMatch(matchesToPlay, "Choose Match to play");

    int firstTeamScore;
    do {
      firstTeamScore = ConsoleReader.readInteger("What's the score of the first Team?");
    } while (firstTeamScore < 0 || 100 < firstTeamScore);

    int secondTeamScore;
    do {
      secondTeamScore = ConsoleReader.readInteger("What's the score of the second Team?");
    } while (secondTeamScore < 0 || 100 < secondTeamScore);

    match.setFirstTeamScore(firstTeamScore);
    match.setSecondTeamScore(secondTeamScore);
    match.setState(MatchState.PLAYED);

    matchManager.playMatch(match);
    System.out.println("Match has been successfully played");
  }

  /**
   * Select a match that needs to be played, so that it can be cancelled
   * MatchStatus updates from TO_PLAY to CANCELLED
   */
  private void cancelMatch() {
    if(noMatchesToPlay()) return;

    List<FootballMatch> matchesToPlay = matchManager.getMatchesToPlay();

    FootballMatch match = selectMatch(matchesToPlay, "Choose Match to cancel");

    match.setState(MatchState.CANCELLED);
    matchManager.cancelMatch(match);
    System.out.println("Match has been successfully cancelled");
  }

  /**
   * User selects a match from the matches to play
   * @param matchesToPlay matches to play
   * @param queryToUser query to user
   * @return match
   */
  private FootballMatch selectMatch(List<FootballMatch> matchesToPlay, String queryToUser) {
    FootballMatch match;

    while (true) {
      displayMatchesToPlay();

      int indexMatchToPlay = ConsoleReader.readInteger(queryToUser);

      try {
        match = matchesToPlay.get(indexMatchToPlay - 1);
      } catch (IndexOutOfBoundsException inex) {
        System.out.println("Invalid index. Team with index " + indexMatchToPlay + " does not exist");
        continue;
      }

      break;
    }
    return match;
  }

  /**
   * Displays the matches that needs to be played
   */
  private void displayMatchesToPlay() {
    List<FootballMatch> matchesToPlay = matchManager.getMatchesToPlay();

    if(matchesToPlay.isEmpty()) {
      System.out.println("Sorry, there are no matches to play");
      return;
    }

    int i = 1;
    for (FootballMatch match : matchesToPlay) {
      System.out.println("[" + i + "]\t" + match.getId_FirstTeam().getTeamname() + " vs " + match.getId_SecondTeam().getTeamname()
          + " ---- " + match.getMatchdate().toString());
      i++;
    }
  }

  /**
   * Displays the matches that has been played
   */
  private void displayPlayedMatches() {
    List<FootballMatch> matchesPlayed = matchManager.getPlayedMatches();

    if(matchesPlayed.isEmpty()) {
      System.out.println("Sorry, there are no played matches");
      return;
    }

    int i = 1;
    for (FootballMatch match : matchesPlayed) {
      System.out.println("[" + i + "]\t" + match.getId_FirstTeam().getTeamname() + " vs " + match.getId_SecondTeam().getTeamname()
          + " ---- " + match.getMatchdate().toString());
      i++;
    }
  }

  /**
   * Displays the matches that has been cancelled
   */
  private void displayCancelledMatches() {
    List<FootballMatch> cancelledMatches = matchManager.getCancelledMatches();

    if(cancelledMatches.isEmpty()) {
      System.out.println("Sorry, there are no cancelled matches");
      return;
    }

    int i = 1;
    for (FootballMatch match : cancelledMatches) {
      System.out.println("[" + i + "]\t" + match.getId_FirstTeam().getTeamname() + " vs " + match.getId_SecondTeam().getTeamname()
          + " ---- " + match.getMatchdate().toString());
      i++;
    }
  }

  /**
   * Displays all matches
   * Returns error message if there are no matches
   */
  private void displayAllMatches() {
    List<FootballMatch> allMatches = matchManager.getFootballMatches();

    if(allMatches.isEmpty()) {
      System.out.println("Sorry, there are no matches");
      return;
    }

    int i = 1;
    for (FootballMatch match : allMatches) {
      System.out.println("[" + i + "]\t" + match.getId_FirstTeam().getTeamname() + " vs " + match.getId_SecondTeam().getTeamname()
          + " ---- " + match.getMatchdate().toString());
      i++;
    }
  }

  private void displayTeams() {
    ArrayList<Team> teams = teamManager.getTeams();

    int i = 1;
    for (Team team : teams) {
      System.out.println("[" + i + "]\t" + team.getTeamname());
      i++;
    }
  }

  private boolean noMatchesToPlay() {
    boolean matchesToPlayExists = matchManager.getFootballMatches()
        .stream()
        .anyMatch((m) -> m.getState() == MatchState.TO_PLAY);

    if (!matchesToPlayExists) {
      System.out.println("Sorry, but there are no matches to play");
      return true;
    }
    return false;
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
            "[4] List cancelled matches\n" +
            "[5] List all matches\n" +
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
