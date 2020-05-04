package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.PlayerRepository;
import ch.tbz.project.hibernate.repo_interface.IPlayerRepository;

public class PlayerRepositoryFactory {
  private static IPlayerRepository playerRepository;

  public static IPlayerRepository getPlayerRepository(){
    if (playerRepository == null) {
      playerRepository = new PlayerRepository();
    }
    return playerRepository;
  }
}
