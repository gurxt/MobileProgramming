package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main_relative);
//        setContentView(R.layout.activity_main_grid);
//        setContentView(R.layout.activity_main_linear);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources resources = getResources();
                String toastMessage = resources.getString(R.string.toast_message);

                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();
            }
        });

        Switch switchBtn = findViewById(R.id.switch1);

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Resources resources = getResources();
                String on = resources.getString(R.string.on);
                String off = resources.getString(R.string.off);
                String text = isChecked ? on : off;
                String message = resources.getString(R.string.switch_message) + text;

                Snackbar snackbar = Snackbar.make(
                        findViewById(android.R.id.content),
                        message,
                        Snackbar.LENGTH_LONG
                );

                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switchBtn.setChecked(!isChecked);
                    }
                });

                snackbar.show();
            }
        });
    }
}