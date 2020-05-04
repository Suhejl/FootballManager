package ch.tbz.project.hibernate.factory;

import ch.tbz.project.hibernate.TrainingPlanPersister;
import ch.tbz.project.hibernate.repo_interface.ITrainingPlanRepository;

public class TrainingPlanRepositoryFactory {
  private static ITrainingPlanRepository trainingPlanRepository;

  public static ITrainingPlanRepository getTrainingPlanRepository(){
    if (trainingPlanRepository == null) {
      trainingPlanRepository = new TrainingPlanPersister();
    }
    return trainingPlanRepository;
  }
}
