package test;

import APPT.Appointment;
import APPT.AppointmentService;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    private AppointmentService service;

    // creating a valid future date
    private Date futureDate() {
        return new Date(System.currentTimeMillis() + 1000); //using currentTimeMillis() I am able to go 60 seconds into the future
    }

    @BeforeEach
    void setUp() { //allows new instance before each test
        service = new AppointmentService();
    }

    @Test
    void testAddAppointment() {
        Appointment appt = new Appointment("1", futureDate(), "work");
        service.addAppointment(appt);
        Appointment stored = service.getAppointment("1");
        assertEquals("1", stored.getApptId());
        assertEquals("work", stored.getDescription()); 
    }

    @Test
    void testAddDuplicateApptIdThrows() {
        Appointment appt1 = new Appointment("2", futureDate(), "work");
        Appointment appt2 = new Appointment("2", futureDate(), "gym");
        service.addAppointment(appt1);
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appt2));
    }

    @Test
    void testDeleteAppointment() {
        Appointment appt = new Appointment("3", futureDate(), "eat");
        service.addAppointment(appt);
        service.deleteAppointment("3");
        assertThrows(IllegalArgumentException.class, () -> service.getAppointment("3"));
    }

    @Test
    void testDeleteNonExistentApptIdThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("4"));
    }

    @Test
    void testGetAppointmentNotFoundThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.getAppointment("5"));
    }
}
