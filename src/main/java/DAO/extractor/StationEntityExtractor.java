package DAO.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.entity.StationEntity;

/**
 * Created by Anhelina_Khalii on 07.10.2015.
 */
public class StationEntityExtractor {
  public static StationEntity extract(ResultSet resultSet) throws SQLException{
    StationEntity stationEntity = new StationEntity();

    stationEntity.setIdStation(resultSet.getInt("ID"));
    stationEntity.setCity(resultSet.getString("CITY"));
    stationEntity.setState(resultSet.getString("STATE"));
    stationEntity.setLatN(resultSet.getFloat("LAT_N"));
    stationEntity.setLongW(resultSet.getFloat("LONG_W"));

    return stationEntity;
  }

}
