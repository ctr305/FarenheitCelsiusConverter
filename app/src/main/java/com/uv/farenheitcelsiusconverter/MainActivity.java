package com.uv.farenheitcelsiusconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edit_temperature = (EditText) findViewById(R.id.edit_temperature);
        TextView temperature_result = (TextView) findViewById(R.id.temperature_result);
        Button btn_convert = (Button) findViewById(R.id.btn_convert);

        btn_convert.setOnClickListener(v -> {
            String temperature = edit_temperature.getText().toString();
            if (temperature.isEmpty() || temperature.matches(".*[a-zA-Z]+.*")) {
                temperature_result.setText(R.string.valid_temperature_error);
            } else {
                double temp = Double.parseDouble(temperature);
                double result = (temp - 32) * 5 / 9;
                temperature_result.setText(result + "°C");
            }
        });
    }
}