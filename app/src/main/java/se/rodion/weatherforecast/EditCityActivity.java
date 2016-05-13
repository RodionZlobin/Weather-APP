package se.rodion.weatherforecast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditCityActivity extends BaseActivity implements View.OnClickListener {

    private Button btnEditCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_city);

        btnEditCity = (Button) findViewById(R.id.edit_button);
        btnEditCity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_city);
        Intent intent = new Intent(this, SelectedCityActivity.class);
        intent.putExtra("message", editText.getText().toString());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }
}
