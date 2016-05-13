package se.rodion.weatherforecast;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SelectedCityActivity extends BaseActivity {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "695af22a082236e919e2abd71c552596";
    private static final String UNITS = "metric";

    private String cityMessage;

    private static final String TAG = SelectedCityActivity.class.getSimpleName();

    private TextView textViewTemperature;
    private TextView textViewCity;

    private Retrofit retrofit;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle bundle = getIntent().getExtras();
        cityMessage = bundle.getString("message").trim();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherMap weatherMap = retrofit.create(WeatherMap.class);
        final Call<WeatherCondition> result = weatherMap.getTemperature(cityMessage, API_KEY, UNITS);

        result.enqueue(new Callback<WeatherCondition>() {

            @Override
            public void onResponse(Call<WeatherCondition> call, Response<WeatherCondition> response) {

                if (response.body().getName().toLowerCase().equals(cityMessage.toLowerCase())) {


                    saveData(response.body().getMain().getTemperatureFormated());

                    String temperature = readData();

                    textViewTemperature = (TextView) findViewById(R.id.temperature_city);
                    textViewTemperature.setText(temperature);

                    textViewCity = (TextView) findViewById(R.id.selected_city);
                    textViewCity.setText(response.body().getName());
                } else
                {
                    Toast.makeText(SelectedCityActivity.this, "Could not get response", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherCondition> call, Throwable t) {
                Toast.makeText(SelectedCityActivity.this, "Could not get response", Toast.LENGTH_LONG).show();


            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_city);
    }


    private void saveData(String temp) {

        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(cityMessage, temp);
        editor.commit();
    }


    private String readData() {
        return getPreferences(Context.MODE_PRIVATE).getString(cityMessage, "");
    }
}
