package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.PlayerPersister;
import ch.tbz.project.hibernate.TeamPersister;
import ch.tbz.project.hibernate.repo_interface.IPlayerRepository;
import ch.tbz.project.hibernate.repo_interface.ITeamRepository;

public class TeamRepositoryFactory {
  private static ITeamRepository teamRepository;

  public static ITeamRepository getTeamRepository(){
    if (teamRepository == null) {
      teamRepository = new TeamPersister();
    }
    return teamRepository;
  }
}
