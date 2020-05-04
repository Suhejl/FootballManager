package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.FootballMatchRepository;
import ch.tbz.project.hibernate.repo_interface.IMatchRepository;

public class MatchRepositoryFactory {
  private static IMatchRepository matchRepository;

  public static IMatchRepository getMatchRepository(){
    if (matchRepository == null) {
      matchRepository = new FootballMatchRepository();
    }
    return matchRepository;
  }
}
