package ch.tbz.project.jdbccrud;

import ch.tbz.project.jdbc.DatabaseConnection;
import ch.tbz.project.model.Brand;
import ch.tbz.project.model.Color;
import ch.tbz.project.model.Sponsor;

import java.nio.channels.ScatteringByteChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTrikotDesignCRUDPersister {
  private Connection connection;

  public JdbcTrikotDesignCRUDPersister() {
    connection = DatabaseConnection.getDatabaseConnection();
  }

  public JdbcTrikotDesignCRUDPersister(String url) {
    DatabaseConnection.setNewDatabaseURL(url);
    connection = DatabaseConnection.getDatabaseConnection();
  }

  public void createTrikotDesignU(TrikotDesign trikotDesign) {
    if (connection == null) {
      System.out.println(JdbcTrikotDesignCRUDPersister.class.getSimpleName() + " ---- Connection is null");
      return;
    }

    try {
      PreparedStatement stmt = connection.prepareStatement(
          "INSERT INTO TrikotDesign (Trikot_Color, Sponsor, Brand)" +
              "values (?,?,?);",
          Statement.RETURN_GENERATED_KEYS);

      stmt.setString(1, trikotDesign.getTrikotColor().name());
      stmt.setString(2, trikotDesign.getSponsor().name());
      stmt.setString(3, trikotDesign.getBrand().name());

      stmt.executeUpdate();

      ResultSet resultSet = stmt.getGeneratedKeys();

      if (resultSet.next()) {
        trikotDesign.setTrikotDesign_ID(resultSet.getInt(1));
      }
    } catch (SQLException sqlex) {
      System.out.println(JdbcTrikotDesignCRUDPersister.class.getSimpleName() + " ---- " + sqlex.getMessage());
    }
  }

  public TrikotDesign readTrikotDesign(int trikotDesign_id) {
    if (connection == null) {
      System.out.println(JdbcTrikotDesignCRUDPersister.class.getSimpleName() + " ---- Connection is null");
      return null;
    }

    try {
      PreparedStatement stmt = connection.prepareStatement(
          "SELECT * FROM TrikotDesign WHERE TrikotDesign_ID = ?;"
      );

      stmt.setInt(1, trikotDesign_id);

      ResultSet results = stmt.executeQuery();

      if (results.next()) {
        TrikotDesign trikotDesign = new TrikotDesign(
            results.getInt("TrikotDesign_ID"),
            Color.valueOf(results.getString("Trikot_Color")),
            Sponsor.valueOf(results.getString("Sponsor")),
            Brand.valueOf(results.getString("Brand"))
        );
        return trikotDesign;
      }
    } catch (SQLException sqlex) {
      System.out.println(JdbcTrikotDesignCRUDPersister.class.getSimpleName() + " ---- " + sqlex.getMessage());
    }
    return null;
  }

  public List<TrikotDesign> listTrikotDesign() {
    if (connection == null) {
      System.out.println(JdbcTrikotDesignCRUDPersister.class.getSimpleName() + " ---- Connection is null");
      return null;
    }

    try {
      PreparedStatement stmt = connection.prepareStatement(
          "SELECT * FROM TrikotDesign;"
      );

      ResultSet results = stmt.executeQuery();
      List<TrikotDesign> trikotDesigns = new ArrayList<>();
      while (results.next()) {
        TrikotDesign trikotDesign = new TrikotDesign(
            results.getInt("TrikotDesign_ID"),
            Color.valueOf(results.getString("Trikot_Color")),
            Sponsor.valueOf(results.getString("Sponsor")),
            Brand.valueOf(results.getString("Brand"))
        );

        trikotDesigns.add(trikotDesign);
      }

      return trikotDesigns;
    } catch (SQLException sqlex) {
      System.out.println(JdbcTrikotDesignCRUDPersister.class.getSimpleName() + " ---- " + sqlex.getMessage());
    }
    return null;
  }

  public void updateTrikotDesign(TrikotDesign trikotDesign) {
    if (connection == null) {
      System.out.println(JdbcTrikotDesignCRUDPersister.class.getSimpleName() + " ---- Connection is null");
      return;
    }

    try {
      PreparedStatement stmt = connection.prepareStatement(
          "UPDATE TrikotDesign SET Trikot_Color = ?," +
              "Sponsor = ?," +
              "Brand = ?;");

      stmt.setString(1, trikotDesign.getTrikotColor().name());
      stmt.setString(2, trikotDesign.getSponsor().name());
      stmt.setString(3, trikotDesign.getBrand().name());

      stmt.executeUpdate();
    } catch (SQLException sqlex) {
      System.out.println(JdbcTrikotDesignCRUDPersister.class.getSimpleName() + " ---- " + sqlex.getMessage());
    }
  }

  public void deleteTrikotDesign(int trikotDesign_id) {
    if (connection == null) {
      System.out.println(JdbcTrikotDesignCRUDPersister.class.getSimpleName() + " ---- Connection is null");
      return;
    }

    try {
      PreparedStatement stmt = connection.prepareStatement("DELETE TrikotDesign WHERE TrikotDesign_ID = ?");

      stmt.setInt(1, trikotDesign_id);
      stmt.executeUpdate();
    } catch (SQLException sqlex) {
      System.out.println(JdbcTrikotDesignCRUDPersister.class.getSimpleName() + " ---- " + sqlex.getMessage());
    }
  }
}
