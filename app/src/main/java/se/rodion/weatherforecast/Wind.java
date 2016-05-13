package se.rodion.weatherforecast;


public class Wind {

    private String speed;

    public String getSpeed() {
        return speed;
    }

    public String getSpeedMS()
    {
        StringBuilder speedMS = new StringBuilder();
        speedMS.append(this.speed);
        speedMS.append(" m/s");

        return speedMS.toString();
    }
}
