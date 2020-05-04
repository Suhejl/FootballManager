package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.*;
import ch.tbz.project.hibernate.repo_interface.IRepository;

public class RepositoryFactory {
  private static IRepository repository;

  /**
   * Returns a Repository by the simple name
   *
   * @param repositorySimpleName is the .class.getSimpleName() value of a repository class
   * @return a new instantiated repository
   */
  public static IRepository getRepository(String repositorySimpleName) {

    if (BootsRepository.class.getSimpleName().equalsIgnoreCase(repositorySimpleName))
      return new BootsRepository();
    else if (PlayerRepository.class.getSimpleName().equalsIgnoreCase(repositorySimpleName))
      return new PlayerRepository();
    else if (TrikotRepository.class.getSimpleName().equalsIgnoreCase(repositorySimpleName))
      return new TrikotRepository();
    else if (TrikotDesignRepository.class.getSimpleName().equalsIgnoreCase(repositorySimpleName))
      return new TrikotDesignRepository();
    else if (TrainingPlanRepository.class.getSimpleName().equalsIgnoreCase(repositorySimpleName))
      return new TrainingPlanRepository();
    else if (TeamRepository.class.getSimpleName().equalsIgnoreCase(repositorySimpleName))
      return new TeamRepository();
    else if (FootballMatchRepository.class.getSimpleName().equalsIgnoreCase(repositorySimpleName))
      return new FootballMatchRepository();


 /*   switch (repositorySimpleName) {
      case "":
        return new BootsRepository();
      case "PlayerRepository":
        return new PlayerRepository();
      case "TrikotRepository":
        return new TrikotRepository();
      case "TrikotDesignRepository":
        return new TrikotDesignRepository();
      case "TrainingPlanRepository":
        return new TrainingPlanRepository();
      case "TeamRepository":
        return new TeamRepository();
      case "FootballMatchRepository":
        return new FootballMatchRepository();
    }*/
    return null;
  }
}
