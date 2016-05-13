package se.rodion.weatherforecast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WeekEditCityActivity extends BaseActivity implements View.OnClickListener {

    private Button btnEditCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_edit_city);

        btnEditCity = (Button) findViewById(R.id.edit_button_week);
        btnEditCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_city_week);
        Intent intent = new Intent(this, ForecastActivity.class);
        intent.putExtra("message", editText.getText().toString());
        startActivity(intent);
    }
}
