package ch.tbz.project.hibernate;

import ch.tbz.project.hibernate.factory.*;
import ch.tbz.project.hibernate.repo_interface.*;

public class RepositoryWrapper implements IRepositoryWrapper {
  @Override
  public IBootsRepository getBootsRepository() {
    return BootsRepositoryFactory.getBootsRepository();
  }

  @Override
  public IMatchRepository getMatchRepository() {
    return MatchRepositoryFactory.getMatchRepository();
  }

  @Override
  public IPlayerRepository getPlayerRepository() {
    return PlayerRepositoryFactory.getPlayerRepository();
  }

  @Override
  public ITeamRepository getTeamRepository() {
    return TeamRepositoryFactory.getTeamRepository();
  }

  @Override
  public ITrainingPlanRepository getTrainingPlanRepository() {
    return TrainingPlanRepositoryFactory.getTrainingPlanRepository();
  }

  @Override
  public ITrikotDesignRepository getTrikotDesignRepository() {
    return TrikotDesignRepositoryFactory.getTrikotDesignRepository();
  }

  @Override
  public ITrikotRepository getTrikotRepository() {
    return TrikotRepositoryFactory.getTrikotRepository();
  }
}
