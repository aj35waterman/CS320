package test;

import APPT.Appointment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentTest { 

    // using valid future date
    private Date future(int seconds) { 
        return new Date(System.currentTimeMillis() + (seconds * 1000)); //60 seconds in future
    }

    // helper: a past date
    private Date past(int seconds) {
        return new Date(System.currentTimeMillis() - (seconds * 1000)); //60 seconds in the past
    }

    @Test
    void createsValidAppointment() {
        Appointment appt = new Appointment("1", future(60), "work");
        assertEquals("1", appt.getApptId());
        assertNotNull(appt.getDate());
        assertEquals("work", appt.getDescription());
    }

    @Test
    void apptIdCannotBeNullOrTooLong() {
        assertThrows(IllegalArgumentException.class,() -> new Appointment(null, future(60), "work"));
        assertThrows(IllegalArgumentException.class,() -> new Appointment("1234567891011", future(60_000), "desc"));
    }

    @Test
    void dateCannotBeNullOrPast() {
        assertThrows(IllegalArgumentException.class,() -> new Appointment("2", null, "desc"));
        assertThrows(IllegalArgumentException.class,() -> new Appointment("2", past(10), "desc"));
    }

    @Test
    void descriptionCannotBeNullOrTooLong() {
        assertThrows(IllegalArgumentException.class,() -> new Appointment("3", future(60), null));
        String longDesc = "This Decription is going to be completely and utterly to long for use in this code"; // more then 50 chars
        assertThrows(IllegalArgumentException.class,() -> new Appointment("3", future(60), longDesc));
    }

    @Test
    void setDateValidatesAndUpdates() {
        Appointment appt = new Appointment("4", future(60), "school");
        Date later = future(120);
        appt.setDate(later);
        assertEquals(later, appt.getDate());

        // invalid update inputs
        assertThrows(IllegalArgumentException.class, () -> appt.setDate(null)); //inputting null
        assertThrows(IllegalArgumentException.class, () -> appt.setDate(past(10))); //in the past
    }

    @Test
    void setDescriptionValidatesAndUpdates() {
        Appointment appt = new Appointment("5", future(60), "gym");
        appt.setDescription("food");
        assertEquals("food", appt.getDescription());

        assertThrows(IllegalArgumentException.class, () -> appt.setDescription(null));
        
    }

    @Test
    void apptIdIsUnchangable() {
        Appointment appt = new Appointment("6", future(60), "gym");
        assertEquals("6", appt.getApptId());
        
    }
}