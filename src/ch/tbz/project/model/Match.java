package ch.tbz.project.model;

import java.time.LocalDateTime;

public class Match {
  private int match_ID;
  private Team id_Team1;
  private Team id_Team2;
  private LocalDateTime matchdate;

  public Match() { }

  public Match(int match_ID, Team id_Team1, Team id_Team2, LocalDateTime matchdate) {
    this.match_ID = match_ID;
    this.id_Team1 = id_Team1;
    this.id_Team2 = id_Team2;
    this.matchdate = matchdate;
  }

  public int getMatch_ID() {
    return match_ID;
  }

  public void setMatch_ID(int match_ID) {
    this.match_ID = match_ID;
  }

  public Team getID_Team1() {
    return id_Team1;
  }

  public void setID_Team1(Team id_Team1) {
    this.id_Team1 = id_Team1;
  }

  public Team getID_Team2() {
    return id_Team2;
  }

  public void setID_Team2(Team id_Team2) {
    this.id_Team2 = id_Team2;
  }

  public LocalDateTime getMatchdate() {
    return matchdate;
  }

  public void setMatchdate(LocalDateTime matchdate) {
    this.matchdate = matchdate;
  }
}
