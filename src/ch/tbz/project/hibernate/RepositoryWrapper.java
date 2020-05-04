package ch.tbz.project.hibernate;

import ch.tbz.project.hibernate.factory.*;
import ch.tbz.project.hibernate.repo_interface.*;

public class RepositoryWrapper implements IRepositoryWrapper {
  @Override
  public IBootsRepository getBootsRepository() {
    return (IBootsRepository) RepositoryFactory.getRepository(BootsRepository.class.getSimpleName());
  }

  @Override
  public IMatchRepository getMatchRepository() {
    return (IMatchRepository) RepositoryFactory.getRepository(FootballMatchRepository.class.getSimpleName());
  }

  @Override
  public IPlayerRepository getPlayerRepository() {
    return (IPlayerRepository) RepositoryFactory.getRepository(PlayerRepository.class.getSimpleName());
  }

  @Override
  public ITeamRepository getTeamRepository() {
    return (ITeamRepository) RepositoryFactory.getRepository(TeamRepository.class.getSimpleName());
  }

  @Override
  public ITrainingPlanRepository getTrainingPlanRepository() {
    return (ITrainingPlanRepository) RepositoryFactory.getRepository(TrainingPlanRepository.class.getSimpleName());
  }

  @Override
  public ITrikotDesignRepository getTrikotDesignRepository() {
    return (ITrikotDesignRepository) RepositoryFactory.getRepository(TrikotDesignRepository.class.getSimpleName());
  }

  @Override
  public ITrikotRepository getTrikotRepository() {
    return (ITrikotRepository) RepositoryFactory.getRepository(TrikotRepository.class.getSimpleName());
  }
}
