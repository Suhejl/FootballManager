package ch.tbz.project.hibernate;

import ch.tbz.project.hibernate.model.Trikot;
import ch.tbz.project.hibernate.repo_interface.ITrikotRepository;
import org.hibernate.Session;

import java.util.List;

public class TrikotPersister extends Persister<Trikot> implements ITrikotRepository {

  @Override
  public Trikot read(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Trikot trikot = session.find(Trikot.class, id);
    session.getTransaction().commit();
    session.close();
    return trikot;
  }

  @Override
  public List<Trikot> list() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Trikot> trikots =  (List<Trikot>) session.createQuery("from Trikot ").list();
    session.getTransaction().commit();
    session.close();
    return trikots;
  }
}
