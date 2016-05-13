package se.rodion.weatherforecast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.menu_homepage:
                intent = new Intent(this, FirstPageActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_weather_home:
                intent = new Intent(this, HomeWeatherActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_select_city:
                intent = new Intent(this, EditCityActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_forecast:
                intent = new Intent(this, WeekEditCityActivity.class);
                startActivity(intent);
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}
