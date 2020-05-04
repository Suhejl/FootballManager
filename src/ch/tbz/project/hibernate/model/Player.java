package ch.tbz.project.hibernate.model;

import ch.tbz.project.model.Gender;
import ch.tbz.project.model.Position;

import javax.persistence.*;

@Entity
@Table(name = "Player")
public class Player extends DataObject {
  @Id
  @GeneratedValue
  private int player_ID;

  @Column(name = "Firstname")
  private String firstname;

  @Column(name = "Lastname")
  private String lastname;

  @Column(name = "Age")
  private int age;

  @Column(name = "Height_cm")
  private int height_cm;

  @Column(name = "Weight_kg")
  private int weight_kg;

  @Enumerated(EnumType.STRING)
  @Column(name = "Gender")
  private Gender gender;

  @Enumerated(EnumType.STRING)
  @Column(name = "Position")
  private Position position;

  @ManyToOne(targetEntity = ch.tbz.project.hibernate.model.Trikot.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_Trikot", referencedColumnName = "Trikot_ID")
  private Trikot id_Trikot;

  @ManyToOne(targetEntity = ch.tbz.project.hibernate.model.Boots.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_Boots", referencedColumnName = "Boots_ID")
  private Boots id_Boots;

  @ManyToOne(targetEntity = ch.tbz.project.hibernate.model.Team.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_Team", referencedColumnName = "Team_ID")
  private Team id_Team;

  public Player() {
  }

  public Player(
      String firstname,
      String lastname,
      int age,
      int height_cm,
      int weight_kg,
      Gender gender,
      Position position,
      Trikot id_Trikot,
      Boots id_Boots,
      Team id_Team) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.age = age;
    this.height_cm = height_cm;
    this.weight_kg = weight_kg;
    this.gender = gender;
    this.position = position;
    this.id_Trikot = id_Trikot;
    this.id_Boots = id_Boots;
    this.id_Team = id_Team;
  }

  public Player(
      int player_ID,
      String firstname,
      String lastname,
      int age,
      int height_cm,
      int weight_kg,
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
    this.weight_kg = weight_kg;
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

  public int getWeight_kg() {
    return weight_kg;
  }

  public void setWeight_kg(int weight_kg) {
    this.weight_kg = weight_kg;
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
