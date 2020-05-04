package ch.tbz.project;

import ch.tbz.project.hibernate.*;
import ch.tbz.project.hibernate.factory.RepositoryWrapperFactory;
import ch.tbz.project.hibernate.model.Boots;
import ch.tbz.project.hibernate.model.FootballMatch;
import ch.tbz.project.hibernate.model.Player;
import ch.tbz.project.hibernate.model.Team;
import ch.tbz.project.hibernate.model.TrainingPlan;
import ch.tbz.project.hibernate.model.Trikot;
import ch.tbz.project.hibernate.model.TrikotDesign;
import ch.tbz.project.hibernate.repo_interface.IRepositoryWrapper;
import ch.tbz.project.jdbc.TableGenerator;
import ch.tbz.project.model.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

  public static void main(String[] args) throws SQLException {











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
}
