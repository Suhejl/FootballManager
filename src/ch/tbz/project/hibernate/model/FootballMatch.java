package ch.tbz.project.hibernate.model;

import ch.tbz.project.model.MatchState;

import javax.persistence.*;
import java.time.LocalDateTime;


public class FootballMatch  extends DataObject{

  private int match_ID;

  private Team id_FirstTeam;

  private Team id_SecondTeam;

  private int firstTeamScore;

  private int secondTeamScore;

  private LocalDateTime matchdate;

  private MatchState state;

  public FootballMatch() {
  }

  public FootballMatch(int match_ID, Team id_FirstTeam, Team id_SecondTeam,
                       int firstTeamScore, int secondTeamScore, LocalDateTime matchdate, MatchState state) {
    this.match_ID = match_ID;
    this.id_FirstTeam = id_FirstTeam;
    this.id_SecondTeam = id_SecondTeam;
    this.firstTeamScore = firstTeamScore;
    this.secondTeamScore = secondTeamScore;
    this.matchdate = matchdate;
    this.state = state;
  }

  public int getMatch_ID() {
    return match_ID;
  }

  public void setMatch_ID(int match_ID) {
    this.match_ID = match_ID;
  }

  public Team getId_FirstTeam() {
    return id_FirstTeam;
  }

  public void setId_FirstTeam(Team id_FirstTeam) {
    this.id_FirstTeam = id_FirstTeam;
  }

  public Team getId_SecondTeam() {
    return id_SecondTeam;
  }

  public void setId_SecondTeam(Team id_SecondTeam) {
    this.id_SecondTeam = id_SecondTeam;
  }

  public LocalDateTime getMatchdate() {
    return matchdate;
  }

  public void setMatchdate(LocalDateTime matchdate) {
    this.matchdate = matchdate;
  }

  public MatchState getState() {
    return state;
  }

  public void setState(MatchState state) {
    this.state = state;
  }

  public int getFirstTeamScore() {
    return firstTeamScore;
  }

  public void setFirstTeamScore(int firstTeamScore) {
    this.firstTeamScore = firstTeamScore;
  }

  public int getSecondTeamScore() {
    return secondTeamScore;
  }

  public void setSecondTeamScore(int secondTeamScore) {
    this.secondTeamScore = secondTeamScore;
  }
}
