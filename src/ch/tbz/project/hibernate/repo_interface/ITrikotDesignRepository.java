package ch.tbz.project.hibernate.repo_interface;

import ch.tbz.project.hibernate.model.TrikotDesign;

import java.util.List;

public interface ITrikotDesignRepository extends IRepository<TrikotDesign> {
  TrikotDesign read(int id);
  List<TrikotDesign> list();
}
