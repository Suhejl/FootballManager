package ch.tbz.project.hibernate.repo_interface;

import ch.tbz.project.hibernate.model.Boots;

import java.util.List;

public interface IBootsRepository extends IRepository<Boots> {
  Boots read(int id);
  List<Boots> list();
}
