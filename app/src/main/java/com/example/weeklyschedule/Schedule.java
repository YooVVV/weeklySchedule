package com.example.weeklyschedule;

import java.util.ArrayList;

public class Schedule {
    protected String name;
    protected ArrayList<Event> events;

    public Schedule() {
        this.name = "no name";
        this.events = new ArrayList<Event>();
    }

    public Schedule(String name) {
        this.name = name;
        this.events = new ArrayList<Event>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    /**
     * @Description
     * addEvent(Event) will check if the event can be added before adding
     */
    public boolean addEvent(Event event) {
        if (events.contains(event)) {
            return false;
        }

        for (Event e: events) {
            if (event.isConflict(e)) {
                return false;
            }
        }
        events.add(event);
        return true;
    }

    /**
     * @Description
     * Remove a event from arraylist
     */
    public boolean removeEvent(Event event) {
        return events.remove(event);
    }
}
