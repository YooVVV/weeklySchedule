package com.example.weeklyschedule;

import org.junit.Test;
import static org.junit.Assert.*;

public class ScheduleUnitTest {
    private Event event1 = new Event("test event 1", new TimeOfDay(3, 30),
            new TimeOfDay(4), new int[] {1,1,1,1,1,0,0});
    private Event event2 = new Event("test event 2", new TimeOfDay(5),
            new TimeOfDay(5, 30), new int[] {1,1,1,1,1,0,0});
    @Test
    public void createSchedule() {
        Schedule schedule = new Schedule("test schedule");

        System.out.println(schedule);
    }

    @Test
    public void addEvent() {
        Schedule schedule = new Schedule("test schedule");

        assertTrue(schedule.addEvent(event1));
    }

    @Test
    public void addDuplicatedEvent() {
        Schedule schedule = new Schedule("test schedule");
        schedule.addEvent(event1);

        assertFalse(schedule.addEvent(event1));
    }

    @Test
    public void addMoreEvent() {
        Schedule schedule = new Schedule("test schedule");
        schedule.addEvent(event1);

        assertTrue(schedule.addEvent(event2));
    }

    @Test
    public void removeEvent() {
        Schedule schedule = new Schedule("test schedule");
        schedule.addEvent(event1);
        schedule.removeEvent(event1);

        assertFalse(schedule.getEvents().contains(event1));
    }
}
