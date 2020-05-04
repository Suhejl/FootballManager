package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.PlayerPersister;
import ch.tbz.project.hibernate.repo_interface.IPlayerRepository;

public class PlayerRepositoryFactory {
  private static IPlayerRepository playerRepository;

  public static IPlayerRepository getPlayerRepository(){
    if (playerRepository == null) {
      playerRepository = new PlayerPersister();
    }
    return playerRepository;
  }
}
