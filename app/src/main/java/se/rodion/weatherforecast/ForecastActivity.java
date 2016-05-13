package se.rodion.weatherforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForecastActivity extends BaseActivity {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "695af22a082236e919e2abd71c552596";
    private static final String UNITS = "metric";

    private static final String TAG = ForecastActivity.class.getSimpleName();

    private String cityMessage;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private List<Forecast> list;
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
        Call<Forecast> result = weatherMap.getForecast(cityMessage, API_KEY, UNITS);

        result.enqueue(new Callback<Forecast>() {

            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {

                list = response.body().getList();

                createInfo();
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Toast.makeText(ForecastActivity.this, "Could not get response", Toast.LENGTH_LONG).show();
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
    }

    public void createInfo()
    {
        recyclerView = (RecyclerView) findViewById(R.id.names_recycler_view);
        layoutManager = new LinearLayoutManager(this);

        adapter = new ForecastAdapter(this, list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}
