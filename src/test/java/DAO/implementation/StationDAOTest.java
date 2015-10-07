package DAO.implementation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import DAO.ConnectorDB;
import DAO.entity.StationEntity;

/**
 * Created by Anhelina_Khalii on 07.10.2015.
 */
public class StationDAOTest {

  @Test
  public void testGetAll() throws Exception {
    ResourceBundle resource = ResourceBundle.getBundle("database");
    String url = resource.getString("db.url");
    String user = resource.getString("db.user");
    String password = resource.getString("db.password");

    ConnectorDB connectorDB = new ConnectorDB(url, user, password);
    Connection connection = connectorDB.getConnection();

    StationDAO dao = new StationDAO();
    List<StationEntity> entities = dao.getAll(connection);
    for (StationEntity entity : entities) {
      System.out.println(entity.toString());
    }
    ConnectorDB.close(connection);
    Assert.assertTrue(entities.size() > 0);
  }

  @Test
  public void testPoolGetAll() throws Exception {
    ResourceBundle resource = ResourceBundle.getBundle("database");
    String driver = resource.getString("db.driver");
    String url = resource.getString("db.url");
    String user = resource.getString("db.user");
    String password = resource.getString("db.password");

    for (int i = 0; i < 1000; i++) {
      checkWithPool(driver, url, user, password);
    }
  }

  @Test
  public void testEmbeddedPoolGetAll() throws Exception {
    ResourceBundle resource = ResourceBundle.getBundle("database");
    String driver = resource.getString("db.driver");
    String url = resource.getString("db.urlEmbedded");
    String user = resource.getString("db.user");
    String password = resource.getString("db.password");

    for (int i = 0; i < 1000; i++) {
      checkWithPool(driver, url, user, password);
    }
  }

  public void checkWithPool(String driver, String url, String user, String password) {
    ConnectorDB connectorDB = new ConnectorDB(driver, url, user, password);
    Connection connection = connectorDB.getConnection();

    StationDAO dao = new StationDAO();
    List<StationEntity> entities = dao.getAll(connection);
    for (StationEntity entity : entities) {
      System.out.println(entity.toString());
    }
    ConnectorDB.close(connection);
    Assert.assertTrue(entities.size() > 0);
  }

  @Test
  public void testAdvancedGetAll() throws Exception {

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 100000; i++) {
      executorService.execute(new Runnable() {
                                public void run() {
                                  try {
                                    ResourceBundle resource = ResourceBundle.getBundle("database");
                                    String driver = resource.getString("db.driver");
                                    String url = resource.getString("db.url");
                                    String user = resource.getString("db.user");
                                    String password = resource.getString("db.password");
                                    checkWithPool(driver, url, user, password);
                                  } catch (Exception e){
                                    e.getStackTrace();
                                  }
                                }
                              }
      );
    }
    long start = System.currentTimeMillis();
    executorService.shutdown();
    executorService.awaitTermination(5, TimeUnit.MINUTES);
    System.out.println("Done after " + (System.currentTimeMillis() - start));
  }
}
