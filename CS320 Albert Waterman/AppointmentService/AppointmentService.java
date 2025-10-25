package APPT;

import java.util.HashMap;
import java.util.Map;
public class AppointmentService {
    private final Map<String, Appointment> appointments;

    // Default constructor
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    //add an appointment
    public void addAppointment(Appointment appointment) {
        String apptId = appointment.getApptId();
        if (appointments.containsKey(apptId)) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(apptId, appointment);
    }
    

    // Method to delete an appointment by ID
    public void deleteAppointment(String apptId) {
        if (!appointments.containsKey(apptId)) {
            throw new IllegalArgumentException("Appointment not found for given ID");
        }
        appointments.remove(apptId);
    }

    // getting appointment by ID
    public Appointment getAppointment(String apptId) {
        if (!appointments.containsKey(apptId)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        return appointments.get(apptId);
    }
}