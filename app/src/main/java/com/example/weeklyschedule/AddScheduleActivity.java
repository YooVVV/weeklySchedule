package com.example.weeklyschedule;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddScheduleActivity extends AppCompatActivity implements View.OnClickListener {
    protected Button cancel;
    protected ArrayList<Event> events;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        cancel = findViewById(R.id.add_schedule_activity_cancle_btn);
        cancel.setOnClickListener(this);
        events = new ArrayList<Event>();
    }

    public void saveSchedule() {

    }

    public void addEvent() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_schedule_activity_cancle_btn:
                this.finish();
                break;
            case R.id.add_schedule_activity_save_btn:
                saveSchedule();
                break;
            case R.id.add_schedule_activity_plus_btn:
                addEvent();
                break;
            default:
                break;
        }
    }
}
