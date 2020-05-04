package ch.tbz.project.hibernate.repo_interface;

import ch.tbz.project.hibernate.model.Team;

import java.util.List;

public interface ITeamRepository extends IRepository<Team> {
  Team read(int id);
  List<Team> list();
}
