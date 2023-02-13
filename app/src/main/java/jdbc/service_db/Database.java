package jdbc.service_db;

import jdbc.prefs.Prefs;

import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;

    private Database () {
        String connectionURL = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
        String connectionUser = new Prefs().getString(Prefs.DB_JDBC_NAME_USER);
        String connectionPass = new Prefs().getString(Prefs.DB_JDBC_PASSWORD);

        try {
            connection = DriverManager.getConnection(connectionURL, connectionUser, connectionPass);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public int executeUpdate (String sql) {
        try(Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public Connection getConnection () {
        return connection;
    }

    public void close () {
        try {
            connection.close();
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ResultSet executeQuery (String sql) {
        try {
            Statement st = connection.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
