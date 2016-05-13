package se.rodion.weatherforecast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPageActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = FirstPageActivity.class.getSimpleName();

    Button btnActWeatherTodayHome;
    Button btnActWeatherWeekHome;
    Button btnActWeatherSelectedCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        btnActWeatherTodayHome = (Button)findViewById(R.id.myButton1);
        btnActWeatherTodayHome.setOnClickListener(this);

        btnActWeatherWeekHome = (Button)findViewById(R.id.myButton2);
        btnActWeatherWeekHome.setOnClickListener(this);

        btnActWeatherSelectedCity = (Button)findViewById(R.id.myButton3);
        btnActWeatherSelectedCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent;
        switch (view.getId())
        {
            case R.id.myButton1:
                intent = new Intent(this, HomeWeatherActivity.class);
                startActivity(intent);
                break;
            case R.id.myButton2:
                intent = new Intent(this, EditCityActivity.class);
                startActivity(intent);
                break;
            case R.id.myButton3:
                intent = new Intent(this, WeekEditCityActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


}
