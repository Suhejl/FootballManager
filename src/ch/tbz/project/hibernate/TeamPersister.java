package ch.tbz.project.hibernate;

import ch.tbz.project.hibernate.model.Team;
import ch.tbz.project.hibernate.repo_interface.ITeamRepository;
import org.hibernate.Session;

import java.util.List;

public class TeamPersister extends Persister<Team> implements ITeamRepository {

  @Override
  public Team read(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Team team = session.find(Team.class, id);
    session.getTransaction().commit();
    session.close();
    return team;
  }

  @Override
  public List<Team> list() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Team> team =  (List<Team>) session.createQuery("from Team ").list();
    session.getTransaction().commit();
    session.close();
    return team;
  }
}
