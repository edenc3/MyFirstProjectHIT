package com.example.myfirstprojecthit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Application;
import android.os.StrictMode;
import android.os.StrictMode.OnVmViolationListener;
import android.os.StrictMode.VmPolicy;
import android.os.strictmode.Violation;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Executor;
public class MainActivity extends AppCompatActivity {
    TextView result;

    int number = 0;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.textViewResult);
    }

    public void buttonClickNumbers(View view) {
        if (!(view instanceof Button)) {
            return;
        }

        Button button = (Button)view;
        String str = button.getText().toString();
        result.append(str);
    }

    public void buttonClickOperators(View view) {
        if (!(view instanceof Button)) {
            return;
        }

        Button button = (Button)view;
        operator = button.getText().toString();
        number = Integer.parseInt(result.getText().toString());
        result.setText("");
    }

    public void buttonClickEquals(View view) {
        if (!(view instanceof Button)) {
            return;
        }

        int current = Integer.parseInt(result.getText().toString());

        switch (operator)
        {
            case "+":
                number += current;
                break;
            case "-":
                number -= current;
                break;
            case "*":
                number *= current;
                break;
            case "/":
                number /= current;
                break;
        }

        result.setText(Integer.toString(number));
    }

    public void buttonClickClear(View view) {
        if (!(view instanceof Button)) {
            return;
        }

        result.setText("");
        number = 0;
        operator = "";
    }
}