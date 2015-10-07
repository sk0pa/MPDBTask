package DAO;

import org.apache.commons.dbcp2.BasicDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Anhelina_Khalii on 07.10.2015.
 */
public class DataSource {

  private static DataSource datasource;
  private BasicDataSource basicDS;

  private DataSource(String driver, String user, String password, String url) throws IOException, SQLException, PropertyVetoException {
    basicDS = new BasicDataSource();
    basicDS.setDriverClassName(driver);
    basicDS.setUsername(user);
    basicDS.setPassword(password);
    basicDS.setUrl(url);
    basicDS.setInitialSize(1);
  }

  public static DataSource getInstance(String driver, String user, String password, String url) throws IOException, SQLException, PropertyVetoException {
    if (datasource == null) {
      datasource = new DataSource(driver, user, password, url);
      return datasource;
    } else {
      return datasource;
    }
  }

  public Connection getConnection() throws SQLException {
    return this.basicDS.getConnection();
  }
}
