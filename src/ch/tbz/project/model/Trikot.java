package ch.tbz.project.model;

public class Trikot {
  private int trikot_ID;
  private String name;
  private TrikotDesign id_TrikotDesign;

  public Trikot(){ }

  public Trikot(int trikot_ID, String name, TrikotDesign id_TrikotDesign) {
    this.trikot_ID = trikot_ID;
    this.name = name;
    this.id_TrikotDesign = id_TrikotDesign;
  }

  public int getTrikot_ID() {
    return trikot_ID;
  }

  public void setTrikot_ID(int trikot_ID) {
    this.trikot_ID = trikot_ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TrikotDesign getID_TrikotDesign() {
    return id_TrikotDesign;
  }

  public void setID_TrikotDesign(TrikotDesign id_TrikotDesign) {
    this.id_TrikotDesign = id_TrikotDesign;
  }
}
