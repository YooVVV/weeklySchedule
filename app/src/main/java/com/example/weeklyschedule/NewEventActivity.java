package com.example.weeklyschedule;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewEventActivity extends AppCompatActivity implements View.OnClickListener{
    protected EditText eventTitle;
    protected EditText eventDescription;
    protected EditText eventStartTime;
    protected EditText eventEndTime;
    protected Button save_btn;
    protected Button cancel_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        eventTitle = findViewById(R.id.new_event_title);
        eventDescription = findViewById(R.id.new_event_description);
        eventStartTime = findViewById(R.id.new_event_start_time);
        eventEndTime = findViewById(R.id.new_event_end_time);

        save_btn = findViewById(R.id.new_event_save_btn);
        save_btn.setOnClickListener(this);
        cancel_btn = findViewById(R.id.new_event_cancel_btn);
        cancel_btn.setOnClickListener(this);
    }

    public void saveEvent() {

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
