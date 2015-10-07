package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Anhelina_Khalii on 07.10.2015.
 */
public class ConnectorDB {
  private String url;
  private String user;
  private String password;
  private Connection connection;

  public Connection getConnection() {
    return connection;
  }

  public void setConnection(String url, String user, String password) {
    try {
      this.connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void setConnection(String driver, String url, String user, String password) {
    try {
      this.connection = DataSource.getInstance(driver, user, password, url).getConnection();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ConnectorDB(String url, String user, String password) {
    setConnection(url, user, password);
  }

  public ConnectorDB(String driver, String url, String user, String password) {
    setConnection(driver, url, user, password);
  }

  public static void close(Connection connection) {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        throw new IllegalStateException(e);
      }
    }
  }

  public static void close(PreparedStatement preparedStatement) {
    if (preparedStatement != null) {
      try {
        preparedStatement.close();
      } catch (SQLException e) {
        throw new IllegalStateException(e);
      }
    }
  }

  public static void close(ResultSet resultSet) {
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException e) {
        throw new IllegalStateException(e);
      }
    }
  }
}
