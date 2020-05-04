package ch.tbz.project.hibernate;

import ch.tbz.project.hibernate.model.Boots;
import ch.tbz.project.hibernate.model.DataObject;
import ch.tbz.project.hibernate.repo_interface.IRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;

public abstract class Persister<T extends DataObject> implements IRepository<T> {
  protected SessionFactory sessionFactory = null;

  public Persister() {
    File configFile = new File("hibernate.cfg.xml");
    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure(configFile)
        .build();

    sessionFactory = new MetadataSources(registry)
        .buildMetadata()
        .buildSessionFactory();
  }

  @Override
  public void create(T dataObject) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(dataObject);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void update(T dataObject) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.update(dataObject);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void delete(T dataObject) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.delete(dataObject);
    session.getTransaction().commit();
    session.close();
  }
}
