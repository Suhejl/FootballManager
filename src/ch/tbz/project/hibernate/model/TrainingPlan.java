package ch.tbz.project.hibernate.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TrainingPlan")
public class TrainingPlan extends DataObject {
  @Id
  @GeneratedValue
  private int trainingPlan_ID;

  @Column(name = "TrainingStart")
  private LocalDateTime trainingStart;

  @Column(name = "TrainingEnd")
  private LocalDateTime trainingEnd;

  public TrainingPlan() {
  }

  public TrainingPlan(int trainingPlan_ID, LocalDateTime trainingStart, LocalDateTime trainingEnd) {
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

  public LocalDateTime getTrainingStart() {
    return trainingStart;
  }

  public void setTrainingStart(LocalDateTime trainingStart) {
    this.trainingStart = trainingStart;
  }

  public LocalDateTime getTrainingEnd() {
    return trainingEnd;
  }

  public void setTrainingEnd(LocalDateTime trainingEnd) {
    this.trainingEnd = trainingEnd;
  }
}
