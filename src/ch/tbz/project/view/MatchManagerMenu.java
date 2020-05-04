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
import java.util.stream.Collectors;

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
        menu();
      default:
        System.out.println("Choice is invalid");
        organizeMatch();
    }
  }

  private void createMatch() {
    if (teamManager.getTeams().isEmpty() || teamManager.getTeams().size() < 2) {
      System.out.println("Sorry, but there are not enough teams to organize a match");
      return;
    }

    String queryMatchDate = "When should the Match occur?";

    LocalDateTime matchDate = ConsoleReader.readLocalDateTime(queryMatchDate);
    ArrayList<Team> teams = teamManager.getTeams();
    Team firstTeam;
    Team secondTeam;
    while (true) {
      if (ConsoleReader.readInteger("Enter a number 0 or below if you want to leave now") < 1) organizeMatch();

      firstTeam = selectFirstTeam(teams, matchDate);
      secondTeam = selectSecondTeam(teams, matchDate);

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

  private Team selectFirstTeam(ArrayList<Team> teams, LocalDateTime matchDate) {
    Team firstTeam;
    while (true) {
      displayTeams();

      String queryChooseFirstTeam = "Choose First Team to add to the match";
      int indexFirstTeam = ConsoleReader.readInteger(queryChooseFirstTeam);

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

  private Team selectSecondTeam(ArrayList<Team> teams, LocalDateTime matchDate) {
    Team secondTeam;
    while (true) {
      displayTeams();

      String queryChooseSecondTeam = "Choose Second Team to add to the match";
      int indexSecondTeam = ConsoleReader.readInteger(queryChooseSecondTeam);

      try {
        secondTeam = teams.get(indexSecondTeam - 1);
      } catch (IndexOutOfBoundsException inex) {
        System.out.println("Invalid index. Team with index " + indexSecondTeam + " does not exist");
        continue;
      }

      LocalTime secondTeamTrainingStart = secondTeam.getID_TrainingPlan().getTrainingStart().toLocalTime().minusMinutes(15);
      LocalTime secondTeamTrainingEnd = secondTeam.getID_TrainingPlan().getTrainingEnd().toLocalTime().plusMinutes(15);

      if (matchDate.toLocalTime().isAfter(secondTeamTrainingStart) && matchDate.toLocalTime().isBefore(secondTeamTrainingEnd)) {
        System.out.println("The team can't be selected, since the match date clashes with its training");
        continue;
      }

      break;
    }

    return secondTeam;
  }

  private void playMatch() {
    navigateToOrganizeMatchIfNoMatchesToPlay();

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

  private void cancelMatch() {
    navigateToOrganizeMatchIfNoMatchesToPlay();

    List<FootballMatch> matchesToPlay = matchManager.getMatchesToPlay();

    FootballMatch match = selectMatch(matchesToPlay, "Choose Match to cancel");

    match.setState(MatchState.CANCELLED);
    matchManager.cancelMatch(match);
    System.out.println("Match has been successfully cancelled");
  }

  private FootballMatch selectMatch(List<FootballMatch> matchesToPlay, String queryToUser) {
    FootballMatch match;

    while (true) {
      displayMatchesToPlay();

      String queryChooseMatch = "Choose Match to play";
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

  private void displayMatchesToPlay() {
    List<FootballMatch> matchesToPlay = matchManager.getMatchesToPlay();

    if(matchesToPlay.isEmpty()) {
      System.out.println("Sorry, there are no cancelled matches");
      return;
    }

    int i = 1;
    for (FootballMatch match : matchesToPlay) {
      System.out.println("[" + i + "]\t" + match.getId_FirstTeam().getTeamname() + " vs " + match.getId_SecondTeam().getTeamname()
          + " ---- " + match.getMatchdate().toString());
      i++;
    }
  }

  private void displayPlayedMatches() {
    List<FootballMatch> matchesPlayed = matchManager.getPlayedMatches();

    if(matchesPlayed.isEmpty()) {
      System.out.println("Sorry, there are no cancelled matches");
      return;
    }

    int i = 1;
    for (FootballMatch match : matchesPlayed) {
      System.out.println("[" + i + "]\t" + match.getId_FirstTeam().getTeamname() + " vs " + match.getId_SecondTeam().getTeamname()
          + " ---- " + match.getMatchdate().toString());
      i++;
    }
  }

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

  private void displayAllMatches() {
    List<FootballMatch> cancelledMatches = matchManager.getFootballMatches();

    int i = 1;
    for (FootballMatch match : cancelledMatches) {
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

  private void navigateToOrganizeMatchIfNoMatchesToPlay() {
    boolean matchesToPlayExists = matchManager.getFootballMatches()
        .stream()
        .anyMatch((m) -> m.getState() == MatchState.TO_PLAY);

    if (!matchesToPlayExists) {
      System.out.println("Sorry, but there are no matches to play");
      organizeMatch();
    }
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
