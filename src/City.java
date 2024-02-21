public class City {

  private Integer   cityId ;

 private String cityName ;

private Float currentTemperature;

private Float currentHumidity;

 private Float currentWindSpeed;

//---------------constrictor
 public City(Integer cityId, String cityName, Float currentTemperature ,Float currentHumidity, Float currentWindSpeed){

     this.cityId = cityId;
     this.cityName = cityName;
     this.currentTemperature = currentTemperature;
     this.currentHumidity = currentHumidity;
     this.currentWindSpeed = currentWindSpeed;
 }

 // -------------- grtters---------
    public Integer getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public Float getCurrentTemperature() {
        return currentTemperature;
    }

    public Float getCurrentHumidity() {
        return currentHumidity;
    }

    public Float getCurrentWindSpeed() {
        return currentWindSpeed;
    }
    // ------------ setters --------------


    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCurrentTemperature(Float currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public void setCurrentHumidity(Float currentHumidity) {
        this.currentHumidity = currentHumidity;
    }

    public void setCurrentWindSpeed(Float currentWindSpeed) {
        this.currentWindSpeed = currentWindSpeed;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", currentTemperature=" + currentTemperature +
                ", currentHumidity=" + currentHumidity +
                ", currentWindSpeed=" + currentWindSpeed +
                '}';
    }

}