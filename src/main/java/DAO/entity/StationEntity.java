package DAO.entity;

/**
 * Created by Anhelina_Khalii on 07.10.2015.
 */
public class StationEntity {
  private Integer idStation;
  private String city;
  private String state;
  private Float latN;
  private Float longW;

  public Integer getIdStation() {
    return idStation;
  }

  public void setIdStation(Integer idStation) {
    this.idStation = idStation;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Float getLatN() {
    return latN;
  }

  public void setLatN(Float latN) {
    this.latN = latN;
  }

  public Float getLongW() {
    return longW;
  }

  public void setLongW(Float longW) {
    this.longW = longW;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    StationEntity that = (StationEntity) o;

    if (idStation != null ? !idStation.equals(that.idStation) : that.idStation != null) {
      return false;
    }
    if (city != null ? !city.equals(that.city) : that.city != null) {
      return false;
    }
    if (state != null ? !state.equals(that.state) : that.state != null) {
      return false;
    }
    if (latN != null ? !latN.equals(that.latN) : that.latN != null) {
      return false;
    }
    return !(longW != null ? !longW.equals(that.longW) : that.longW != null);

  }

  @Override
  public int hashCode() {
    int result = idStation != null ? idStation.hashCode() : 0;
    result = 31 * result + (city != null ? city.hashCode() : 0);
    result = 31 * result + (state != null ? state.hashCode() : 0);
    result = 31 * result + (latN != null ? latN.hashCode() : 0);
    result = 31 * result + (longW != null ? longW.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "StationEntity{" +
           "idStation=" + idStation +
           ", city='" + city + '\'' +
           ", state='" + state + '\'' +
           ", latN=" + latN +
           ", longW=" + longW +
           '}';
  }
}
