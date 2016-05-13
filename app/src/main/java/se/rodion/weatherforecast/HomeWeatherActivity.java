package se.rodion.weatherforecast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeWeatherActivity extends BaseActivity {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "695af22a082236e919e2abd71c552596";
    private static final String CITY = "Stockholm";
    private static final String UNITS = "metric";

    private static final String TAG = HomeWeatherActivity.class.getSimpleName();

    private TextView textViewTemperature;
    private TextView textViewCity;

    private Retrofit retrofit;
    public Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherMap weatherMap = retrofit.create(WeatherMap.class);
        Call<WeatherCondition> result = weatherMap.getTemperature(CITY, API_KEY, UNITS);

        result.enqueue(new Callback<WeatherCondition>() {

            @Override
            public void onResponse(Call<WeatherCondition> call, Response<WeatherCondition> response) {

                textViewTemperature = (TextView) findViewById(R.id.temperature_home);
                textViewTemperature.setText(response.body().getMain().getTemperatureFormated());

                textViewCity = (TextView) findViewById(R.id.homecity);
                textViewCity.setText(response.body().getName());

            }

            @Override
            public void onFailure(Call<WeatherCondition> call, Throwable t) {
                Toast.makeText(HomeWeatherActivity.this, "Could not get response", Toast.LENGTH_LONG).show();
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_weather);
    }


    /*
    //alternative possibility to call another activity by menu
    //it  needs to declare onClick i MenuItem => android:onClick="handleHom" or another method
    public void handleHome(MenuItem item) {
        Intent intent = new Intent(this, FirstPageActivity.class);
        startActivity(intent);
    }

    public void handleWeatherHome(MenuItem item) {
        Intent intent = new Intent(this, HomeWeatherActivity.class);
        startActivity(intent);
    }

    public void handleSelectCity(MenuItem item) {
        Intent intent = new Intent(this, EditCityActivity.class);
        startActivity(intent);
    }

    public void handleForecast(MenuItem item) {
        Intent intent = new Intent(this, ForecastActivity.class);
        startActivity(intent);
    }
    */
}
