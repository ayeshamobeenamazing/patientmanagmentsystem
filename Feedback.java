
package assignment3.models;


public class Feedback {
    private String doctor;
    private String patient;
    private String message;

    public Feedback(String doctor, String patient, String message) {
        this.doctor = doctor;
        this.patient = patient;
        this.message = message;
    }

    public void displayFeedback() {
        System.out.println("Doctor: " + doctor + " -> Patient: " + patient);
        System.out.println("Feedback: " + message);
    }
}
