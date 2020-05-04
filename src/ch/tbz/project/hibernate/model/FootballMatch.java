package ch.tbz.project.hibernate.model;

import javax.persistence.*;
import java.time.LocalDateTime;


public class FootballMatch  extends DataObject{

  private int match_ID;

  private Team id_FirstTeam;

  private Team id_SecondTeam;

  private LocalDateTime matchdate;

  public FootballMatch() {
  }

  public FootballMatch(int match_ID, Team id_FirstTeam, Team id_SecondTeam, LocalDateTime matchdate) {
    this.match_ID = match_ID;

    this.matchdate = matchdate;
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
}
