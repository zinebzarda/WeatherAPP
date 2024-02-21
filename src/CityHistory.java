public class CityHistory {

    private Integer historicalDataId;
    private Integer cityId;
    private String eventDate;
    private Integer temperature;

    public CityHistory(Integer historicalDataId, Integer cityId, String eventDate, Integer temperature) {
        this.historicalDataId = historicalDataId;
        this.cityId = cityId;
        this.eventDate = eventDate;
        this.temperature = temperature;
    }

    public Integer getHistoricalDataId() {
        return historicalDataId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setHistoricalDataId(Integer historicalDataId) {
        this.historicalDataId = historicalDataId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "CityHistory :\t" +
                "historicalDataId=" + historicalDataId +
                "\t, cityId=" + cityId +
                " \t, eventDate =" + eventDate +
                " \t, temperature =" + temperature;
    }

}
