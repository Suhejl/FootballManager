package ch.tbz.project.jdbccrud;

import ch.tbz.project.model.Gender;
import ch.tbz.project.model.Position;

public class Player {
  private int player_ID;
  private String firstname;
  private String lastname;
  private int age;
  private int height_cm;
  private int weight_cm;
  private Gender gender;
  private Position position;
  private Trikot id_Trikot;
  private Boots id_Boots;
  private Team id_Team;

  public Player() { }

  public Player(
      int player_ID,
      String firstname,
      String lastname,
      int age,
      int height_cm,
      int weight_cm,
      Gender gender,
      Position position,
      Trikot id_Trikot,
      Boots id_Boots,
      Team id_Team) {
    this.player_ID = player_ID;
    this.firstname = firstname;
    this.lastname = lastname;
    this.age = age;
    this.height_cm = height_cm;
    this.weight_cm = weight_cm;
    this.gender = gender;
    this.position = position;
    this.id_Trikot = id_Trikot;
    this.id_Boots = id_Boots;
    this.id_Team = id_Team;
  }

  public int getPlayer_ID() {
    return player_ID;
  }

  public void setPlayer_ID(int player_ID) {
    this.player_ID = player_ID;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getHeight_cm() {
    return height_cm;
  }

  public void setHeight_cm(int height_cm) {
    this.height_cm = height_cm;
  }

  public int getWeight_cm() {
    return weight_cm;
  }

  public void setWeight_cm(int weight_cm) {
    this.weight_cm = weight_cm;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Trikot getID_Trikot() {
    return id_Trikot;
  }

  public void setID_Trikot(Trikot id_Trikot) {
    this.id_Trikot = id_Trikot;
  }

  public Boots getID_Boots() {
    return id_Boots;
  }

  public void setID_Boots(Boots id_Boots) {
    this.id_Boots = id_Boots;
  }

  public Team getID_Team() {
    return id_Team;
  }

  public void setID_Team(Team id_Team) {
    this.id_Team = id_Team;
  }
}
