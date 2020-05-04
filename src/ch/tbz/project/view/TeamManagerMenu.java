package ch.tbz.project.view;

import ch.tbz.project.hibernate.model.Team;
import ch.tbz.project.hibernate.model.TrainingPlan;
import ch.tbz.project.hibernate.model.TrikotDesign;
import ch.tbz.project.manager.TeamManager;
import ch.tbz.project.model.Brand;
import ch.tbz.project.model.Color;
import ch.tbz.project.model.Sponsor;
import ch.tbz.project.util.ConsoleReader;

import java.sql.Time;


/**
 * Handles the User Inputs for the TeamManager
 */
public class TeamManagerMenu {
  TeamManager teamManager;

  public TeamManagerMenu() {
    teamManager = new TeamManager();
  }

  /**
   * Display the question with Menu for Team Manager
   * Reads User Input for choice made
   */
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
        Team team = inputTeamData();
        teamManager.createTeam(team);
        break;
      case 2:
        teamManager.organizeTeam();
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
   * User input to get team data for creating a team
   *
   * @return team
   */
  private Team inputTeamData() {
    String queryTeamname = "Give the new team a teamname";

    String teamname;
    while (true) {
      teamname = ConsoleReader.readString(queryTeamname);

      if (!teamManager.getAllTeamnames().contains(teamname)) break;

      System.out.println("Teamname already exists\n");
    }


    TrainingPlan trainingPlan = inputTrainingPlanData();
    TrikotDesign trikotDesign = inputTrikotDesign();

    return new Team(teamname, trainingPlan, trikotDesign);
  }

  /**
   * User input to get TrainingPlan data for creating a team
   * It queries for the TrainingStart and TrainingEnd in type Time
   *
   * @return new Instance of TrainingPlan
   */
  private TrainingPlan inputTrainingPlanData() {
    String queryTrainingStart = "When should the daily Training start? Time format [hh:mm:ss]";
    String queryTrainingEnd = "When should the daily Training end? Time format [hh:mm:ss]";

    Time trainingStart = ConsoleReader.readTime(queryTrainingStart);
    Time trainingEnd = ConsoleReader.readTime(queryTrainingEnd);
    return new TrainingPlan(trainingStart, trainingEnd);
  }

  /**
   * User input to get TrikotDesign data for creating a team
   *
   * @return new Instance of TrikotDesign
   */
  private TrikotDesign inputTrikotDesign() {
    String queryTrikot_Color = "Select a color for the trikot design";
    String querySponsor = "Select a Sponsor for the trikot design";
    String queryBrand = "Select a Brand for the trikot design";

    Color color = ConsoleReader.readColor(queryTrikot_Color);
    Sponsor sponsor = ConsoleReader.readSponsor(querySponsor);
    Brand brand = ConsoleReader.readBrand(queryBrand);

    return new TrikotDesign(color, sponsor, brand);
  }

  /**
   * Returns Listed Menu with Options
   *
   * @return menu
   */
  private String optionsMenu() {
    return
        "[1] Create Team\n" +
            "[2] Organize Team\n" +
            "[0] Exit";
  }
}
