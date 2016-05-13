package se.rodion.weatherforecast;


public class WeatherCondition {

    private String name;
    private Main main;

    public String getName() {
        return name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setName(String name) {
        this.name = name;
    }
}
