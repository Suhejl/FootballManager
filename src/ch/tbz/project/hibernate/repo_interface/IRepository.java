package ch.tbz.project.hibernate.repo_interface;

import ch.tbz.project.hibernate.model.DataObject;

public interface IRepository<T extends DataObject> {
  void create(T dataObject);
  void update(T dataObject);
  void delete(T dataObject);
}
