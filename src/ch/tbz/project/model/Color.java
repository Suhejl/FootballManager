package ch.tbz.project.model;

public enum Color {
  BLUE("BLUE"),
  RED("RED"),
  GREEN("GREEN"),
  WHITE("WHITE"),
  BLACK("BLACK"),
  YELLOW("YELLOW");

  private String desc;

  private Color(String desc){
    this.desc = desc;
  }

  public String getDesc(){
    return desc;
  }
}
