package ch.tbz.project.hibernate;

import ch.tbz.project.hibernate.model.TrainingPlan;
import ch.tbz.project.hibernate.repo_interface.ITrainingPlanRepository;
import org.hibernate.Session;

import java.util.List;

public class TrainingPlanPersister extends Persister<TrainingPlan> implements ITrainingPlanRepository {

  @Override
  public TrainingPlan read(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    TrainingPlan trikotDesign = session.find(TrainingPlan.class, id);
    session.getTransaction().commit();
    session.close();
    return trikotDesign;
  }

  @Override
  public List<TrainingPlan> list() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<TrainingPlan> trainingPlan =  (List<TrainingPlan>) session.createQuery("from TrainingPlan ").list();
    session.getTransaction().commit();
    session.close();
    return trainingPlan;
  }
}
