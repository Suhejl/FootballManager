package ch.tbz.project.hibernate;

import ch.tbz.project.hibernate.model.Boots;
import ch.tbz.project.hibernate.repo_interface.IBootsRepository;
import org.hibernate.Session;

import java.util.List;

public class BootsPersister extends Persister<Boots> implements IBootsRepository {

  @Override
  public Boots read(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Boots dataObject = session.find(Boots.class, id);
    session.getTransaction().commit();
    session.close();
    return dataObject;
  }

  @Override
  public List<Boots> list() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Boots> boots = (List<Boots>) session.createQuery("from Boots ").list();
    session.getTransaction().commit();
    session.close();
    return boots;
  }
}
