package com.example.weeklyschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button add_schedule;
    private Button select_schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_schedule = findViewById(R.id.main_add_schdule_btn);
        add_schedule.setOnClickListener(this);
        select_schedule = findViewById(R.id.main_select_schdule_btn);
        select_schedule.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_add_schdule_btn:
                startActivity(new Intent(this, AddScheduleActivity.class));
                break;
            case R.id.main_select_schdule_btn:
                startActivity(new Intent(this, ScheduleListActivity.class));
                break;
            default:
                break;
        }
    }
}