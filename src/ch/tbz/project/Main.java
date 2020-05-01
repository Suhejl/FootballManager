package ch.tbz.project;
import ch.tbz.project.jdbc.TableGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        TableGenerator tableGenerator = new TableGenerator();

        tableGenerator.createAllTables();
    }
}
