package ch.tbz.project.manager;

import ch.tbz.project.hibernate.factory.RepositoryWrapperFactory;
import ch.tbz.project.hibernate.model.FootballMatch;
import ch.tbz.project.hibernate.repo_interface.IRepositoryWrapper;
import ch.tbz.project.model.MatchState;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchManager {
  IRepositoryWrapper repositoryWrapper = RepositoryWrapperFactory.getRepositoryWrapper();

  public ArrayList<FootballMatch> getFootballMatches(){
    return (ArrayList<FootballMatch>) repositoryWrapper.getMatchRepository().list();
  }

  public void createMatch(FootballMatch match){
    repositoryWrapper.getMatchRepository().create(match);
  }

  public void playMatch(FootballMatch match){
    repositoryWrapper.getMatchRepository().update(match);
  }

  public void cancelMatch(FootballMatch match){
    repositoryWrapper.getMatchRepository().update(match);
  }

  public List<FootballMatch> getMatchesToPlay(){
    return getFootballMatches()
        .stream()
        .filter((m) -> m.getState() == MatchState.TO_PLAY).collect(Collectors.toList());
  }

  public List<FootballMatch> getPlayedMatches(){
    return getFootballMatches()
        .stream()
        .filter((m) -> m.getState() == MatchState.PLAYED).collect(Collectors.toList());
  }

  public List<FootballMatch> getCancelledMatches(){
    return getFootballMatches()
        .stream()
        .filter((m) -> m.getState() == MatchState.CANCELLED).collect(Collectors.toList());
  }
}
