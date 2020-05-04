package ch.tbz.project.model;

public class Team {
  private int team_ID;
  private String teamname;
  private TrainingPlan id_TrainingPlan;
  private TrikotDesign id_TrikotDesign;

  public Team() { }

  public Team(int team_ID, String teamname, TrainingPlan id_TrainingPlan, TrikotDesign id_TrikotDesign) {
    this.team_ID = team_ID;
    this.teamname = teamname;
    this.id_TrainingPlan = id_TrainingPlan;
    this.id_TrikotDesign = id_TrikotDesign;
  }

  public int getTeam_ID() {
    return team_ID;
  }

  public void setTeam_ID(int team_ID) {
    this.team_ID = team_ID;
  }

  public String getTeamname() {
    return teamname;
  }

  public void setTeamname(String teamname) {
    this.teamname = teamname;
  }

  public TrainingPlan getID_TrainingPlan() {
    return id_TrainingPlan;
  }

  public void setID_TrainingPlan(TrainingPlan id_TrainingPlan) {
    this.id_TrainingPlan = id_TrainingPlan;
  }

  public TrikotDesign getID_TrikotDesign() {
    return id_TrikotDesign;
  }

  public void setID_TrikotDesign(TrikotDesign id_TrikotDesign) {
    this.id_TrikotDesign = id_TrikotDesign;
  }
}
