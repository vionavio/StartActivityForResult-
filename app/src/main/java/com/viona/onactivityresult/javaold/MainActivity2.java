package com.viona.onactivityresult.javaold;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.viona.onactivityresult.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old2);

        setTitle("Activity 2");

        Intent intent = getIntent();
        final int number1 = intent.getIntExtra("number1", 0);
        final int number2 = intent.getIntExtra("number2", 0);

        TextView textViewNumbers = findViewById(R.id.text_view_numbers);
        textViewNumbers.setText("Numbers: " + number1 + ", " + number2);

        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonSubtract = findViewById(R.id.button_subtract);

        buttonAdd.setOnClickListener(v -> {
            int result = number1 + number2;

            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", result);

            setResult(RESULT_OK, resultIntent);
            finish();
        });

        buttonSubtract.setOnClickListener(v -> {
            int result = number1 - number2;

            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", result);

            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}