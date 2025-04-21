
package assignment3.models;

import java.util.ArrayList;


public class Patient extends User implements ChatClient {
    private final ArrayList<VitalSign> vitalsList = new ArrayList<>();        
    private final ArrayList<Appointment> appointments = new ArrayList<>(); 
    private final ArrayList<Feedback> feedbackList = new ArrayList<>(); 
    private MedicalHistory medicalHist;
      
     // constructor 
     public Patient(String name, String email, String id) {
        super(name, id, email);
     }
     // getters
    public ArrayList<VitalSign> getVitalsList() { 
        return vitalsList; 
    }
    public ArrayList<Feedback> getFeedbackList() { 
        return feedbackList; 
    }
    public ArrayList<Appointment> getAppointments() { 
        return appointments; 
    }
    public void scheduleAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment scheduled for " + this.getName() + " with " + appointment.getDoctor());
    }
public void viewFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
        } else {
            System.out.println("Doctor Feedback for " + getName() + ":");
            for (Feedback f : feedbackList) {
                f.displayFeedback();
            }
        }
    }
public void uploadVitals(VitalSign vital, Doctor doctor) {
        vitalsList.add(vital);
        System.out.println("Vitals uploaded successfully.");
        EmergencyAlert.checkVitals(this, doctor);
    }

 public void viewMedicalHistory() {
        medicalHist.displayMedicalHistory();
    } 
  // patient feedback 
    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
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
