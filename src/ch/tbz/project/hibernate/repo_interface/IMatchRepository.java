package ch.tbz.project.hibernate.repo_interface;

import ch.tbz.project.hibernate.model.FootballMatch;

import java.util.List;

public interface IMatchRepository extends IRepository<FootballMatch>{
  FootballMatch read(int id);
  List<FootballMatch> list();
}
