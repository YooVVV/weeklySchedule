package com.example.weeklyschedule;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Calendar;

public class NewEventActivity extends AppCompatActivity implements View.OnClickListener{
    protected EditText eventTitle;
    protected EditText eventDescription;
    protected TextView eventStartTime;
    protected TextView eventEndTime;
    protected Button save_btn;
    protected Button cancel_btn;
    protected TimePickerDialog pickerStart;
    protected TimePickerDialog pickerEnd;
    protected int[] days;
    protected TextView mon, tue, wed, thu, fri, sat, sun;
    protected TextView[] weekDays;
    private Schedule schedule;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        days = new int[] {0,0,0,0,0,0,0};
        schedule = (Schedule) getIntent().getSerializableExtra("schedule");

        eventTitle = findViewById(R.id.new_event_title);
        eventDescription = findViewById(R.id.new_event_description);
        eventStartTime = findViewById(R.id.new_event_start_time);
        eventEndTime = findViewById(R.id.new_event_end_time);

        mon = findViewById(R.id.new_event_mon);
        tue = findViewById(R.id.new_event_tue);
        wed = findViewById(R.id.new_event_wed);
        thu = findViewById(R.id.new_event_thu);
        fri = findViewById(R.id.new_event_fri);
        sat = findViewById(R.id.new_event_sat);
        sun = findViewById(R.id.new_event_sun);
        weekDays = new TextView[] {mon, tue, wed, thu, fri, sat, sun};
        for (TextView tv: weekDays) {
            tv.setOnClickListener(this);
            tv.setTextColor(Color.GRAY);
        }

        eventStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cld = Calendar.getInstance();
                pickerStart = new TimePickerDialog(NewEventActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                eventStartTime.setText(TimeOfDay.structTime(hourOfDay, minute));
                            }
                        },
                        cld.get(Calendar.HOUR_OF_DAY), cld.get(Calendar.MINUTE), true);
                pickerStart.show();
            }
        });
        eventEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cld = Calendar.getInstance();
                pickerEnd = new TimePickerDialog(NewEventActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                eventEndTime.setText(TimeOfDay.structTime(hourOfDay, minute));
                            }
                        },
                        cld.get(Calendar.HOUR_OF_DAY), cld.get(Calendar.MINUTE), true);
                pickerEnd.show();
            }
        });

        save_btn = findViewById(R.id.new_event_save_btn);
        save_btn.setOnClickListener(this);
        cancel_btn = findViewById(R.id.new_event_cancel_btn);
        cancel_btn.setOnClickListener(this);
    }

    public void saveEvent() {
        if (eventTitle.getText().toString().equals("") ||
                eventStartTime.getText().toString().equals("XX:XX") ||
                eventEndTime.getText().toString().equals("XX:XX")) {
            Toast.makeText(getApplicationContext(),
                    "Please fill the non-optional blank.", Toast.LENGTH_SHORT).show();
            return;
        }
        String title = eventTitle.getText().toString();
        String description = eventDescription.getText().toString();
        TimeOfDay start_time = TimeOfDay.destructTime(eventStartTime.getText().toString());
        TimeOfDay end_time = TimeOfDay.destructTime(eventEndTime.getText().toString());

        if (start_time.after(end_time)) {
            Toast.makeText(getApplicationContext(),
                    "The end time should be after start time",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (Arrays.equals(days, new int[]{0, 0, 0, 0, 0, 0, 0})) {
            Toast.makeText(getApplicationContext(),
                    "Please select one or more days in a week",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Event event = new Event(title, description, start_time, end_time, days);
        if (!schedule.addEvent(event)) {
            Toast.makeText(getApplicationContext(),
                    "You have a same event or a conflict in your schedule",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        this.finish();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.new_event_save_btn:
                saveEvent();
                break;
            case R.id.new_event_cancel_btn:
                this.finish();
                break;
            case R.id.new_event_mon:
                selectDays(0);
                break;
            case R.id.new_event_tue:
                selectDays(1);
                break;
            case R.id.new_event_wed:
                selectDays(2);
                break;
            case R.id.new_event_thu:
                selectDays(3);
                break;
            case R.id.new_event_fri:
                selectDays(4);
                break;
            case R.id.new_event_sat:
                selectDays(5);
                break;
            case R.id.new_event_sun:
                selectDays(6);
                break;
            default:
                break;
        }
    }

    public void selectDays(int i) {
        System.out.println("change");
        if (days[i] == 0) {
            weekDays[i].setTextColor(Color.BLACK);
        } else {
            weekDays[i].setTextColor(Color.GRAY);
        }
        days[i] = trans01(days[i]);
        System.out.println(Arrays.toString(days));
    }

    public int trans01(int i) {
        if (i == 0) {
            return 1;
        }

        return 0;
    }
}
