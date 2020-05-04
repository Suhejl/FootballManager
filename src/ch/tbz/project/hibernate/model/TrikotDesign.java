package ch.tbz.project.hibernate.model;

import ch.tbz.project.model.Brand;
import ch.tbz.project.model.Color;
import ch.tbz.project.model.Sponsor;

import javax.persistence.*;

@Entity
@Table(name="TrikotDesign")
public class TrikotDesign extends DataObject {
  @Id
  @GeneratedValue
  private Integer trikotDesign_ID;

  @Enumerated(EnumType.STRING)
  @Column(name="Trikot_Color")
  public Color trikotColor;

  @Enumerated(EnumType.STRING)
  @Column(name="Sponsor")
  private Sponsor sponsor;

  @Enumerated(EnumType.STRING)
  @Column(name="Brand")
  private Brand brand;

  public TrikotDesign(){ }

  public TrikotDesign(Color trikotColor, Sponsor sponsor, Brand brand) {
    this.trikotColor = trikotColor;
    this.sponsor = sponsor;
    this.brand = brand;
  }

  public TrikotDesign(Integer trikotDesign_ID, Color trikotColor, Sponsor sponsor, Brand brand) {
    this.trikotDesign_ID = trikotDesign_ID;
    this.trikotColor = trikotColor;
    this.sponsor = sponsor;
    this.brand = brand;
  }

  public Integer getTrikotDesign_ID() {
    return trikotDesign_ID;
  }

  public void setTrikotDesign_ID(Integer trikotDesign_ID) {
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
