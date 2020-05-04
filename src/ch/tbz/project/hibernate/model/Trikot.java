package ch.tbz.project.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name="Trikot")
public class Trikot extends DataObject {
  @Id
  @GeneratedValue
  private Integer trikot_ID;


  @Column(name = "Name")
  private String name;

  @ManyToOne(targetEntity = TrikotDesign.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_TrikotDesign", referencedColumnName = "TrikotDesign_ID")
  private TrikotDesign id_TrikotDesign;

  public Trikot() { }

  public Trikot(String name, TrikotDesign id_TrikotDesign) {
    this.name = name;
    this.id_TrikotDesign = id_TrikotDesign;
  }

  public Trikot(Integer trikot_ID, String name, TrikotDesign id_TrikotDesign) {
    this.trikot_ID = trikot_ID;
    this.name = name;
    this.id_TrikotDesign = id_TrikotDesign;
  }

  public Integer getTrikot_ID() {
    return trikot_ID;
  }

  public void setTrikot_ID(Integer trikot_ID) {
    this.trikot_ID = trikot_ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TrikotDesign getId_TrikotDesign() {
    return id_TrikotDesign;
  }

  public void setId_TrikotDesign(TrikotDesign id_TrikotDesign) {
    this.id_TrikotDesign = id_TrikotDesign;
  }

}
