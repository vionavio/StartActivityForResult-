package com.viona.onactivityresult.javaold;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import com.viona.onactivityresult.MainActivity;
import com.viona.onactivityresult.R;
import com.viona.onactivityresult.utils.BetterActivityResult;

public class MainActivity1 extends AppCompatActivity {
    private TextView mTextViewResult;
    private EditText mEditTextNumber1;
    private EditText mEditTextNumber2;
    protected final BetterActivityResult<Intent, ActivityResult> activityLauncher = BetterActivityResult.registerActivityForResult(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old1);

        mTextViewResult = findViewById(R.id.text_view_result);
        mEditTextNumber1 = findViewById(R.id.edit_text_number1);
        mEditTextNumber2 = findViewById(R.id.edit_text_number2);

        Button buttonOpenActivity2 = findViewById(R.id.button_open_activity2);

        buttonOpenActivity2.setOnClickListener(v -> {
            if (mEditTextNumber1.getText().toString().equals("")
                    || mEditTextNumber2.getText().toString().equals("")) {
                Toast.makeText(MainActivity1.this, "Please insert numbers", Toast.LENGTH_SHORT).show();
            } else {

                int number1 = Integer.parseInt(mEditTextNumber1.getText().toString());
                int number2 = Integer.parseInt(mEditTextNumber2.getText().toString());

                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                intent.putExtra("number1", number1);
                intent.putExtra("number2", number2);
                startActivityForResult(intent, 1);
            }
        });
    }

    public void openSomeActivityForResult() {
        Intent intent = new Intent(this, MainActivity.class);
        activityLauncher.launch(intent, result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                // There are no request codes
                Intent data = result.getData();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                mTextViewResult.setText("" + result);
            }
            if (resultCode == RESULT_CANCELED) {
                mTextViewResult.setText("Nothing selected");
            }
        }
    }
}