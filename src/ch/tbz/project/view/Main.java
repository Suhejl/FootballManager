package ch.tbz.project.view;

import ch.tbz.project.hibernate.Persister;
import ch.tbz.project.hibernate.factory.TrikotDesignRepositoryFactory;
import ch.tbz.project.hibernate.model.TrikotDesign;
import ch.tbz.project.hibernate.repo_interface.IRepository;
import ch.tbz.project.util.ConsoleReader;
import org.hibernate.persister.spi.PersisterFactory;

import java.util.logging.Level;
import java.util.logging.LogManager;

public class Main {

  public static void main(String[] args) {
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
    IRepository repository = TrikotDesignRepositoryFactory.getTrikotDesignRepository();

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


    /*   TableGenerator tableGenerator = new TableGenerator();
     *//*    TrikotDesignPersister trikotDesignPersister = new TrikotDesignPersister();
    TrikotPersister trikotPersister = new TrikotPersister();
    TrainingPlanPersister trainingPlanPersister = new TrainingPlanPersister();
    BootsPersister bootsPersister = new BootsPersister();
    TeamPersister teamPersister = new TeamPersister();
    PlayerPersister playerPersister = new PlayerPersister();
    FootballMatchPersister footballMatchPersister = new FootballMatchPersister();*//*
    IRepositoryWrapper repositoryWrapper = RepositoryWrapperFactory.getRepositoryWrapper();

    // tableGenerator.createAllTables();
    TrikotDesign trikotDesign = new TrikotDesign();
    trikotDesign.setTrikotColor(Color.BLACK);
    trikotDesign.setSponsor(Sponsor.NIKE);
    trikotDesign.setBrand(Brand.NIKE);
    repositoryWrapper.getTrikotDesignRepository().create(trikotDesign);

    TrikotDesign getTrikotDesign = repositoryWrapper.getTrikotDesignRepository().read(1);
    System.out.println(getTrikotDesign.getTrikotDesign_ID() + " - " + getTrikotDesign.getTrikotColor() + " - "
        + getTrikotDesign.getSponsor() + " - "
        + getTrikotDesign.getBrand() + " - ");

    Trikot trikot = new Trikot();
    trikot.setName("Suhejl Asani");
    trikot.setId_TrikotDesign(getTrikotDesign);
    repositoryWrapper.getTrikotRepository().create(trikot);

    Trikot getTrikot = repositoryWrapper.getTrikotRepository().read(1);
    System.out.println(getTrikot.getTrikot_ID() + " - " + getTrikot.getName() + " - "
        + getTrikot.getId_TrikotDesign().getBrand().name());
    List<Trikot> trikotList = repositoryWrapper.getTrikotRepository().list();

    TrainingPlan trainingPlan = new TrainingPlan();
    trainingPlan.setTrainingStart(LocalDateTime.now());
    trainingPlan.setTrainingEnd(LocalDateTime.of(2020, 06, 04, 23, 59, 00));
    repositoryWrapper.getTrainingPlanRepository().create(trainingPlan);
    TrainingPlan getTrainingPlan = repositoryWrapper.getTrainingPlanRepository().read(1);

    Boots boots = new Boots();
    boots.setBrand(Brand.NIKE);
    boots.setColor(Color.BLUE);
    boots.setSize(43);
    repositoryWrapper.getBootsRepository().create(boots);
    Boots getBoots = repositoryWrapper.getBootsRepository().read(1);

    Team team = new Team();
    team.setTeamname("Geile Siecher");
    team.setID_TrainingPlan(trainingPlan);
    team.setID_TrikotDesign(trikotDesign);
    repositoryWrapper.getTeamRepository().create(team);
    Team getTeam = repositoryWrapper.getTeamRepository().read(1);

    Player player = new Player();
    player.setFirstname("Suhejl");
    player.setLastname("Asani");
    player.setAge(17);
    player.setHeight_cm(167);
    player.setWeight_kg(67);
    player.setGender(Gender.MALE);
    player.setPosition(Position.STRIKER);
    player.setID_Trikot(trikot);
    player.setID_Boots(boots);
    player.setID_Team(team);
    repositoryWrapper.getPlayerRepository().create(player);
    Player getPlayer = repositoryWrapper.getPlayerRepository().read(1);

    FootballMatch footballMatch = new FootballMatch();
    footballMatch.setMatchdate(LocalDateTime.of(2020, 05, 06, 15, 00, 00));
    repositoryWrapper.getMatchRepository().create(footballMatch);
    FootballMatch getFootballMatch = repositoryWrapper.getMatchRepository().read(1);*/
  }

  /**
   * Navigates to Manager Menu by choice made
   * And returns boolean if menu should show up again
   *
   * @param choice
   * @return boolean if menu should show up again
   */
  private static boolean navigateToManager(int choice) {
    switch (choice) {
      case 1:
        new PlayerManagerMenu();
        break;
      case 2:
        new TeamManagerMenu().menu();
        break;
      case 3:
        new MatchManagerMenu();
        break;
      case 0:
        return false;
      default:
        System.out.println("Choice invalid");
        break;
    }
    return true;
  }
}
