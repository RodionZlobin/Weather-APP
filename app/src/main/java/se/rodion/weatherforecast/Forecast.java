package se.rodion.weatherforecast;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Forecast {
    private List<Forecast> list;
    private String cod;
    private Main main;
    private String dt;
    private String dt_txt;
    private String weekDate;
    private String dayTime;
    private Wind wind;
    private List<Weather> weather;

    public Main getMain() {
        return main;
    }

    public String getCod() {
        return cod;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public List<Forecast> getList() {
        return list;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getDt_txt() {
        return dt_txt;
    }



    public List<Weather> getWeather() {
        return weather;
    }

    public Wind getWind() {
        return wind;
    }

    public String getDateData() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        return sdf.format(getCalendar().getTime());
    }

    public String getTimeData() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        return sdf.format(getCalendar().getTime());
    }

    public String getWeekDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");

        return sdf.format(getCalendar().getTime());
    }

    public String getDayTime() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        return sdf.format(getCalendar().getTime());
    }

    private Calendar getCalendar() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(getDt_txt());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }
}
