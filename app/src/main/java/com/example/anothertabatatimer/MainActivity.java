package com.example.anothertabatatimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Hello";

    int work_seconds = 20;
    int rest_seconds = 10;
    int rounds = 8;
    EditText seconds_input;
    EditText rest_input;
    EditText rounds_input;

    Button start_w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seconds_input = (EditText) findViewById(R.id.seconds_input);
        rest_input = (EditText) findViewById(R.id.rest_input);
        rounds_input = (EditText) findViewById(R.id.rounds_input);
        start_w = (Button) findViewById(R.id.btn_start);
        start_w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                work_seconds = Integer.parseInt(seconds_input.getText().toString());
                rest_seconds = Integer.parseInt(rest_input.getText().toString());
                rounds = Integer.parseInt(rounds_input.getText().toString());
                openWorkout();
            }
        });
    }

    public void openWorkout(){
        Intent intent = new Intent(this, TabataTimer.class);
        intent.putExtra("work", work_seconds);
        intent.putExtra("rest", rest_seconds);
        intent.putExtra("rounds", rounds);
        startActivity(intent);
    }

    private void showToast (String txt){
        Toast.makeText(MainActivity.this, txt, Toast.LENGTH_SHORT).show();
    }
}