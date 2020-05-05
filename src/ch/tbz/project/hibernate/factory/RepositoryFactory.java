package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.*;
import ch.tbz.project.hibernate.repo_interface.IRepository;

public class RepositoryFactory {
  /**
   * Returns a Repository by the simple name
   *
   * @param repositoryClassSimpleName is the .class.getSimpleName() value of a repository class
   * @return a new instantiated repository
   */
  public static IRepository getRepository(String repositoryClassSimpleName) {

    if (BootsRepository.class.getSimpleName().equalsIgnoreCase(repositoryClassSimpleName))
      return new BootsRepository();
    else if (PlayerRepository.class.getSimpleName().equalsIgnoreCase(repositoryClassSimpleName))
      return new PlayerRepository();
    else if (TrikotRepository.class.getSimpleName().equalsIgnoreCase(repositoryClassSimpleName))
      return new TrikotRepository();
    else if (TrikotDesignRepository.class.getSimpleName().equalsIgnoreCase(repositoryClassSimpleName))
      return new TrikotDesignRepository();
    else if (TrainingPlanRepository.class.getSimpleName().equalsIgnoreCase(repositoryClassSimpleName))
      return new TrainingPlanRepository();
    else if (TeamRepository.class.getSimpleName().equalsIgnoreCase(repositoryClassSimpleName))
      return new TeamRepository();
    else if (FootballMatchRepository.class.getSimpleName().equalsIgnoreCase(repositoryClassSimpleName))
      return new FootballMatchRepository();

    return null;
  }
}
