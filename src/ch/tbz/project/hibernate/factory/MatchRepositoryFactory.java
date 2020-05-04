package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.BootsPersister;
import ch.tbz.project.hibernate.FootballMatchPersister;
import ch.tbz.project.hibernate.repo_interface.IMatchRepository;

public class MatchRepositoryFactory {
  private static IMatchRepository matchRepository;

  public static IMatchRepository getMatchRepository(){
    if (matchRepository == null) {
      matchRepository = new FootballMatchPersister();
    }
    return matchRepository;
  }
}
