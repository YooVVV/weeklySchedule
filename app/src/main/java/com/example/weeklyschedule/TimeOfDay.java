package com.example.weeklyschedule;

import java.util.Calendar;

public class TimeOfDay {
    private int hour;
    private int minute;

    /**
     * @Description
     * The first constructor create current time.
     */
    public TimeOfDay() {
        Calendar now = Calendar.getInstance();
        this.hour = now.get(Calendar.HOUR);
        this.minute = now.get(Calendar.MINUTE);
    }

    /**
     * @Description
     * The second constructor create a time has input hour and 0 minute.
     */
    public TimeOfDay(int hour) {
        this.hour = hour;
        this.minute = 0;
    }

    /**
     * @Description
     * The last constructor create a time with input hour and minute.
     */
    public TimeOfDay(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String toString() {
        return structTime(hour, minute);
    }

    /**
     * @Description
     * This method override equals function. If hour and minute of two TimeOfDay equal, it
     *  will return true, otherwise, it will return false.
     */
    public boolean equals(TimeOfDay tod) {
        return this.hour == tod.getHour() && this.minute == tod.getMinute();
    }

    /**
     * @Description
     * This method will compare the time. The method will return true if hour is smaller
     *  than input's or hour is equal and minute is smaller. Otherwise, it will return
     *  false.
     */
    public boolean before(TimeOfDay tod) {
        if (this.hour > tod.getHour()) {
            return false;
        } else if (this.hour == tod.getHour() && this.minute >= tod.getMinute()) {
            return false;
        }
        return true;
    }

    /**
     * @Description
     * This method will compare the time. The method will return true if hour is greater
     *  than input's or hour is equal and minute is greater. Otherwise, it will return
     *  false.
     */
    public boolean after(TimeOfDay tod) {
        if (this.hour < tod.hour) {
            return false;
        } else if (this.hour == tod.getHour() && this.minute <= tod.getMinute()) {
            return false;
        }
        return true;
    }

    public static String structTime(int hour, int minute) {
        String h, m;
        h = String.valueOf(hour);
        m = String.valueOf(minute);
        if (hour < 10) {
            h = "0" + h;
        }
        if (minute < 10) {
            m = "0" + m;
        }

        return h + ":" + m;
    }
}
