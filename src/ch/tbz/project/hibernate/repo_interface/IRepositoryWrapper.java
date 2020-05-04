package ch.tbz.project.hibernate.repo_interface;

public interface IRepositoryWrapper {
  IBootsRepository getBootsRepository();
  IMatchRepository getMatchRepository();
  IPlayerRepository getPlayerRepository();
  ITeamRepository getTeamRepository();
  ITrainingPlanRepository getTrainingPlanRepository();
  ITrikotDesignRepository getTrikotDesignRepository();
  ITrikotRepository getTrikotRepository();
}
