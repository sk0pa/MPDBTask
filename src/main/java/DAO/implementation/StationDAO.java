package DAO.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ConnectorDB;
import DAO.entity.StationEntity;
import DAO.extractor.StationEntityExtractor;

/**
 * Created by Anhelina_Khalii on 07.10.2015.
 */
public class StationDAO {

  public static final String FIND_ALL_STATIONS = "SELECT * FROM STATION";

  public List<StationEntity> getAll(Connection connection){
    List<StationEntity> entities = new ArrayList<>();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      preparedStatement = connection.prepareStatement(FIND_ALL_STATIONS);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        entities.add(StationEntityExtractor.extract(resultSet));
      }
    } catch (SQLException e) {
      e.getStackTrace();
    } finally {
      ConnectorDB.close(preparedStatement);
      ConnectorDB.close(resultSet);
    }
    return entities;
  }
}
