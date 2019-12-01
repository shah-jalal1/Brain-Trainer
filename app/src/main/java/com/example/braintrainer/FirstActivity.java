package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sumButton;
    private Button subButton;
    private Button mulButton;
    private Button divButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        sumButton = (Button) findViewById(R.id.sumButtonId);
        subButton = (Button) findViewById(R.id.subButtonId);
        mulButton = (Button) findViewById(R.id.mulButtonId);
        divButton = (Button) findViewById(R.id.divideButtonId);

        sumButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.sumButtonId) {
            Intent intent = new Intent(FirstActivity.this, MainActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.subButtonId) {
            Intent intent = new Intent(FirstActivity.this, SubActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.mulButtonId) {
            Intent intent = new Intent(FirstActivity.this, MultiplyActivity.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.divideButtonId) {
            Intent intent = new Intent(FirstActivity.this, DivideActivity.class);
            startActivity(intent);
        }

    }
}
