package ch.tbz.project.hibernate.model;

import ch.tbz.project.model.Brand;
import ch.tbz.project.model.Color;

import javax.persistence.*;

@Entity
@Table(name = "Boots")
public class Boots extends DataObject {
  @Id
  @GeneratedValue
  private int boots_ID;

  @Enumerated(EnumType.STRING)
  @Column(name = "Brand")
  private Brand brand;

  @Enumerated(EnumType.STRING)
  @Column(name = "Color")
  private Color color;

  @Column(name = "Size")
  private int size;

  public Boots() {
  }

  public Boots(Brand brand, Color color, int size) {
    this.brand = brand;
    this.color = color;
    this.size = size;
  }

  public Boots(int boots_ID, Brand brand, Color color, int size) {
    this.boots_ID = boots_ID;
    this.brand = brand;
    this.color = color;
    this.size = size;
  }

  public int getBoots_ID() {
    return boots_ID;
  }

  public void setBoots_ID(int boots_ID) {
    this.boots_ID = boots_ID;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
