package APPT;

import java.util.Date;

public class Appointment {
    private final String apptId;   //un-changeable
    private String description;
    private Date date;

    // constructor
    public Appointment(String apptId, Date date, String description) {
    	Date currentDate = new Date();

        if (apptId == null || apptId.length() > 10) {
            throw new IllegalArgumentException("Invalid Appointment ID");
        }
        if (date == null || date.before(currentDate)) {
            throw new IllegalArgumentException("Invalid Date");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.apptId = apptId;
        this.date = date;
        this.description = description;
    }
    // Getter date
    public String getApptId() {return apptId;}
    public Date getDate() {return date;}

    // Setter date
    public void setDate(Date date) {
        Date currentDate = new Date();
        if (date == null || date.before(currentDate)) {
            throw new IllegalArgumentException("Invalid Date");
        }
        this.date = date;
    }

    // Getter description
    public String getDescription() {
    	return description;
    	}

    // Setter description
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.description = description;
    }
	
}
