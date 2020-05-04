package ch.tbz.project.hibernate;

import ch.tbz.project.hibernate.model.FootballMatch;
import ch.tbz.project.hibernate.repo_interface.IMatchRepository;
import org.hibernate.Session;

import java.util.List;

public class FootballMatchRepository extends Repository<FootballMatch> implements IMatchRepository {

  @Override
  public FootballMatch read(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    FootballMatch footballMatch = session.find(FootballMatch.class, id);
    session.getTransaction().commit();
    session.close();
    return footballMatch;
  }

  @Override
  public List<FootballMatch> list() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<FootballMatch> footballMatch =  (List<FootballMatch>) session.createQuery("from FootballMatch ").list();
    session.getTransaction().commit();
    session.close();
    return footballMatch;
  }
}
