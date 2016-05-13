package se.rodion.weatherforecast;



public class Main {
    private String temp;
    private String temp_min;
    private String temp_max;


    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public String getAverageTemp()
    {
        StringBuilder averageTemperature = new StringBuilder();
        double minTemp = Double.parseDouble(this.temp_min);
        double maxTemp = Double.parseDouble(this.temp_max);
        double averageTempDouble = (minTemp + maxTemp)/2;
        long averageTempLong = Math.round(averageTempDouble);


        if(averageTempLong > 0)
        {
            averageTemperature.append("+");
        }
        averageTemperature.append(Long.toString(averageTempLong));

        averageTemperature.append(" °C");

        return averageTemperature.toString();
    }

    public String getTemperatureFormated()
    {
        StringBuilder temperatureFormated = new StringBuilder();

        double temperature = Double.parseDouble(this.temp);
        long temperatureRounded = Math.round(temperature);

        if(temperatureRounded > 0)
        {
            temperatureFormated.append("+");
        }
        temperatureFormated.append(Long.toString(temperatureRounded));
        temperatureFormated.append(" °C");

        return temperatureFormated.toString();
    }
}
