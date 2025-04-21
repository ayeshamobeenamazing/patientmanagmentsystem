
package assignment3.models;


public class Appointment {
    private String date;
    private String doctor;
    private String patient;
    private String status;
// constructor
    public Appointment(String date, String doctor, String patient) {
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
        this.status = "Pending"; // default status for the appointment
    }
    // getters
    public String getDoctor() { 
        return doctor; 
    }
    public String getPatient() { 
        return patient; 
    }
    public String getStatus() { 
        return status; 
    }
    // setter 
    public void setStatus(String status) { 
        this.status = status;
    }
     public void displayAppointment() {
        System.out.println("Appointment on " + date + " | Patient: " + patient + " | Doctor: " + doctor + " | Status: " + status);
    }
}
