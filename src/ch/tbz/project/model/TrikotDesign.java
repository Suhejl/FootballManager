package ch.tbz.project.model;

public class TrikotDesign {
  private int trikotDesign_ID;
  private Color trikotColor;
  private Sponsor sponsor;
  private Brand brand;

  public TrikotDesign(){ }

  public TrikotDesign(int trikotDesign_ID, Color trikotColor, Sponsor sponsor, Brand brand) {
    this.trikotDesign_ID = trikotDesign_ID;
    this.trikotColor = trikotColor;
    this.sponsor = sponsor;
    this.brand = brand;
  }

  public int getTrikotDesign_ID() {
    return trikotDesign_ID;
  }

  public void setTrikotDesign_ID(int trikotDesign_ID) {
    this.trikotDesign_ID = trikotDesign_ID;
  }

  public Color getTrikotColor() {
    return trikotColor;
  }

  public void setTrikotColor(Color trikotColor) {
    this.trikotColor = trikotColor;
  }

  public Sponsor getSponsor() {
    return sponsor;
  }

  public void setSponsor(Sponsor sponsor) {
    this.sponsor = sponsor;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }
}
