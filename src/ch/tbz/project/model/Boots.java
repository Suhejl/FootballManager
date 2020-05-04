package ch.tbz.project.model;

public class Boots {
  private int boots_ID;
  private Brand brand;
  private Color color;
  private int size;

  public Boots() { }

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
