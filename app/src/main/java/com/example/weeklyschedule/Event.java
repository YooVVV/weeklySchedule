package com.example.weeklyschedule;

import java.time.LocalTime;
import java.util.Date;

public class Event {
    protected String title;
    protected String description;
    protected Date start_time;
    protected Date end_time;
    protected int[] days;

    /**
     * @Description
     * The first constructor is for constructing a event without any information.
     */
    public Event() {
        title = "no title";
        description = "";
        start_time = new Date();
        end_time = new Date();
        days = new int[]{0, 0, 0, 0, 0, 0, 0};
    }

    /**
     * @Description
     * The second constructor is for the event does not have description.
     */
    public Event(String title, Date start_time, Date end_time, int[] days) {
        this.title = title;
        description = "";
        this.start_time = start_time;
        this.end_time = end_time;
        this.days = days;
    }

    /**
     * @Description
     * The third constructor is for the event has all information.
     */
    public Event(String title, String description, Date start_time, Date end_time, int[] days) {
        this.title = title;
        this.description = description;
        this.start_time = start_time;
        this.end_time = end_time;
        this.days = days;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription() {
        this.description = description;
    }

    public Date getStart_time() {
        return this.start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int[] getDays() {
        return this.days;
    }

    public void setDays(int[] days) {
        this.days = days;
    }

    /**
     * @Description
     * This method will check if the event is valid or not depending on its variable days,
     * start_time and end_time. If the event is valid, days should have 7 elements and
     * end_time should after start_time.
     */
    public boolean isValid() {
        return days.length == 7 && end_time.after(start_time);
    }
}
