package ch.tbz.project.manager;

import ch.tbz.project.hibernate.factory.RepositoryWrapperFactory;
import ch.tbz.project.hibernate.model.FootballMatch;
import ch.tbz.project.hibernate.repo_interface.IRepositoryWrapper;

import java.util.ArrayList;

public class MatchManager {
  IRepositoryWrapper repositoryWrapper = RepositoryWrapperFactory.getRepositoryWrapper();

  public ArrayList<FootballMatch> footballMatches(){
    return (ArrayList<FootballMatch>) repositoryWrapper.getMatchRepository().list();
  }
}
