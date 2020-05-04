package ch.tbz.project.hibernate;

import ch.tbz.project.hibernate.model.TrikotDesign;
import ch.tbz.project.hibernate.repo_interface.ITrikotDesignRepository;
import org.hibernate.Session;

import java.util.List;

public class TrikotDesignRepository extends Repository<TrikotDesign> implements ITrikotDesignRepository {

  @Override
  public TrikotDesign read(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    TrikotDesign trikotDesign = session.find(TrikotDesign.class, id);
    session.getTransaction().commit();
    session.close();
    return trikotDesign;
  }

  @Override
  public List<TrikotDesign> list() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<TrikotDesign> trikotDesigns =  (List<TrikotDesign>) session.createQuery("from TrikotDesign ").list();
    session.getTransaction().commit();
    session.close();
    return trikotDesigns;
  }
}
