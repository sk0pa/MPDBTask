package DAO.tableinterface;

import java.sql.Connection;
import java.util.List;

import DAO.entity.StationEntity;

/**
 * Created by Anhelina_Khalii on 07.10.2015.
 */
public interface IStationDao {
  List<StationEntity> getAll(Connection connection);
}
