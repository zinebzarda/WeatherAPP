import java.time.LocalDate;

public class CityHistory {

    private Integer historicalDataId;
    private Integer cityId;
    private LocalDate eventDate;
    private Integer temperature;

    public CityHistory(Integer historicalDataId, Integer cityId, LocalDate eventDate, Integer temperature) {
        this.historicalDataId = historicalDataId;
        this.cityId = cityId;
        this.eventDate = eventDate;
        this.temperature = temperature;
    }
    public CityHistory(){

    }

    public Integer getHistoricalDataId() {
        return historicalDataId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public LocalDate getEventDate() {
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

    public void setEventDate(LocalDate eventDate) {
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
