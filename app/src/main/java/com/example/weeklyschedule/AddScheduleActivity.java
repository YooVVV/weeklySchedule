package com.example.weeklyschedule;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddScheduleActivity extends AppCompatActivity
        implements View.OnClickListener, EventListAdapter.ItemClickListener {
    protected Button cancel;
    protected Button save_btn;
    protected Button plus_btn;
    protected ArrayList<Event> events;
    protected SQLiteDatabase db;
    protected RecyclerView eventList;
    protected EventListAdapter adapter;
    protected Schedule schedule;
    protected EditText schedule_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);

        cancel = findViewById(R.id.add_schedule_activity_cancle_btn);
        cancel.setOnClickListener(this);
        save_btn = findViewById(R.id.add_schedule_activity_save_btn);
        save_btn.setOnClickListener(this);
        plus_btn = findViewById(R.id.add_schedule_activity_plus_btn);
        plus_btn.setOnClickListener(this);

        eventList = findViewById(R.id.add_schedule_activity_event_list);
        events = new ArrayList<Event>();
        schedule_name = findViewById(R.id.add_schedule_activity_name);
        schedule = new Schedule(schedule_name.getText().toString());
        schedule.setEvents(events);

        //db = openOrCreateDatabase("DB_SCHEDULE", MODE_PRIVATE, null);
        displayEvents();
    }

    public void displayEvents() {
        eventList.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> event_intro = new ArrayList<String>();
        for (Event event: events) {
            event_intro.add(event.toString());
        }

        adapter = new EventListAdapter(this, event_intro);
        adapter.setClickListener(this);
        eventList.setAdapter(adapter);
    }

    /**
     * @Description
     * This method is used when editing schedule.
     */
    public void readEvents() {
        events.clear();
    }

    public void saveSchedule() {
        if (schedule_name.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Please set the name for your schedule", Toast.LENGTH_SHORT).show();
            return;
        }
        /*
        db.execSQL("CREATE TABLE IF NOT EXISTS schedule(schedule_name VARCHAR, scheduleID INT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS events(title VARCHAR, description VARCHAR, " +
                "start_h INT, start_m INT, end_h INT, end_m INT, days INT, scheduleID INT);");
         */
        schedule.setName(schedule_name.getText().toString());
        //upload events and schedule to sql

        this.finish();
    }

    public void addEvent() {
        System.out.println("New Event Page");
        Intent intent = new Intent(this, NewEventActivity.class);
        intent.putExtra("schedule", schedule);
        startActivity(intent);
    }

    @SuppressLint("NonConstantResourceId")
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

    @Override
    public void onItemClick(View view, int position) {

    }
}
