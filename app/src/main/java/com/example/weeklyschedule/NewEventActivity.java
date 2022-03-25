package com.example.weeklyschedule;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        eventTitle = findViewById(R.id.new_event_title);
        eventDescription = findViewById(R.id.new_event_description);
        eventStartTime = findViewById(R.id.new_event_start_time);
        eventEndTime = findViewById(R.id.new_event_end_time);

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
            default:
                break;
        }
    }
}
