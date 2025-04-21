
package assignment3.models;

import java.util.ArrayList;


public class Doctor extends User implements ChatClient {
    private String specialization;
    private ArrayList<Patient> patientsList;
    private ArrayList<Appointment> docappointmentsList;
    private ArrayList<Feedback> feedbackList;

 // constructor   
    public Doctor(String name, String email, String id, String specialization) {
        super(name, id, email);
        this.specialization = specialization;
        this.patientsList = new ArrayList<>();
        this.docappointmentsList = new ArrayList<>();
        this.feedbackList= new ArrayList<>();
    }
    
    public void addAppointment(Appointment appointment) {
        docappointmentsList.add(appointment);
        System.out.println("Appointment added for " + appointment.getPatient() + " with Dr. " + this.getName());
    }
    public void provideFeedback(Patient patient, String message) {
        Feedback feedback = new Feedback(this.getName(), patient.getName(), message);
        patient.addFeedback(feedback); 
        System.out.println("Feedback provided to " + patient.getName() + ".");
    }
    public void viewAppointments() {
        System.out.println("\nDoctor's Appointments");
        if (docappointmentsList.isEmpty()) {
            System.out.println("No scheduled appointments.");
        } else {
            for (Appointment a : docappointmentsList) {
                System.out.println(" " + a);
            }
        }
    }
    @Override
    public void sendMessage(User receiver, String message) {
        ChatServer.sendMessage(this, receiver, message);
    }

    @Override
    public void viewChatHistory() {
        ChatServer.showChatHistory();
    }
}
