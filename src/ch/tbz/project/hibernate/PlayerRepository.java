package ch.tbz.project.hibernate;

import ch.tbz.project.hibernate.model.Player;
import ch.tbz.project.hibernate.repo_interface.IPlayerRepository;
import org.hibernate.Session;

import java.util.List;

public class PlayerRepository extends Repository<Player> implements IPlayerRepository {

  @Override
  public Player read(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Player player = session.find(Player.class, id);
    session.getTransaction().commit();
    session.close();
    return player;
  }

  @Override
  public List<Player> list() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Player> player =  (List<Player>) session.createQuery("from Player ").list();
    session.getTransaction().commit();
    session.close();
    return player;
  }
}
