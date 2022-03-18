package com.example.weeklyschedule;

public class Event {
    protected String title;
    protected String description;
    protected TimeOfDay start_time;
    protected TimeOfDay end_time;
    protected int[] days;
    private static String timePattern = "HH:mm";

    /**
     * @Description
     * The first constructor is for constructing a event without any information.
     */
    public Event() {
        title = "no title";
        description = "no description";
        start_time = new TimeOfDay();
        end_time = new TimeOfDay();
        days = new int[]{0, 0, 0, 0, 0, 0, 0};
    }

    /**
     * @Description
     * The second constructor is for the event does not have description.
     */
    public Event(String title, TimeOfDay start_time, TimeOfDay end_time, int[] days) {
        this.title = title;
        description = "no description";
        this.start_time = start_time;
        this.end_time = end_time;
        this.days = days;
    }

    /**
     * @Description
     * The third constructor is for the event has all information.
     */
    public Event(String title, String description, TimeOfDay start_time, TimeOfDay end_time, int[] days) {
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

    public TimeOfDay getStart_time() {
        return this.start_time;
    }

    public void setStart_time(TimeOfDay start_time) {
        this.start_time = start_time;
    }

    public TimeOfDay getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(TimeOfDay end_time) {
        this.end_time = end_time;
    }

    public int[] getDays() {
        return this.days;
    }

    public void setDays(int[] days) {
        this.days = days;
    }

    public String toString() {
        String result = this.title + "\n" + this.description +
                "\n" + this.start_time +
                " " + this.end_time + "\n";
        String[] week = {"Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"};
        for (int i=0; i<7; i++) {
            if (days[i] == 1) {
                result += week[i] + " ";
            }
        }
        return result;
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

    /**
     * @Description
     * This method override equals function. If each variables of two events equal, it will return
     *  true. If any variable is different, it will return false.
     */
    public boolean equals(Event event) {
        for (int i=0; i<7; i++) {
            if (this.days[i] != event.getDays()[i]) {
                return false;
            }
        }

        return this.title.equals(event.getTitle()) &&
                this.description.equals(event.getDescription()) &&
                this.start_time.equals(event.getStart_time()) &&
                this.end_time.equals(event.getEnd_time());
    }

    /**
     * @Description
     * This method will check if the two events have a conflict time.
     */
    public boolean isConflict(Event event) {
        for (int i=0; i<7; i++) {
            if (this.days[i] == 1 && event.getDays()[i] == 1) {
                if (this.start_time.before(event.getStart_time()) ||
                        this.start_time.equals(event.getStart_time())) {
                    return this.end_time.after(event.getStart_time());
                }

                if (event.getStart_time().before(this.start_time) ||
                        event.getStart_time().equals(this.start_time)) {
                    return event.getEnd_time().after(this.start_time);
                }
            }
        }

        return true;
    }
}
