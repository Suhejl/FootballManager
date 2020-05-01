package ch.tbz.project.jdbc;

import org.w3c.dom.CDATASection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DatabaseConnection {
  private static String databaseURL;

  public static void resetToDefaultDatabaseURL(){
    setDatabaseURL("jdbc.url");
  }

  public static void setNewDatabaseURL(String propertyKey){
    setDatabaseURL(propertyKey);
  }

  public static Connection getDatabaseConnection() {
    if(databaseURL == null) resetToDefaultDatabaseURL();

    Connection connection = null;
    try {
    connection = DriverManager.getConnection(databaseURL);
    } catch (SQLException sqlex) {
      System.out.println(DatabaseConnection.class.getSimpleName() + " ---- " + sqlex.getMessage()
          + " attempting to connect to " + databaseURL);
      return null;
    }
    return connection;
  }

  private static void setDatabaseURL(String propertyKey){
    try {
      Properties properties = new Properties();
      URL resource = DatabaseConnection.class.getClassLoader().getResource("resources/application.properties");
      properties.load(new FileReader(resource.getPath()));
      databaseURL = properties.getProperty(propertyKey);
    } catch (FileNotFoundException fex) {
      System.out.println(DatabaseConnection.class.getSimpleName() + " ---- " + fex.getMessage());
      return;
    } catch (IOException ioex) {
      System.out.println(DatabaseConnection.class.getSimpleName() + " ---- " + ioex.getMessage());
    }
  }
}
