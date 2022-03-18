package com.example.weeklyschedule;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeOfDayUnitTest {
    @Test
    public void emptyConstructor() {
        TimeOfDay tod = new TimeOfDay();
        System.out.println(tod);
    }

    @Test
    public void hourConstructor() {
        TimeOfDay tod = new TimeOfDay(10);
        System.out.println(tod);
    }

    @Test
    public void allConstructor() {
        TimeOfDay tod = new TimeOfDay(10, 10);
        System.out.println(tod);
    }

    @Test
    public void equalTime() {
        TimeOfDay tod1 = new TimeOfDay(12, 12);
        TimeOfDay tod2 = new TimeOfDay(12, 12);

        assertTrue(tod1.equals(tod2));
    }

    @Test
    public void notEqualTime() {
        TimeOfDay tod1 = new TimeOfDay(10, 10);
        TimeOfDay tod2 = new TimeOfDay(9, 9);

        assertFalse(tod1.equals(tod2));
    }

    @Test
    public void beforeTime() {
        TimeOfDay tod1 = new TimeOfDay(10);
        TimeOfDay tod2 = new TimeOfDay(11);

        assertTrue(tod1.before(tod2));
    }

    @Test
    public void beforeSameHour() {
        TimeOfDay tod1 = new TimeOfDay(10, 0);
        TimeOfDay tod2 = new TimeOfDay(10, 1);

        assertTrue(tod1.before(tod2));
    }

    @Test
    public void notBeforeTime() {
        TimeOfDay tod1 = new TimeOfDay(11);
        TimeOfDay tod2 = new TimeOfDay(10);

        assertFalse(tod1.before(tod2));
    }

    @Test
    public void notBeforeSameHour() {
        TimeOfDay tod1 = new TimeOfDay(10, 1);
        TimeOfDay tod2 = new TimeOfDay(10, 0);

        assertFalse(tod1.before(tod2));
    }

    @Test
    public void afterTime() {
        TimeOfDay tod1 = new TimeOfDay(11);
        TimeOfDay tod2 = new TimeOfDay(10);

        assertTrue(tod1.after(tod2));
    }

    @Test
    public void afterSameHour() {
        TimeOfDay tod1 = new TimeOfDay(10, 1);
        TimeOfDay tod2 = new TimeOfDay(10, 0);

        assertTrue(tod1.after(tod2));
    }

    @Test
    public void notAfterTime() {
        TimeOfDay tod1 = new TimeOfDay(10);
        TimeOfDay tod2 = new TimeOfDay(11);

        assertFalse(tod1.after(tod2));
    }

    @Test
    public void notAfterSameHour() {
        TimeOfDay tod1 = new TimeOfDay(10, 0);
        TimeOfDay tod2 = new TimeOfDay(10, 1);

        assertFalse(tod1.after(tod2));
    }
}
