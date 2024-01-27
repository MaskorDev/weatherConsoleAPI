package DTO;

import java.util.Objects;

public class CurrentResponse {
    private AirQuality airQuality;
    private Condition condition;
    private Current current;
    private  Location location;

    public AirQuality getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(AirQuality airQuality) {
        this.airQuality = airQuality;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentResponse that = (CurrentResponse) o;
        return Objects.equals(airQuality, that.airQuality) && Objects.equals(condition, that.condition) && Objects.equals(current, that.current) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airQuality, condition, current, location);
    }


    @Override
    public String toString() {
        return "CurrentResponse{" +
                "airQuality=" + airQuality +
                ", condition=" + condition +
                ", current=" + current +
                ", location=" + location +
                '}';
    }
}
