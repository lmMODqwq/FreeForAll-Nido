package me.lmmodqwq.hodoffa.utils;

import java.io.File;
import java.sql.*;

public class SQLite {

    private Connection connection;
    private final File database;

    public SQLite(File database) {
        this.database = database;
    }

    public void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection = DriverManager.getConnection("jdbc:sqlite:" + database.getPath());
    }

    public void disconnect() throws SQLException {
        connection.close();
        connection = null;
    }

    public void update(String qry) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(qry);
        preparedStatement.execute();
    }

    public ResultSet getResult(String qry) throws SQLException {
        Statement stmt = connection.createStatement();

        return stmt.executeQuery(qry);
    }

    public void createTables() throws SQLException {
        update("CREATE TABLE IF NOT EXISTS `statistics` " +
                "( `player_name` VARCHAR(16) NOT NULL ," +
                " `player_uuid` VARCHAR(36) NOT NULL ," +
                " `kills` INT NOT NULL ," +
                " `deaths` INT NOT NULL ," +
                " `streaks` INT NOT NULL ," +
                " `streaks_highest` INT NOT NULL );");
    }

    public boolean isConnected() {
        return (connection != null);
    }
}
