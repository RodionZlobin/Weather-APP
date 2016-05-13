package se.rodion.weatherforecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherMap {
    @GET("weather")
    Call<WeatherCondition> getTemperature(@Query("q") String city,
                                          @Query("APPID") String apiKey,
                                          @Query("units") String units);

    @GET("forecast")
    Call<Forecast> getForecast(@Query("q") String city,
                               @Query("APPID") String apiKey,
                               @Query("units") String units);
}
