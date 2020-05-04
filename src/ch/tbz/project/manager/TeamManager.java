package ch.tbz.project.manager;

import ch.tbz.project.hibernate.factory.RepositoryWrapperFactory;
import ch.tbz.project.hibernate.model.Team;
import ch.tbz.project.hibernate.repo_interface.IRepositoryWrapper;

import java.util.ArrayList;
import java.util.List;

public class TeamManager {
  IRepositoryWrapper repositoryWrapper = RepositoryWrapperFactory.getRepositoryWrapper();

  /**
   * Creates a team and its Foreign Keys
   * @param team Team to create
   */
  public void createTeam(Team team){
    repositoryWrapper.getTrainingPlanRepository().create(team.getID_TrainingPlan());
    repositoryWrapper.getTrikotDesignRepository().create(team.getID_TrikotDesign());
    repositoryWrapper.getTeamRepository().create(team);
  }

  public void organizeTeam(){

  }

  /**
   * Queries all Teamnames from database
   * @return All Teamnames
   */
  public ArrayList<String> getAllTeamnames(){
   List<Team> teamList = repositoryWrapper.getTeamRepository().list();
   ArrayList<String> teamnames = new ArrayList<>();

    for (Team team : teamList) {
      teamnames.add(team.getTeamname());
    }
    return teamnames;
  }
}
