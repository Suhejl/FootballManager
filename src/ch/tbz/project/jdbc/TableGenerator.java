package ch.tbz.project.jdbc;

import javax.swing.table.DefaultTableCellRenderer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TableGenerator {
  private Connection connection;

  public TableGenerator() {
    connection = DatabaseConnection.getDatabaseConnection();
  }

  public TableGenerator(String propertyKey) {
    DatabaseConnection.setNewDatabaseURL(propertyKey);
    connection = DatabaseConnection.getDatabaseConnection();
  }

  /*
   * Create all Tables for your Database
   */
  public void createAllTables() {
    createTrikotDesign();
    createTrikot();
    createBoots();
    createTrainingPlan();
    createTeam();
    createPlayer();
    createMatch();
  }

  public void createTrikotDesign() {
    String sqlCreateTableStatement = "CREATE TABLE IF NOT EXISTS TrikotDesign (\n" +
        "  TrikotDesign_ID INTEGER NOT NULL ,\n" +
        "  Trikot_Color VARCHAR(45) NULL,\n" +
        "  Sponsor VARCHAR(45) NULL,\n" +
        "  Brand VARCHAR(45) NULL,\n" +
        "  PRIMARY KEY (TrikotDesign_ID))\n" +
        ";";

    createTable(sqlCreateTableStatement, "TrikotDesign");
  }

  public void createTrikot() {
    String sqlCreateTableStatement = "CREATE TABLE IF NOT EXISTS Trikot (\n" +
        "  Trikot_ID INTEGER NOT NULL,\n" +
        "  Name VARCHAR(45) NOT NULL,\n" +
        "  ID_TrikotDesign INT NULL,\n" +
        "  PRIMARY KEY (Trikot_ID, Name),\n" +
        "  CONSTRAINT Constraint_ID_TrikotDesign_TrikotDesign_ID\n" +
        "    FOREIGN KEY (ID_TrikotDesign)\n" +
        "    REFERENCES TrikotDesign (TrikotDesign_ID)\n" +
        "    ON DELETE CASCADE\n" +
        "    ON UPDATE CASCADE)\n" +
        ";";

    createTable(sqlCreateTableStatement, "Trikot");
  }

  public void createBoots() {
    String sqlCreateTableStatement = "CREATE TABLE IF NOT EXISTS Boots (\n" +
        "  Boots_ID INTEGER NOT NULL,\n" +
        "  Brand VARCHAR(45) NULL,\n" +
        "  Color VARCHAR(45) NULL,\n" +
        "  Size INT UNSIGNED NULL,\n" +
        "  PRIMARY KEY (Boots_ID))\n" +
        ";";

    createTable(sqlCreateTableStatement, "Boots");
  }

  public void createTrainingPlan() {
    String sqlCreateTableStatement = "CREATE TABLE IF NOT EXISTS TrainingPlan (\n" +
        "  TrainingPlan_ID INTEGER NOT NULL,\n" +
        "  TrainingStart DATETIME(8) NULL,\n" +
        "  TrainingEnd DATETIME(8) NULL,\n" +
        "  PRIMARY KEY (TrainingPlan_ID))\n" +
        ";";

    createTable(sqlCreateTableStatement, "TrainingPlan");
  }

  public void createTeam() {
    String sqlCreateTableStatement = "CREATE TABLE IF NOT EXISTS Team (\n" +
        "  Team_ID INTEGER NOT NULL,\n" +
        "  Teamname VARCHAR(45) NULL,\n" +
        "  ID_TrainingPlan INT NULL,\n" +
        "  ID_TrikotDesign INT NULL,\n" +
        "  PRIMARY KEY (Team_ID),\n" +
        "  CONSTRAINT Constraint_ID_TrainingPlan_TrainingPlan_ID\n" +
        "    FOREIGN KEY (ID_TrainingPlan)\n" +
        "    REFERENCES TrainingPlan (TrainingPlan_ID)\n" +
        "    ON DELETE CASCADE\n" +
        "    ON UPDATE CASCADE,\n" +
        "  CONSTRAINT Constraint_ID_TrikotDesign_TrikotDesign_ID\n" +
        "    FOREIGN KEY (ID_TrikotDesign)\n" +
        "    REFERENCES TrikotDesign (TrikotDesign_ID)\n" +
        "    ON DELETE CASCADE\n" +
        "    ON UPDATE CASCADE)\n" +
        ";";

    createTable(sqlCreateTableStatement, "Team");
  }

  public void createPlayer() {
    String sqlCreateTableStatement = "CREATE TABLE IF NOT EXISTS Player (\n" +
        "  Player_ID INTEGER NOT NULL,\n" +
        "  Firstname VARCHAR(45) NULL,\n" +
        "  Lastname INT NULL,\n" +
        "  Age INT UNSIGNED NULL,\n" +
        "  Height_cm INT UNSIGNED NULL,\n" +
        "  Weight_kg INT UNSIGNED NULL,\n" +
        "  Gender VARCHAR(10) NULL,\n" +
        "  Position VARCHAR(45) NULL,\n" +
        "  ID_Trikot INT NULL,\n" +
        "  ID_Boots INT NULL,\n" +
        "  ID_Team INT NULL,\n" +
        "  PRIMARY KEY (Player_ID),\n" +
        "  CONSTRAINT Constraint_ID_Trikot_Trikot_ID\n" +
        "    FOREIGN KEY (ID_Trikot)\n" +
        "    REFERENCES Trikot (Trikot_ID)\n" +
        "    ON DELETE CASCADE\n" +
        "    ON UPDATE CASCADE,\n" +
        "  CONSTRAINT Constraint_ID_Boots_Boots_ID\n" +
        "    FOREIGN KEY (ID_Boots)\n" +
        "    REFERENCES Boots (Boots_ID)\n" +
        "    ON DELETE CASCADE\n" +
        "    ON UPDATE CASCADE,\n" +
        "  CONSTRAINT Constraint_ID_Team_Team_ID\n" +
        "    FOREIGN KEY (ID_Team)\n" +
        "    REFERENCES Team (Team_ID)\n" +
        "    ON DELETE CASCADE\n" +
        "    ON UPDATE CASCADE)\n" +
        ";";

    createTable(sqlCreateTableStatement, "Player");
  }

  public void createMatch() {
    String sqlCreateTableStatement = "CREATE TABLE IF NOT EXISTS Match (\n" +
        "  Match_ID INTEGER NOT NULL,\n" +
        "  ID_Team1 INT NULL,\n" +
        "  ID_Team2 INT NULL,\n" +
        "  Matchdate DATETIME NULL,\n" +
        "  PRIMARY KEY (Match_ID),\n" +
        "  CONSTRAINT Constraint_ID_Team1_Team_ID\n" +
        "    FOREIGN KEY (ID_Team1)\n" +
        "    REFERENCES Team (Team_ID)\n" +
        "    ON DELETE CASCADE\n" +
        "    ON UPDATE CASCADE,\n" +
        "  CONSTRAINT Constraint_ID_Team2_Team_ID\n" +
        "    FOREIGN KEY (ID_Team2)\n" +
        "    REFERENCES Team (Team_ID)\n" +
        "    ON DELETE CASCADE\n" +
        "    ON UPDATE CASCADE)\n" +
        ";";

    createTable(sqlCreateTableStatement, "Match");
  }

  private void createTable(String sqlCreateTableStatement, String tableName) {
    if (connection == null) return;

    try {
      Statement stmt = connection.createStatement();
      stmt.execute(sqlCreateTableStatement);
    } catch (SQLException sqlex) {
      System.out.println(TableGenerator.class.getSimpleName() + " ---- " + sqlex.getMessage()
          + "attempting to create " + tableName + "Table");
    }
  }

}
