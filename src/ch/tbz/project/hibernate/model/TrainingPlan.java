package ch.tbz.project.hibernate.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "TrainingPlan")
public class TrainingPlan extends DataObject {
  @Id
  @GeneratedValue
  private int trainingPlan_ID;

  @Column(name = "TrainingStart")
  private Time trainingStart;

  @Column(name = "TrainingEnd")
  private Time trainingEnd;

  public TrainingPlan() {
  }

  public TrainingPlan(Time trainingStart, Time trainingEnd) {
    this.trainingStart = trainingStart;
    this.trainingEnd = trainingEnd;
  }

  public TrainingPlan(int trainingPlan_ID, Time trainingStart, Time trainingEnd) {
    this.trainingPlan_ID = trainingPlan_ID;
    this.trainingStart = trainingStart;
    this.trainingEnd = trainingEnd;
  }

  public int getTrainingPlan_ID() {
    return trainingPlan_ID;
  }

  public void setTrainingPlan_ID(int trainingPlan_ID) {
    this.trainingPlan_ID = trainingPlan_ID;
  }

  public Time getTrainingStart() {
    return trainingStart;
  }

  public void setTrainingStart(Time trainingStart) {
    this.trainingStart = trainingStart;
  }

  public Time getTrainingEnd() {
    return trainingEnd;
  }

  public void setTrainingEnd(Time trainingEnd) {
    this.trainingEnd = trainingEnd;
  }
}
