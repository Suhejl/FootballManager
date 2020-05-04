package ch.tbz.project.hibernate.repo_interface;

import ch.tbz.project.hibernate.model.DataObject;
import ch.tbz.project.hibernate.model.Trikot;

import java.util.List;

public interface IRepository<T extends DataObject> {
  void create(T dataObject);
  void update(T dataObject);
  void delete(T dataObject);
  T read(int id);
  List<T> list();
}
