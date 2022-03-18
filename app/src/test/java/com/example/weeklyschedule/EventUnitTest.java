package com.example.weeklyschedule;

import org.junit.Test;
import static org.junit.Assert.*;

public class EventUnitTest {
    @Test
    public void createEmptyEvent() {
        Event event = new Event();
        System.out.println(event);
    }

    @Test
    public void createNoDescriptionEvent() {
        Event event = new Event("test event 2", new TimeOfDay(), new TimeOfDay(), new int[] {0,0,0,0,0,1,1});
        System.out.println(event);
    }

    @Test
    public void createDescriptionEvent() {
        Event event = new Event("test event 3", "This is a test event.",
                new TimeOfDay(), new TimeOfDay(), new int[] {1,1,0,1,0,1,0});
        System.out.println(event);
    }

    @Test
    public void equalEvent() {
        TimeOfDay time_s = new TimeOfDay();
        TimeOfDay time_e = new TimeOfDay();
        String title = "equal test title 1";
        String description = "equal test description 1.";
        int[] days = {0, 1, 1, 0, 1, 0, 0};

        Event event1 = new Event(title, description, time_s, time_e, days);
        Event event2 = new Event(title, description, time_s, time_e, days);

        assertTrue(event1.equals(event2));
    }

    @Test
    public void notEqualTitleEvent() {
        TimeOfDay time_s = new TimeOfDay();
        TimeOfDay time_e = new TimeOfDay();
        String title1 = "not equal test title 1";
        String title2 = "not equal test title 2";
        String description = "not equal test description 1.";
        int[] days = {0, 1, 1, 0, 1, 0, 0};

        Event event1 = new Event(title1, description, time_s, time_e, days);
        Event event2 = new Event(title2, description, time_s, time_e, days);

        assertFalse(event1.equals(event2));
    }

    @Test
    public void notEqualDescriptionEvent() {
        TimeOfDay time_s = new TimeOfDay();
        TimeOfDay time_e = new TimeOfDay();
        String title = "not equal test title 1";
        String description1 = "not equal test description 1.";
        String description2 = "not equal test description 2.";
        int[] days = {0, 1, 1, 0, 1, 0, 0};

        Event event1 = new Event(title, description1, time_s, time_e, days);
        Event event2 = new Event(title, description2, time_s, time_e, days);

        assertFalse(event1.equals(event2));
    }

    @Test
    public void notEqualTimeEvent() {
        String title = "not equal test title 1";
        String description = "not equal test description 1.";
        int[] days = {0, 1, 1, 0, 1, 0, 0};

        Event event1 = new Event(title, description, new TimeOfDay(1), new TimeOfDay(), days);
        Event event2 = new Event(title, description, new TimeOfDay(2), new TimeOfDay(), days);

        assertFalse(event1.equals(event2));
    }

    @Test
    public void notEqualDaysEvent() {
        TimeOfDay time_s = new TimeOfDay();
        TimeOfDay time_e = new TimeOfDay();
        String title = "not equal test title 1";
        String description = "not equal test description 1.";
        int[] days1 = {0, 1, 1, 0, 1, 0, 0};
        int[] days2 = {0, 1, 1, 1, 1, 0, 0};

        Event event1 = new Event(title, description, time_s, time_e, days1);
        Event event2 = new Event(title, description, time_s, time_e, days2);

        assertFalse(event1.equals(event2));
    }

    @Test
    public void validEvent() {
        Event event = new Event("valid test", new TimeOfDay(10), new TimeOfDay(11),
                new int[] {0,0,0,1,1,1,1});

        assertTrue(event.isValid());
    }

    @Test
    public void invalidTimeEvent() {
        Event event = new Event("invalid test", new TimeOfDay(11), new TimeOfDay(10),
                new int[] {0,0,0,0,0,1,1});

        assertFalse(event.isValid());
    }

    @Test
    public void invalidDaysEvent() {
        Event event = new Event("invalid test", new TimeOfDay(0), new TimeOfDay(1),
                new int[] {0});

        assertFalse(event.isValid());
    }

    @Test
    public void notConflictEvents() {
        Event event1 = new Event("not conflict test 1", new TimeOfDay(0),
                new TimeOfDay(1), new int[] {1,1,1,1,1,1,1});
        Event event2 = new Event("not conflict test 2", new TimeOfDay(1),
                new TimeOfDay(2), new int[] {1,1,1,1,1,1,1});

        assertFalse(event1.isConflict(event2));
    }

    @Test
    public void conflictEvents1() {
        Event event1 = new Event("conflict test 1", new TimeOfDay(1),
                new TimeOfDay(2), new int[] {1,1,1,1,1,1,1});
        Event event2 = new Event("conflict test 2", new TimeOfDay(1),
                new TimeOfDay(2), new int[] {1,1,1,1,1,1,1});

        assertTrue(event1.isConflict(event2));
    }

    @Test
    public void conflictEvents2() {
        Event event1 = new Event("conflict test 1", new TimeOfDay(1),
                new TimeOfDay(4), new int[] {1,1,1,1,1,1,1});
        Event event2 = new Event("conflict test 2", new TimeOfDay(2),
                new TimeOfDay(3), new int[] {1,1,1,1,1,1,1});

        assertTrue(event1.isConflict(event2));
    }

    @Test
    public void conflictEvents3() {
        Event event1 = new Event("conflict test 1", new TimeOfDay(1),
                new TimeOfDay(4), new int[] {1,1,1,1,1,1,1});
        Event event2 = new Event("conflict test 2", new TimeOfDay(2),
                new TimeOfDay(5), new int[] {1,1,1,1,1,1,1});

        assertTrue(event1.isConflict(event2));
    }

    @Test
    public void conflictEvents4() {
        Event event1 = new Event("conflict test 1", new TimeOfDay(2),
                new TimeOfDay(4), new int[] {1,1,1,1,1,1,1});
        Event event2 = new Event("conflict test 2", new TimeOfDay(1),
                new TimeOfDay(3), new int[] {1,1,1,1,1,1,1});

        assertTrue(event1.isConflict(event2));
    }

    @Test
    public void conflictEvents5() {
        Event event1 = new Event("conflict test 1", new TimeOfDay(2),
                new TimeOfDay(3), new int[] {1,1,1,1,1,1,1});
        Event event2 = new Event("conflict test 2", new TimeOfDay(1),
                new TimeOfDay(4), new int[] {1,1,1,1,1,1,1});

        assertTrue(event1.isConflict(event2));
    }
}
